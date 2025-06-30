package com.tcb.heb.mappers;

import com.tcb.heb.dto.CategoryDto;
import com.tcb.heb.dto.CreateCategoryRequest;
import com.tcb.heb.entities.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toEntity(CreateCategoryRequest request);

    CategoryDto toDto(Category category);
}
