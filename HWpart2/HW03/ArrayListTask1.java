package HW03;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class ArrayListTask1 {

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();

        names.add("Зоя");
        names.add("Ксюша");
        names.add("Юрий");
        names.add("Ольга");
        names.add("Олег");
        names.add("Александо");
        names.add("Владимир");
        names.add("Евгения");
        names.add("Максим");
        names.add("Сергей");
        names.add("Артём");
        names.add("Никита");
        names.add("Денис");
        names.add("Даниил");
        names.add("Вартан");
        names.add("Семён");
        names.add("Олег");
        names.add("Анатолий");
        names.add("Светлана");
        names.add("Эдуард");


        System.out.printf("Вся коллекция имен составляет: %n" + names);


        Set<String> stringSet = new LinkedHashSet<>(names);
        System.out.printf("%nУникальные имена это:%n " + stringSet);

        HashMap<String, Integer> doubleNames = new HashMap<>();
        Integer doubleName = null;
        for (String i : names) {
            doubleName = doubleNames.get(i);
            doubleNames.put(i, doubleName == null ? 1 : doubleName + 1);
        }

        System.out.printf("%nКоличество имен в списке%n" + doubleNames);
    }
}