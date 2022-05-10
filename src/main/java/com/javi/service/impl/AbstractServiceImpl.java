package com.javi.service.impl;

import com.javi.entity.AbstractEntity;
import com.javi.repository.CommonRepository;
import com.javi.service.CommonService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public abstract class AbstractServiceImpl<T extends AbstractEntity, K> implements CommonService<T, K> {

    @Setter
    @Autowired
    private CommonRepository<T,K> repository;

    @Override
    public void create(T entity) {
        repository.save(entity);
    }

    @Override
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public T read(K key) {
        return repository.findById(key).get();
    }

    @Override
    public void update(T entity) {
        repository.save(entity);
    }

    @Override
    public void delete(K key) {
        repository.delete(read(key));
    }

    @Override
    public T findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Collection<T> readAll() {
        return repository.findAll();
    }
}
