package com.ipollo.financetracker.category;

import com.ipollo.financetracker.category.dto.CategoryRequestDTO;
import com.ipollo.financetracker.category.dto.CategoryResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public CategoryResponseDTO create(CategoryRequestDTO request) {
        Category category = new Category();
        category.setName(request.name());
        category.setType(request.type());
        category.setColor(request.color());

        Category saved = repository.save(category);
        return toResponseDTO(saved);
    }

    public List<CategoryResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public List<CategoryResponseDTO> findByType(CategoryType type) {
        return repository.findByType(type).stream()
                .map(this::toResponseDTO)
                .toList();
    }

    private CategoryResponseDTO toResponseDTO(Category category) {
        return new CategoryResponseDTO(
                category.getId(),
                category.getName(),
                category.getType(),
                category.getColor(),
                category.getCreatedAt()
        );
    }
}