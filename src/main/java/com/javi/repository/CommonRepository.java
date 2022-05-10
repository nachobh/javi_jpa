package com.javi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.validation.constraints.NotNull;

@NoRepositoryBean
public interface CommonRepository<T, K> extends JpaRepository<T, K> {

    T findByName(@NotNull(message = "Name cannot be null") String name);}
