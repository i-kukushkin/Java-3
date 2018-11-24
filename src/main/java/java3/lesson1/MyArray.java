package java3.lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class MyArray<T> {

    private T[] array;
    private T temp;

    public MyArray(T[] array) {
        this.array = array;
    }

    public void changeArrayPos(int firstPos, int secondPos) {
        temp = array[firstPos];
        array[firstPos] = array[secondPos];
        array[secondPos] = temp;
    }

    public ArrayList convertToArrayList() {
        ArrayList<T> arrayList = new ArrayList<T>(Arrays.asList(array));
        return arrayList;
    }

}
