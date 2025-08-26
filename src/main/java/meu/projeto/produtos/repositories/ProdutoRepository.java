package meu.projeto.produtos.repositories;

import meu.projeto.produtos.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

    boolean existsById(Long id);
}
