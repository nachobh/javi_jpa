package com.javi.repository;

import com.javi.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CommonRepository<Role, Long>, JpaRepository<Role, Long> {
}
