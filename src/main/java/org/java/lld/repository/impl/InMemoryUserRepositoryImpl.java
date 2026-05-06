package org.java.lld.repository.impl;

import org.java.lld.entities.User;
import org.java.lld.repository.IIDGenerator;
import org.java.lld.repository.IUserRepository;

public class InMemoryUserRepositoryImpl extends InMemoryRepositoryImpl<Long, User> implements IUserRepository {
    public InMemoryUserRepositoryImpl(IIDGenerator<Long> idGenerator) {
        super(idGenerator);
    }
}
