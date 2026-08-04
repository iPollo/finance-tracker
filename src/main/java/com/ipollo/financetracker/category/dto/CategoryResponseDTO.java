
package com.ipollo.financetracker.category.dto;

import com.ipollo.financetracker.category.CategoryType;

import java.time.LocalDateTime;

public record CategoryResponseDTO(
        Long id,
        String name,
        CategoryType type,
        String color,
        LocalDateTime createdAt
) {}