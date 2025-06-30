package com.tcb.heb.mappers;

import com.tcb.heb.dto.CreateProductRequest;
import com.tcb.heb.dto.ProductDto;
import com.tcb.heb.dto.RegisterUserRequest;
import com.tcb.heb.entities.Product;
import com.tcb.heb.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    // mapping is for the customization, we map category.id to product.categoryId
    @Mapping(target = "categoryId", source = "category.id")
    ProductDto toDto(Product product);

    Product toEntity(CreateProductRequest request);
}
