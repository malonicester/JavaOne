package org.java.practice.Repository;

import java.util.concurrent.atomic.AtomicLong;

public class LongIDGeneratorImpl implements IDGenerator<Long> {

    private final AtomicLong atomicLong = new AtomicLong(1);

    @Override
    public Long getNext() {
        return atomicLong.getAndIncrement();
    }
}
