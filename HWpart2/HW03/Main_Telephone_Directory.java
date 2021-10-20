package HW03;

public class Main_Telephone_Directory {


    public static void main(String[] args) {

        Telephone_directory Telephone_directory = new Telephone_directory();

        Telephone_directory.add("Oleg", 45642245);
        Telephone_directory.add("Oleg", 8955598);
        Telephone_directory.add("Oleg", 891851175);
        Telephone_directory.add("Natalya", 18314887);
        Telephone_directory.add("Alexandr", 12345678);


        Telephone_directory.get("Oleg");
    }
}


