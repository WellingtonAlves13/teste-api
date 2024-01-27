package com.example.treino.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ProdutoDTO(
        @NotBlank
        String nome,
        @NotBlank
        String marca,
        String descricao,
        @NotNull
        Double preco
) {
}
