package org.java.lld.repository;

import org.java.lld.entities.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface Repository<ID, T extends BaseEntity<ID>> {

    T save(T entity);

    T update(T entity);

    Optional<T> findById(ID id);

    List<T> findAll();
}

