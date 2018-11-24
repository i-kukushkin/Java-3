package java3.lesson1;

public class Apple extends Fruit {

    private final float WEIGHT = 1.0f;
    private final String FRUIT_NAME = "Яблоко";

    @Override
    public String getFruitName() {
        return FRUIT_NAME;
    }

    @Override
    public float getWeight() {
        return WEIGHT;
    }
}
