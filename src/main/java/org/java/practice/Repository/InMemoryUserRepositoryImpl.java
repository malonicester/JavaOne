package org.java.practice.Repository;


public class InMemoryUserRepositoryImpl extends InMemoryRepositoryServiceImpl<Long,User> implements IUserRepository {

    private IDGenerator<Long> idGenerator;

    public InMemoryUserRepositoryImpl(IDGenerator<Long> idGenerator){
        super(idGenerator);
    }
}
