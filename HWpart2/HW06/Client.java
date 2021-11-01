package HW06;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        new Client();
    }

    public Client() {

        Socket socket;
        PrintWriter writer;
        BufferedReader reader;

        final String IP_ADRESS = "localhost";
        final int PORT = 8181;


        try {
            socket = new Socket(IP_ADRESS, PORT);
            writer = new PrintWriter(socket.getOutputStream());
            InputStreamReader in = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(in);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            Scanner sc1 = new Scanner(System.in);
                            String str = sc1.nextLine();
                            writer.println(str);
                            writer.flush();
                            if (str.equalsIgnoreCase("/end")) break;
                        }
                    }
                    finally {
                        try {
                            socket.close();
                            System.exit(0);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String str2 = reader.readLine();
                            System.out.println("Server: " + str2);
                            // if (str2.equalsIgnoreCase("/end")) break;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();

                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}