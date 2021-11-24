package server;

import java.io.*;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class Main {
    private static final String DB_URL = "jdbc:postgresql://localhost:3302/postgres";
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "12345678";
    private static Connection connection = null;
    private static PreparedStatement ps  = null;
    private static Statement statement  = null;

    public static void main(String[] args) {

        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(DB_URL, LOGIN, PASSWORD);
            if (connection != null) {
                System.out.println("Подключение к базе данных прошло успешно!\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sqlExecuteUpdate("DROP TABLE product");
        sqlCreateTable();
//        sqlExecuteUpdate("DELETE FROM product");
        sqlInsertData();
        sqlSelectAll();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("\nКонсольные команды: ");
                System.out.println("/цена {ТОВАР}");
                System.out.println("/сменитьцену {ТОВАР} {ЦЕНА}");
                System.out.println("/товарыпоцене {ЦЕНА ОТ} {ЦЕНА ДО}");
                System.out.println("/всетовары");
                System.out.println("/выход");
                System.out.println("Введите команду: \n");
                String response = br.readLine();
                if (response.startsWith("/цена")) {
                    sqlSelectPrice(response.split(" ")[1]);
                } else if (response.startsWith("/сменитьцену")) {
                    String arg1 = response.split(" ")[1];
                    Double arg2 = Double.parseDouble(response.split(" ")[2]);
                    sqlUpdatePrice(arg1, arg2);
                } else if (response.startsWith("/товарыпоцене")) {
                    Double arg1 = Double.parseDouble(response.split(" ")[1]);
                    Double arg2 = Double.parseDouble(response.split(" ")[2]);
                    sqlSelectPricesBetween(arg1, arg2);
                } else if (response.startsWith("/всетовары")) {
                    sqlSelectAll();
                } else if (response.startsWith("/выход")) {
                    System.exit(0);
                } else {
                    System.out.println("Команда неверна!");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                ps.close();
                connection.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void sqlExecuteUpdate(String SQLQuery) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate(SQLQuery);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void sqlCreateTable() {
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE product(" +
                    "id serial NOT NULL," +
                    "prodid numeric NOT NULL," +
                    "title text NOT NULL," +
                    "cost numeric(1000,2) NOT NULL," +
                    "CONSTRAINT id PRIMARY KEY (id)," +
                    "CONSTRAINT prodid UNIQUE (prodid))" +
                    "WITH (OIDS = FALSE);" +
                    "ALTER TABLE product OWNER TO postgres;");
            System.out.println("Таблица создана");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void sqlInsertData() {
        try {
            ps = connection.prepareStatement("INSERT INTO product (prodid, title, cost) VALUES (?, ?, ?)");
            ps.clearBatch();
            for (int i = 1; i <= 10000; i++) {
                ps.setInt(1, (i * 10));
                ps.setString(2, "товар" + i);
                ps.setDouble(3, (Math.random() * 100000) / 100);
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void sqlSelectAll(){
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM product");
            printAllColunms(resultSet);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void sqlSelectPrice(String title) {
        try {
            ps = connection.prepareStatement("SELECT title, cost FROM product WHERE title = ?");
            ps.setString(1, title);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next() == false) {
                System.out.println("Такого товара нет: " + title);
            } else {
                do {
                    String titl = resultSet.getString("title");
                    Double cost = resultSet.getDouble("cost");
                    System.out.println(String.format(" title: %s | cost: %s", titl, cost));
                } while (resultSet.next());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void sqlUpdatePrice(String title, Double cost) {
        try {
            ps = connection.prepareStatement("UPDATE product SET cost = ? WHERE title = ?");
            ps.setDouble(1, cost);
            ps.setString(2, title);
            ps.executeUpdate();
            sqlSelectPrice(title);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void sqlSelectPricesBetween(Double from, Double to) {
        try {
            ps = connection.prepareStatement("SELECT * FROM product WHERE cost BETWEEN ? AND ?");
            ps.setDouble(1, from);
            ps.setDouble(2, to);
            ResultSet resultSet = ps.executeQuery();
            printAllColunms(resultSet);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printAllColunms(ResultSet resultSet) throws SQLException {
        if (resultSet.next() == false) {
            System.out.println("В выборке 0 записей");
        } else {
            do {
                String id = resultSet.getString("id");
                String prodid = resultSet.getString("prodid");
                String title = resultSet.getString("title");
                String cost = resultSet.getString("cost");
                System.out.println(String.format("id: %s | prodid: %s | title: %s | cost: %s", id, prodid, title, cost));
            } while (resultSet.next());
        }
    }

    private static class Driver implements java.sql.Driver {
        /**
         * Attempts to make a database connection to the given URL.
         * The driver should return "null" if it realizes it is the wrong kind
         * of driver to connect to the given URL.  This will be common, as when
         * the JDBC driver manager is asked to connect to a given URL it passes
         * the URL to each loaded driver in turn.
         *
         * <P>The driver should throw an {@code SQLException} if it is the right
         * driver to connect to the given URL but has trouble connecting to
         * the database.
         *
         * <P>The {@code Properties} argument can be used to pass
         * arbitrary string tag/value pairs as connection arguments.
         * Normally at least "user" and "password" properties should be
         * included in the {@code Properties} object.
         * <p>
         * <B>Note:</B> If a property is specified as part of the {@code url} and
         * is also specified in the {@code Properties} object, it is
         * implementation-defined as to which value will take precedence. For
         * maximum portability, an application should only specify a property once.
         *
         * @param url  the URL of the database to which to connect
         * @param info a list of arbitrary string tag/value pairs as
         *             connection arguments. Normally at least a "user" and
         *             "password" property should be included.
         * @return a {@code Connection} object that represents a
         * connection to the URL
         * @throws SQLException if a database access error occurs or the url is
         *                      {@code null}
         */
        @Override
        public Connection connect(String url, Properties info) throws SQLException {
            return null;
        }

        /**
         * Retrieves whether the driver thinks that it can open a connection
         * to the given URL.  Typically drivers will return {@code true} if they
         * understand the sub-protocol specified in the URL and {@code false} if
         * they do not.
         *
         * @param url the URL of the database
         * @return {@code true} if this driver understands the given URL;
         * {@code false} otherwise
         * @throws SQLException if a database access error occurs or the url is
         *                      {@code null}
         */
        @Override
        public boolean acceptsURL(String url) throws SQLException {
            return false;
        }

        /**
         * Gets information about the possible properties for this driver.
         * <p>
         * The {@code getPropertyInfo} method is intended to allow a generic
         * GUI tool to discover what properties it should prompt
         * a human for in order to get
         * enough information to connect to a database.  Note that depending on
         * the values the human has supplied so far, additional values may become
         * necessary, so it may be necessary to iterate though several calls
         * to the {@code getPropertyInfo} method.
         *
         * @param url  the URL of the database to which to connect
         * @param info a proposed list of tag/value pairs that will be sent on
         *             connect open
         * @return an array of {@code DriverPropertyInfo} objects describing
         * possible properties.  This array may be an empty array if
         * no properties are required.
         * @throws SQLException if a database access error occurs
         */
        @Override
        public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
            return new DriverPropertyInfo[0];
        }

        /**
         * Retrieves the driver's major version number. Initially this should be 1.
         *
         * @return this driver's major version number
         */
        @Override
        public int getMajorVersion() {
            return 0;
        }

        /**
         * Gets the driver's minor version number. Initially this should be 0.
         *
         * @return this driver's minor version number
         */
        @Override
        public int getMinorVersion() {
            return 0;
        }

        /**
         * Reports whether this driver is a genuine JDBC
         * Compliant driver.
         * A driver may only report {@code true} here if it passes the JDBC
         * compliance tests; otherwise it is required to return {@code false}.
         * <p>
         * JDBC compliance requires full support for the JDBC API and full support
         * for SQL 92 Entry Level.  It is expected that JDBC compliant drivers will
         * be available for all the major commercial databases.
         * <p>
         * This method is not intended to encourage the development of non-JDBC
         * compliant drivers, but is a recognition of the fact that some vendors
         * are interested in using the JDBC API and framework for lightweight
         * databases that do not support full database functionality, or for
         * special databases such as document information retrieval where a SQL
         * implementation may not be feasible.
         *
         * @return {@code true} if this driver is JDBC Compliant; {@code false}
         * otherwise
         */
        @Override
        public boolean jdbcCompliant() {
            return false;
        }

        /**
         * Return the parent Logger of all the Loggers used by this driver. This
         * should be the Logger farthest from the root Logger that is
         * still an ancestor of all of the Loggers used by this driver. Configuring
         * this Logger will affect all of the log messages generated by the driver.
         * In the worst case, this may be the root Logger.
         *
         * @return the parent Logger for this driver
         * @throws SQLFeatureNotSupportedException if the driver does not use
         *                                         {@code java.util.logging}.
         * @since 1.7
         */
        @Override
        public Logger getParentLogger() throws SQLFeatureNotSupportedException {
            return null;
        }
    }
}