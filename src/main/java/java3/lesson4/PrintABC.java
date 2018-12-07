package java3.lesson4;

/**
 * Java 3. Homework to lesson 4.
 * Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок – ABСABСABС).
 * Используйте wait/notify/notifyAll.
 *
 * @author Ilya Kukushkin
 * @version 4 Dec 2018
 */

public class PrintABC {

    final private static Object monitor = new Object();
    private static char currentLetter = 'A';

    public static void main(String[] args) {
        final PrintABC pr = new PrintABC();

        new Thread(new Runnable() {
            @Override
            public void run() {
                pr.printA();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                pr.printB();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                pr.printC();
            }
        }).start();
    }

    public static void printA() {
        try {
            synchronized (monitor) {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'A') {
                        monitor.wait();
                    }
                    System.out.print('A');
                    currentLetter = 'B';
                    monitor.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void printB() {
        try {
            synchronized (monitor) {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'B') {
                        monitor.wait();
                    }
                    System.out.print('B');
                    currentLetter = 'C';
                    monitor.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void printC() {
        try {
            synchronized (monitor) {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'C') {
                        monitor.wait();
                    }
                    System.out.print('C');
                    currentLetter = 'A';
                    monitor.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
