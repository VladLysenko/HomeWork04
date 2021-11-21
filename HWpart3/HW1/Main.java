package Java3.HW1;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String [] arrint  = new String[5];
        for (int i = 0; i < arrint.length; i++) {
            arrint[i] = "str" + i;
        }

        System.out.println("\nNew  :");
        Arra<?> arr = new Arra<>(new Man(), new Woman(), new Woman());
        arr.info();

        System.out.println("\nExchange  :");
        arr.arraElementsExchange(0,2);
        arr.info();

        System.out.println("\nList  :");
        ArrayList<?> list = arr.arrayToArrayList();
        for (Object o : list) System.out.println(o.getClass().getName());

        System.out.println("\nArr to list :");
        List<String> arrayList  = convertToList(arrint);
        for (Object o : arrayList) System.out.println(o.toString());

    }
    private static <E> List<E> convertToList(E[] array) {
        List<E> arrays = new ArrayList<>();
        for (E o: array) {
            arrays.add(o);
        }
        return arrays;
    }
}
