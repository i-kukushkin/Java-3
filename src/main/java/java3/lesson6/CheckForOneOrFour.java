package java3.lesson6;

/**
 * Java 3. Lesson 6. Homework
 * @author Ilya Kukushkin
 * @version 14 Nov 2018
 */

public final class CheckForOneOrFour {

    public final boolean checkForOneOrFour(int[] inputArray) {

        boolean res = true;
        int count1 = 0;
        int count4 = 0;
        int position = 0;

        while (position < inputArray.length && res) {
            if (inputArray[position] == 1) {
                res = true;
                count1++;
            } else {
                if (inputArray[position] == 4) {
                    res = true;
                    count4++;
                } else {
                    res = true;
                }
            }
            position++;
        }
        return res && count1 > 0 && count4 > 0;
    }
}
