package java3.lesson1;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    private ArrayList fruitStore;

    public Box() {
        fruitStore = new ArrayList<T>();
    }

    public void add(T fruit) {
        fruitStore.add(fruit);
    }

    public String showSize() {
        try {
            T fruit = (T) fruitStore.get(0);
            return "В коробке находится " + fruitStore.size() + " фруктов(а) " + fruit.getFruitName();
        } catch (IndexOutOfBoundsException e) {
        }
        return "Коробка пуста.";
    }

    public float getBoxWeight() {
        try {
            T fruit = (T) fruitStore.get(0);
            return fruitStore.size() * fruit.getWeight();
        } catch (IndexOutOfBoundsException e) {
        }
        return 0.0f;
    }

    public boolean compareBox(Box<? extends Fruit> box) {
        if (this.getBoxWeight() == box.getBoxWeight()) return true;
        return false;
    }

    public void moveToAnotherBox(Box<T> box) {
        box.fruitStore.addAll(this.fruitStore);
        this.fruitStore.clear();
    }
}