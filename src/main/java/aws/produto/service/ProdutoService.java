package aws.produto.service;

import aws.produto.dto.ProdutoRequestDTO;
import aws.produto.dto.ProdutoResponseDTO;
import aws.produto.model.Produto;
import aws.produto.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoResponseDTO cadastrar(Produto produto) {
        produtoRepository.save(produto);
        return new ProdutoResponseDTO(produto);
    }

    public List<ProdutoResponseDTO> listar() {

        List<ProdutoResponseDTO> produtosResponseDTO = new ArrayList<>();
        List<Produto> produtos = produtoRepository.findAll();

        for (Produto p : produtos) {
            produtosResponseDTO.add(new ProdutoResponseDTO(p));
        }
        return produtosResponseDTO;
    }

    public ProdutoResponseDTO buscarPorId(Long id) {
        Produto produto = produtoRepository.findById(id).get();
        return new ProdutoResponseDTO(produto);
    }
}
