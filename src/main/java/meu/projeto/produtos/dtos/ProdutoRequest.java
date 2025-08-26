package meu.projeto.produtos.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoRequest {

    private Long id;

    private String nome;

    private BigDecimal preco;
}
