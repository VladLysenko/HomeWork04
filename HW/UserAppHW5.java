package HomeWork5;

public class UserApp {


    public static void main(String[] args) {


        User[] userCount = new User[5];
        userCount[0] = new User("Ivanov Ivan", "Engineer", "ivaaanoov@mail.ru", "8188978888", 50000, 41);
        userCount[1] = new User("Petrov Sergey", "Creator", "petrov@mail.ru", "89185643125", 50000, 32);
        userCount[2] = new User("Eremeev Nikita", "Designer", "sidorov@mail.ru", "89285168911", 10000, 43);
        userCount[3] = new User("Pupkina Natalya", "Developer", "pupkina@mail.ru", "89231231617", 5000, 18);
        userCount[4] = new User("Lysenko Vladislav", "Developer", "vlad_lysenko@mail.ru", "8923114563", 3000, 23);
        for (User user : userCount)
            if (user.getAge() > 40)
                System.out.println(user);
    }
}
