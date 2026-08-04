package com.ipollo.financetracker.category;

import com.ipollo.financetracker.category.dto.CategoryRequestDTO;
import com.ipollo.financetracker.category.dto.CategoryResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> create(@Valid @RequestBody CategoryRequestDTO request) {
        CategoryResponseDTO created = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> findAll(@RequestParam(required = false) CategoryType type) {

        if (type != null) {
            return ResponseEntity.ok(service.findByType(type));
        }
        return ResponseEntity.ok(service.findAll());
    }
}