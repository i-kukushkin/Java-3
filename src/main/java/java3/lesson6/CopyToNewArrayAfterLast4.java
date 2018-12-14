package java3.lesson6;

/**
 * Java 3. Lesson 6. Homework
 * @author Ilya Kukushkin
 * @version 14 Nov 2018
 */

public final class CopyToNewArrayAfterLast4 {

    public final int[] CopyToNewArrayAfterLast4(int[] inputArray) throws RuntimeException {

        int[] arrayForReturn = null;
        int positionAtTheInputArray = inputArray.length - 1;
        int lastPosInOutputArray = 0;
        boolean isFour = false;

        while (positionAtTheInputArray >= 0 && !isFour) {
            isFour = inputArray[positionAtTheInputArray] == 4;
            lastPosInOutputArray = positionAtTheInputArray;
            positionAtTheInputArray--;
        }

        if (isFour) {
            arrayForReturn = new int[inputArray.length - lastPosInOutputArray - 1];
            for (positionAtTheInputArray = lastPosInOutputArray + 1; positionAtTheInputArray < inputArray.length; positionAtTheInputArray++) {
                arrayForReturn[positionAtTheInputArray - lastPosInOutputArray - 1] = inputArray[positionAtTheInputArray];
            }
        } else {
            throw new RuntimeException("В массиве нет 4-ок.");
        }
        return arrayForReturn;
    }
}
