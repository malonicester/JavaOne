package org.java;

public class ProducerConsumer {

    private int number;


    private final Object LOCK = new Object();

    public void consume() {
        while (true) {
            synchronized (LOCK) {
                if (number == 0) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                number--;
                System.out.println("Consumed ");
                LOCK.notifyAll();
            }
        }
    }

    public void produce() {
        while (true) {
            synchronized (LOCK) {
                if (number == 1) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                number++;
                System.out.println("Produced ");
                LOCK.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        Thread t1 = new Thread(producerConsumer::consume);
        Thread t2 = new Thread(producerConsumer::produce);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
