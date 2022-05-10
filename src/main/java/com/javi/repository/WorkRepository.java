package com.javi.repository;

import com.javi.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface WorkRepository extends CommonRepository<Work, Long>, JpaRepository<Work, Long> {
    Collection<Work> findByProject(long project);
}
