package com.tcb.heb.repositories;

import com.tcb.heb.entities.User;
import org.springframework.data.repository.CrudRepository;

// The class is implemented at runtime
public interface UserRepository extends CrudRepository<User, Long> {


    User findUserById(Long id);
}
