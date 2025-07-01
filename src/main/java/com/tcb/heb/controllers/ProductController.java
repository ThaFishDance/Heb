package com.tcb.heb.controllers;

import com.tcb.heb.dto.*;
import com.tcb.heb.entities.Category;
import com.tcb.heb.entities.Product;
import com.tcb.heb.mappers.CategoryMapper;
import com.tcb.heb.mappers.ProductMapper;
import com.tcb.heb.repositories.CategoryRepository;
import com.tcb.heb.repositories.ProductRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public List<ProductDto> getAllProducts(
        @RequestParam(name = "categoryId", required = false) Byte categoryId
    ) {
        List<Product> products;
        if (categoryId != null) {
            products = productRepository.findByCategoryId(categoryId);
        } else {
            products = productRepository.findAllWithCategory();
        }

        return products.stream().map(productMapper::toDto).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long id) {
        var product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return ResponseEntity.notFound().build(); // 404
        }
        return ResponseEntity.ok(productMapper.toDto(product));
    }


    @PostMapping("/createCategory")
    public ResponseEntity<?> createCategory(
        @Valid @RequestBody CreateCategoryRequest request
    ) {
        System.out.println("Creating category: " + request.getName());

        // check if category exists
        if (categoryRepository.existsByName(request.getName())) {
            return ResponseEntity.badRequest().body(
                Map.of("error", "category already exists.")
            );
        }

        // if it doesn't save, convert to entity
        var category = categoryMapper.toEntity(request);

        // save category ent to db
        categoryRepository.save(category);

        // turn it to DTO for response
        var categoryDto = categoryMapper.toDto(category);

        // return 201 with the dto
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryDto);
    }

    @GetMapping("/getAllCategories")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        System.out.println("Getting all categories");
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> dtos = categories.stream()
            .map(categoryMapper::toDto)
            .toList();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createProduct(@Valid @RequestBody CreateProductRequest request) {
        var category = categoryRepository.findById(request.getCategoryId()).orElse(null);

        if (category == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    Map.of("error", "Category not found.")
            );
        }

        var product = productMapper.toEntity(request);
        product.setCategory(category);

        productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productMapper.toDto(product));
    }


}