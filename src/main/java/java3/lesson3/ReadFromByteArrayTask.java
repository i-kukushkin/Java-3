package java3.lesson3;

import java.io.*;

/**
 * Task 1.
 * Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
 */


public class ReadFromByteArrayTask {

    private FileInputStream fileInputStream = null;
    private byte[] bytesArray;
    private String fileName;

    public ReadFromByteArrayTask(String fileName) {
        try {
            this.fileName = fileName;
            this.fileInputStream = new FileInputStream(this.fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int countHowManyBytesAreRead() throws IOException {
        return fileInputStream.read();
    }

    public void readIntoByteArray() {
        try {
            bytesArray = new byte[(int) fileName.length()];
            fileInputStream.read(bytesArray);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void readFromByteArray() {
        for (byte b : bytesArray) {
            System.out.print((char) b);
        }
    }
}
