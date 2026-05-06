package org.java.lld.repository.impl;

import org.java.lld.entities.BaseEntity;
import org.java.lld.repository.IIDGenerator;
import org.java.lld.repository.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryRepositoryImpl<ID, T extends BaseEntity<ID>>
        implements Repository<ID, T> {

    private final Map<ID, T> entityMap = new ConcurrentHashMap<>();
    private final IIDGenerator<ID> idGenerator;

    public InMemoryRepositoryImpl(IIDGenerator<ID> idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public T save(T entity) {

        if (entity.getId() != null) {
            throw new IllegalArgumentException("Entity already has ID. Use update instead.");
        }

        ID id = idGenerator.generate();
        entity.setId(id);
        entityMap.put(id, entity);

        return entity;
    }

    @Override
    public T update(T entity) {

        ID id = entity.getId();

        if (id == null || !entityMap.containsKey(id)) {
            throw new IllegalArgumentException("Entity does not exist.");
        }

        entityMap.put(id, entity);
        return entity;
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(entityMap.get(id));
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(entityMap.values());
    }
}
