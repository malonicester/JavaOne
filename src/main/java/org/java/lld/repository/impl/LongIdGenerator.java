package org.java.lld.repository.impl;

import org.java.lld.repository.IIDGenerator;

import java.util.concurrent.atomic.AtomicLong;

public class LongIdGenerator implements IIDGenerator<Long> {

    private final AtomicLong idContext = new AtomicLong(1);

    @Override
    public Long generate() {
        return idContext.getAndIncrement();
    }
}
