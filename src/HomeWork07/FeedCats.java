package HomeWork07;

public class FeedCats{
    private static int TIME = 0;

    public static void main(String[] args) {

        Cat[] cat = new Cat[3];
        cat[0] = new Cat("Марина", 100, 3);
        cat[1] = new Cat("Кузя", 150, 4);
        cat[2] = new Cat("Белла", 30, 1);
        Plate plate = new Plate(700);

        do {
            for (Cat i : cat) {

                //если кот голоден
                if (i.getSatiety() == 0) {

                    //если в миске не хватает еды, чтобы накормить кота, она будет добавлена
                    if (!plate.checkFood(i.getAppetite())) {                                //"!"оператор отрицания
                        plate.increaseFood();
                    }

                    //кот ест
                    i.eat(plate);
                    System.out.println("Кот " + i.getName() + " скушал " + i.getAppetite() + " граммов корма и проголодается через " + (i.getSatiety()) + " часа(ов)");
                }

                //декрементация показателя сытости
                i.setSatiety(i.getSatiety() - 1);
            }
            System.out.println("\nС момента начала питание прошел(ло) " + TIME + " час(а). В миске осталось " + plate.getFood() + " граммов корма.\n");
            TIME++;
                                                                                // \n оператор переносит на следующую строку после напечатанной строки
        } while (TIME <= 24);
    }
// Добавил в задачу цикл , сколько коты съедят за определенное время в моем случае за 24 часа,то есть сколько едят коты за сутки.
// Каждый час идёт проверка кто сколько поел .
// Когда заканчивается еда , программа добавляет 700 еды

    }



