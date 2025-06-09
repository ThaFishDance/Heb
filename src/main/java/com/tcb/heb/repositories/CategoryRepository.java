package com.tcb.heb.repositories;

import com.tcb.heb.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
}