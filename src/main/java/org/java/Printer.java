package org.java;

import java.util.concurrent.Semaphore;

public class Printer {
    Semaphore s1 = new Semaphore(0);
    Semaphore s2 = new Semaphore(0);

    public void printOne () {
        System.out.println("One");
        s1.release();
    }

    public void printTwo () {
        try {
            s1.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Two");
        s2.release();
    }

    public void printThree () {
        try {
            s2.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Three");
    }

    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread one = new Thread(printer::printOne);
        Thread two = new Thread(printer::printTwo);
        Thread three = new Thread(printer::printThree);

        one.start();
        two.start();
        three.start();

        try {
            one.join();
            two.join();
            three.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
