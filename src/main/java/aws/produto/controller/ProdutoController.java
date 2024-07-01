package aws.produto.controller;

import aws.produto.dto.ProdutoRequestDTO;
import aws.produto.model.Produto;
import aws.produto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    @Transactional
//    public void cadastrar(@RequestHeader("token") String token, @RequestBody ProdutoRequestDTO produtoRequestDTO) {
    public void cadastrar(@RequestBody ProdutoRequestDTO produtoRequestDTO) {
        produtoRepository.save(new Produto(produtoRequestDTO));
    }

    @GetMapping
//    public List<Produto> listar(@RequestHeader("token") String token) {
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        return produtoRepository.findById(id).get();
    }
}
