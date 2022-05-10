package com.javi.repository;

import com.javi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CommonRepository<User, Long>, JpaRepository<User, Long> {
    User findByEmail(String email);
}
