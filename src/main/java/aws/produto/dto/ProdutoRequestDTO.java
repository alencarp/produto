package aws.produto.dto;

import aws.produto.model.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProdutoRequestDTO(
        @NotBlank
        String nome,
        @NotNull
        BigDecimal preco,
        @NotNull
        Categoria categoria) { }
