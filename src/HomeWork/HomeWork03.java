
package HomeWork;

import java.util.Arrays;

public class HomeWork03 {


    //1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    // С помощью цикла и условия заменить 0 на 1, 1 на 0
    public static void main(String[] args) {


       oneHundred();
       changeArray();
        TwoDimensionArrayApp();



        int[] arr = {0, 1, 0, 1, 0, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else if (arr[i] == 0) ;
            arr[i] = 1;
            System.out.println(Arrays.toString(arr));


        }
    }


    //2. Задать пустой целочисленный массив длиной 100.
    // С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;


    public static void oneHundred() {
        int[] arr1 = new int[100];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr1));
    }


    //3.Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
    // пройти по нему циклом, и числа меньшие 6 умножить на 2



    public static void changeArray() {
        int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < arr.length; i++) {
            if (arr [i] > 6){
                arr[i] = arr[i] * 2;
                System.out.println(Arrays.toString (arr));
            }}
        System.out.println();
            }



    //4.Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    // и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей,
    // если обе сложно).
    // Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны,
    // то есть [0][0], [1][1], [2][2], …, [n][n];


            public static void TwoDimensionArrayApp() {
                int[][] twoDimArray = new int[5][5];
                for (int i = 0; i < twoDimArray.length; i++) {
                    for (int j = 0; j < twoDimArray.length; j++){
                        if (twoDimArray[i][j] == 1) {

                            System.out.println(twoDimArray[i][j] + "");
                        }}
                            System.out.println();
            }
                for (int i=0; i < twoDimArray.length ; i++){
                    Arrays.fill(twoDimArray[i],i);
                    System.out.println(Arrays.toString(twoDimArray[i]));
    }}


    //5. Написать метод, принимающий на вход два аргумента: len и initialValue,
    // и возвращающий одномерный массив типа int длиной len,
    // каждая ячейка которого равна initialValue;
    public static void printArrayInConsole(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.println();
    }

}








