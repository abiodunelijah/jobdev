package com.coder2client.repository;

import com.coder2client.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Long id(Long id);
}
