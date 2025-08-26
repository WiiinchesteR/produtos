package meu.projeto.produtos.controller;

import lombok.RequiredArgsConstructor;
import meu.projeto.produtos.dtos.ProdutoRequest;
import meu.projeto.produtos.dtos.ProdutoResponse;
import meu.projeto.produtos.service.ProdutoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoResponse> cadastrarProduto(@RequestBody ProdutoRequest request) {
        return ResponseEntity.ok(produtoService.cadastrarProduto(request));
    }

    @GetMapping
    public ResponseEntity<Page<ProdutoResponse>> listarProdutos(
            @PageableDefault(sort = {"id"}, size = 20) Pageable page
    ) {
        return ResponseEntity.ok(produtoService.listarProdutos(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> listarProdutoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.listarProdutoPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> atualizarProduto(
            @RequestBody ProdutoRequest request, @PathVariable Long id
    ) {
        return ResponseEntity.ok(produtoService.atualizarProduto(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto (@PathVariable Long id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.ok().build();
    }
}
