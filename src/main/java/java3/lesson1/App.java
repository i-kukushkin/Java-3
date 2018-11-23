package java3.lesson1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Java 3. Lesson 1. Homework.
 *
 * @author Ilya Kukushkin
 * @version 23 Nov 2018
 */

public class App {

    public static void main(String[] args) {

        Float[] floatArr = {1.0f, 2.0f, 3.0f, 4.0f, 5.0f};
        MyArray<Float> floatArray = new MyArray<Float>(floatArr);
        System.out.println("Original floatArray " + Arrays.toString(floatArr));
        floatArray.changeArrayPos(1, 3);
        System.out.println("floatArray после изменения позиций " + Arrays.toString(floatArr) + "\n");

        String[] strArray = {"str0", "str1", "str2", "str3", "str4"};
        MyArray<String> stringArray = new MyArray<String>(strArray);
        System.out.println("Original stringArray " + Arrays.toString(strArray));
        stringArray.changeArrayPos(1, 3);
        System.out.println("stringArray после изменения позиций " + Arrays.toString(strArray) + "\n");

        ArrayList floatArrayList = floatArray.convertToArrayList();
        System.out.println("floatArrayList " + floatArrayList.toString() + "\n");

        ArrayList strArrayList = stringArray.convertToArrayList();
        System.out.println("strArrayList " + strArrayList.toString() + "\n");

        Box<Apple> appleBox = new Box<Apple>();
        for (int i = 0; i <= 5; i++) appleBox.add(new Apple());
        System.out.println(appleBox.showSize() + " и ее вес: " + appleBox.getBoxWeight());

        Box<Orange> orangeBox = new Box<Orange>();
        for (int i = 0; i <= 3; i++) orangeBox.add(new Orange());
        System.out.println(orangeBox.showSize() + " и ее вес: " + orangeBox.getBoxWeight());

        System.out.println(appleBox.compareBox(orangeBox));

        Box<Apple> applexBox1 = new Box<Apple>();
        applexBox1.add(new Apple());
        System.out.println("appleBox1. " + applexBox1.showSize());
        appleBox.moveToAnotherBox(applexBox1);
        System.out.println("В коробке appleBox1 после перемещения. " + applexBox1.showSize());
        System.out.println("В коробке appleBox после перемещения. " + appleBox.showSize());

        System.out.println(orangeBox.compareBox(appleBox));
    }
}
