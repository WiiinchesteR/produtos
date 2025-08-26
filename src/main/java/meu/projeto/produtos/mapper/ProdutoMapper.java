package meu.projeto.produtos.mapper;

import meu.projeto.produtos.dtos.ProdutoRequest;
import meu.projeto.produtos.dtos.ProdutoResponse;
import meu.projeto.produtos.entities.ProdutoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    @Mapping(target = "id", ignore = true)
    ProdutoEntity toRequest(ProdutoRequest request);

    ProdutoResponse toResponse(ProdutoEntity entity);

    default Page<ProdutoResponse> toRequestPage(Page<ProdutoEntity> lista) {
        return lista.map(this::toResponse);
    }
}
