package org.java;

public class MultiThread {

    private int num = 1;
    private final int MAX = 10;
    private final Object LOCK = new Object();

    public void printOdd() {
        while (num <= MAX) {
            synchronized (LOCK) {
                while (num % 2 == 0) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                if (num <= MAX) {
                    System.out.println("Printed ODD " + num);
                    num++;
                }

                LOCK.notify();
            }
        }
    }

    public void printEven() {
        while (num <= MAX) {
            synchronized (LOCK) {
                while (num % 2 == 1) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                if (num <= MAX) {
                    System.out.println("Printed EVEN " + num);
                    num++;
                }

                LOCK.notify();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MultiThread multiThread = new MultiThread();

        Thread t1 = new Thread(multiThread::printEven);
        Thread t2 = new Thread(multiThread::printOdd);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}