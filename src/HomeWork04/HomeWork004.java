package HomeWork04;

import java.util.Random;
import java.util.Scanner;

public class HomeWork004 {


    public static char [][] map;
    //размер поля
    public static final int SIZE = 5;
    //сколько точек для победы
    public static final int DOTS_TO_WIN = 3;

    public static final char DOT_EMPTY = '*';

    public static final char DOT_X = 'X';

    public static final char DOT_0 = '0';

    public static final Scanner SCANNER = new Scanner(System.in);

    public static final Random RANDOM = new Random();

    public static void main(String[] args) {


        initMap();
        printMap();
        isMapFull();


        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Выиграл человек");
                break;
            }

            aiTurn();
            printMap();

            if (checkWin(DOT_0)) {
                System.out.println("Комплюктер выиграл");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }


    //initMap иницилизрует и  заполняет карту пустыми ячейками
    //SIZE вверху проиницилизировали то есть размер 5х5

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        //верхние кординаты
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();


        for (int i = 0; i < SIZE; i++) {
            //левые кординаты
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    //Ход Человека

    public static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!IsCellValid(x, y)); // "!" не валидно
        map[x][y] = DOT_X;
    }
    //Валидная ячейка

    public static boolean IsCellValid(int x, int y) {
        //проверили что попали в массив
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }
        //проверим что ячейка подходит
        if (map[x][y] == DOT_EMPTY) {
            return true;
        } else {
            return false;
        }
    }

//Ход комплютера

    public static void aiTurn() {
        int x;
        int y;
        do {
            x = RANDOM.nextInt(SIZE);
            y = RANDOM.nextInt(SIZE);
        } while (!IsCellValid(x, y));
        System.out.printf("Робот ходит в точку %d %d", x + 1, y + 1);
        System.out.println();
        map[x][y] = DOT_0;
    }

    //проверяет выигрыш sym= для проверки победы
    public static boolean checkWin(char sym) {

        int diag1, diag2, hor, ver;
        for (int i = 0; i < SIZE; i++) {
            hor = 0; ver = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == sym) {
                    hor++;
                }
                if (map[j][i] == sym) {
                    ver++;
                }
            }
            if (hor == SIZE|| ver == SIZE) {
                return true; //проверка по горизонтали и вертикали
            }
        }
        diag1 = 0; diag2 = 0;
        for (int i = 0; i < SIZE; i++) {
            if (map[i][i] == sym) {
                diag1++;
            }
            if (map[i][SIZE - i - 1] == sym) {
                diag2++;
            }
        }
        if (diag1 == SIZE || diag2 == SIZE) {
            return true; //проверка по диагоналям
        }
        return false;
    }}
