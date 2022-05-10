package com.javi.service;

import java.util.Collection;

public interface CommonService<T, K> {

    void create(T entity);

    T read(K key);

    void update(T entity);

    void delete(K key);

    T findByName(String name);

    Collection<T> readAll();
}
