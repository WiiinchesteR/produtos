package meu.projeto.produtos.mapper;

import meu.projeto.produtos.dtos.ProdutoRequest;
import meu.projeto.produtos.dtos.ProdutoResponse;
import meu.projeto.produtos.entities.ProdutoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProdutoUpdateMapper {

    void updateUsuario(ProdutoRequest dto, @MappingTarget ProdutoEntity entity);
}
