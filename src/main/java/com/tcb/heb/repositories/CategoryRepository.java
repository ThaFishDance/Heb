package com.tcb.heb.repositories;

import com.tcb.heb.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Byte> {
    Optional<Category> findByName(String name);

    Optional<Category> findById(Byte id);

    boolean existsByName(String name);
}