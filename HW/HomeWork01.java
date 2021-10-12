package HomeWork;

public class HomeWork01 {

        public static void main(String[] args) {
            printThreeWords();
            checkSumSign();
            printColor();
        }

        public static void printThreeWords() {
            System.out.println("Orange");
            System.out.println("Banana");
            System.out.println("Apple");
        }

        public static void checkSumSign() {
            int a = 10;
            int b = 5;
            int c= a+b;
            {
                if (c >= 0) {
                    System.out.println("положительное");
                } else {
                    System.out.println("отрицательное");
                }
            }

        }
        public static void printColor(){
            int value = 10;
            if (value >= 0 && value >= 0) {
                System.out.println("Красный");
            }else if (value >=0 && value >=100 ) {
                System.out.println("Желтый");
            }else if (value >=100) {
                System.out.println("Красный");
            }
        }}


