package Java3.HW1;

public class Orange extends Fruit {
    private float weight = 1.5f;
    private String name = " Orange ";

    @Override
    public float getWeight() { return weight; }

    public String getName() {
        return name;
    }
}