package meu.projeto.produtos.service;

import lombok.RequiredArgsConstructor;
import meu.projeto.produtos.dtos.ProdutoRequest;
import meu.projeto.produtos.dtos.ProdutoResponse;
import meu.projeto.produtos.mapper.ProdutoMapper;
import meu.projeto.produtos.mapper.ProdutoUpdateMapper;
import meu.projeto.produtos.repositories.ProdutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;
    private final ProdutoUpdateMapper produtoUpdateMapper;

    @Transactional
    public ProdutoResponse cadastrarProduto(ProdutoRequest request) {

        return produtoMapper.toResponse(
                produtoRepository.save(
                        produtoMapper.toRequest(request)
                ));
    }

    @Transactional(readOnly = true)
    public Page<ProdutoResponse> listarProdutos(Pageable page) {
        var lista = produtoRepository.findAll(page);

        return produtoMapper.toRequestPage(lista);
    }

    @Transactional(readOnly = true)
    public ProdutoResponse listarProdutoPorId(Long id) {
        var produto = produtoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Id não encontrado")
        );

        return produtoMapper.toResponse(produto);
    }

    @Transactional
    public ProdutoResponse atualizarProduto(ProdutoRequest request, Long id) {
        var produto = produtoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Id não encontrado")
        );
        produtoUpdateMapper.updateUsuario(request, produto);

        return produtoMapper.toResponse(produtoRepository.save(produto));
    }

    @Transactional
    public void deletarProduto(Long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Id não encontrado!");
        }
    }
}
