package HomeWork06;

public class AnimalsApp {
    public static void main(String[] args) {


        Cat cat = new Cat();
        cat.run(200);
        cat.swim(1);
        cat.jump(1.9);
        System.out.println();


        Dog dog = new Dog();
        dog.run(500);
        dog.swim(10);
        dog.jump(0.4);
    }
}
