package aws.produto.controller;

import aws.produto.dto.ProdutoRequestDTO;
import aws.produto.dto.ProdutoResponseDTO;
import aws.produto.model.Produto;
import aws.produto.repository.ProdutoRepository;
import aws.produto.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @Transactional
//    public void cadastrar(@RequestHeader("token") String token, @RequestBody ProdutoRequestDTO produtoRequestDTO) {
    public ResponseEntity cadastrar(@RequestBody @Valid ProdutoRequestDTO produtoRequestDTO, UriComponentsBuilder uriComponentsBuilder) {
        Produto produto = new Produto(produtoRequestDTO);
        ProdutoResponseDTO produtoResponseDTO = produtoService.cadastrar(produto);

        var uri = uriComponentsBuilder.path("produtos/{id}").buildAndExpand(produto.getId()).toUri();

        return ResponseEntity.created(uri).body(produtoResponseDTO);
    }

    @GetMapping
//    public List<Produto> listar(@RequestHeader("token") String token) {
    public ResponseEntity<List<ProdutoResponseDTO>> listar() {
        return ResponseEntity.ok(produtoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.buscarPorId(id));
    }
}
