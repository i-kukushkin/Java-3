package java3.lesson1;

public class Orange extends Fruit {

    private final float WEIGHT = 1.5f;
    private final String FRUIT_NAME = "Апельсин";

    @Override
    public String getFruitName() {
        return FRUIT_NAME;
    }

    @Override
    public float getWeight() {
        return WEIGHT;
    }
}
