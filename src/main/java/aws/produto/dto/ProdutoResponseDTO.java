package aws.produto.dto;

import aws.produto.model.Categoria;
import aws.produto.model.Produto;

import java.math.BigDecimal;

public record ProdutoResponseDTO (Long id, String nome, BigDecimal preco, Categoria categoria) {

    public ProdutoResponseDTO(Produto produto) {
        this(produto.getId(), produto.getNome(), produto.getPreco(), produto.getCategoria());
    }
}
