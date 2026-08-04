package com.ipollo.financetracker.category.dto;

import com.ipollo.financetracker.category.CategoryType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CategoryRequestDTO(

        @NotBlank(message = "O nome da categoria é obrigatório")
        String name,

        @NotNull(message = "O tipo da categoria é obrigatório")
        CategoryType type,

        String color
) {}