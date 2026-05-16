package org.java;

import java.util.concurrent.Semaphore;

public class SemaphorePractice {

    private final Semaphore s1 = new Semaphore(0);
    private final Semaphore s2 = new Semaphore(0);


    private void one() {
        System.out.println("1");
        s1.release();
    }

    private void two() {
        try {
            s1.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("2");
        s2.release();
    }

    private void three() {
        try {
            s2.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("3");
    }

    public static void main(String[] args) {
        SemaphorePractice obj = new SemaphorePractice();
        Thread t1 = new Thread(obj::one);
        Thread t2 = new Thread(obj::two);
        Thread t3 = new Thread(obj::three);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Completed");
    }
}
