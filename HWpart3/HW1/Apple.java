package Java3.HW1;


public class Apple extends Fruit {
    private float weight = 1.0f;
    private String name = " Apple ";

    @Override
    public float getWeight() { return weight; }

    public String getName() {
        return name;
    }
}