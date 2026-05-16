package org.java;


import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockPractice {

    private final Queue<String> queue = new LinkedList<>();

    private final int capacity;

    private final ReentrantLock lock = new ReentrantLock(true);

    private final Condition producerWaitsHere = lock.newCondition();
    private final Condition consumerWaitsHere = lock.newCondition();

    public LockPractice(int capacity) {
        this.capacity = capacity;
    }


    public void put() {
        lock.lock();
        try {
            while (queue.size() == capacity) {
                System.out.println("Buffer is Full Producer Waiting....");
                producerWaitsHere.await();
            }
            String input = UUID.randomUUID().toString();
            queue.offer(input);
            System.out.println("Produced " + input);
            consumerWaitsHere.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }


    public void consume() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                System.out.println("Consumer waiting producer to Produce");
                consumerWaitsHere.await();
            }
            String poll = queue.poll();
            System.out.println("Consumed " + poll);
            producerWaitsHere.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LockPractice lockPractice = new LockPractice(2);
        Thread t1 = new Thread(() -> {
            while (true) {
                lockPractice.put();
            }
        });
        Thread t2 = new Thread(() -> {
            while (true) {
                lockPractice.consume();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Completed");
    }
}
