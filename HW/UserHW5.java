package HomeWork5;

public class User {
    //1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
    public static int userCount;

    private String name;
    private String post;
    private String mail;
    private String  telephone;
    private int cash;
    private int age;


    public User(String name, String post, String mail, String  telephone, int cash, int age) {

        this.name = name;
        this.post = post;
        this.mail = mail;
        this.telephone = telephone;
        this.cash = cash;
        this.age = age;
    }


    public int getAge(){
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", post='" + post + '\'' +
                ", mail='" + mail + '\'' +
                ", telephone=" + telephone +
                ", cash=" + cash +
                ", age=" + age +
                '}';

    }
}
