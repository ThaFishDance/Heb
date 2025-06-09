package com.tcb.heb.repositories;

import com.tcb.heb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

// The class is implemented at runtime
public interface UserRepository extends JpaRepository<User, Long> {


    User findUserById(Long id);
}
