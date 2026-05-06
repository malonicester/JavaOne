package org.java.practice.Repository;

import org.java.lld.entities.BaseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryRepositoryServiceImpl<ID,T extends BaseEntity<ID>> implements Repository<ID,T> {

    private final Map<ID,T> entityMap = new ConcurrentHashMap<>();

    private final IDGenerator<ID> idGenerator;

    public InMemoryRepositoryServiceImpl(IDGenerator<ID> idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public void save(T t) {
        t.setId(idGenerator.getNext());
        entityMap.put(t.getId(),t);
    }

    @Override
    public void update(T t) {
        if (t.getId() == null) throw new IllegalArgumentException("Can't find id");
        if (!entityMap.containsKey(t.getId())) throw new IllegalArgumentException("Couldn't ot find entity to  update");
        entityMap.put(t.getId(),t);
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(entityMap.get(id));
    }

    @Override
    public List<T> finaAll() {
        return new ArrayList<>(entityMap.values());
    }
}
