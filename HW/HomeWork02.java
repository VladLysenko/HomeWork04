package HomeWork02;

public class HomeWork02 {
    public static void main(String[] args) {
        System.out.println(checkSum(10,8));
        doTwo(-3);
        System.out.println(doThree(-3));
        doFour("Текстовая строка",8);
        System.out.println(leapYear(2000));
    }
    //Задание 1
    //Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно),
    // если да – вернуть true, в противном случае – false.
    public static boolean checkSum (int a, int b) {
        int sum = a + b;
        return (sum >= 10)&&(sum <=20);
    }

    //Задание 2
    // Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
    // положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
    public static void doTwo (int a) {
        if ( a>=0 ){
            System.out.println("Число " + a + "положительное");
        }else {
            System.out.println("Число" +a + "отрицательное ");
        }
    }
    //Задание 3
    // Написать метод, которому в качестве параметра передается целое число.
    // Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
    public static boolean doThree (int a){
        return( a < 0 );
    }
    //Задание 4
    //Написать метод, которому в качестве аргументов передается строка и число,
    // метод должен отпечатать в консоль указанную строку, указанное количество раз;
    public static void doFour(String str,int a) {
        for (int i =0; i<a; i++){
            System.out.println(str);
        }
    }
    //Задание 5
    // Написать метод, который определяет, является ли год високосным,
    // и возвращает boolean (високосный - true, не високосный - false).
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    public static boolean leapYear (int year) {
        return ((year % 4 == 0)&&((year % 100 !=0)||(year % 400 == 0)));

    }

}

