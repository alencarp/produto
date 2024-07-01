package aws.produto.dto;

import java.math.BigDecimal;

public record ProdutoRequestDTO(
        String nome,
        BigDecimal preco) { }
