package com.tcb.heb.repositories;

import com.tcb.heb.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Byte> {
    Optional<Category> findByName(String name);

    boolean existsByName(String name);
}