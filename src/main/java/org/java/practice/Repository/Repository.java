package org.java.practice.Repository;

import org.java.lld.entities.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface Repository<ID,T extends BaseEntity<ID>> {
    void save(T t);
    void update(T t);
    Optional<T> findById(ID id);
    List<T> finaAll();
}
