package java3.lesson3;

import java.io.IOException;

public class MainClass {
    public static void main(String[] args) throws IOException {
        // Task 1.
        ReadFromByteArrayTask task1 = new ReadFromByteArrayTask("FileForByteArray.txt");
        System.out.println("Прочитано " + task1.countHowManyBytesAreRead() + " байт.");
        task1.readIntoByteArray();
        task1.readFromByteArray();
        // Task 2.
    }
}
