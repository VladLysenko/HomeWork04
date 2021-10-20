package HW03;

import java.util.HashMap;
import java.util.HashSet;

public class Telephone_directory {

    HashMap<String, HashSet<Integer>> Telephone_directory1;
    Telephone_directory() {
        this.Telephone_directory1 = new HashMap<>();
    }

    void add(String name, int num1) {
        HashSet<Integer> phoneBook = Telephone_directory1.getOrDefault(name, new HashSet<>());
        phoneBook.add(num1);
        Telephone_directory1.put(name, phoneBook);
    }

    void get(String name) {

        System.out.printf("%nКонтакт "+name+": "+ Telephone_directory1.getOrDefault(name, new HashSet<>()));
    }
}