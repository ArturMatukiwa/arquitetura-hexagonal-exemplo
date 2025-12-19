package org.arturmatukiwa.pratica.arch_hexagonal.adapter.in.rest.dto.mapper;

import org.arturmatukiwa.pratica.arch_hexagonal.adapter.in.rest.dto.ConsultaIngressoDto;
import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.ingresso.Ingresso;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface    IngressoMapper {

    @Mapping(target = "id",                   source     = "id")
    @Mapping(target = "preco",                source     = "preco")
    @Mapping(target = "quantidadeDisponivel", expression = "java(domain.quantidadeDisponivel())")
    @Mapping(target = "categoria",            source     = "categoria")
    @Mapping(target = "setor",                source     = "setor")
    @Mapping(target = "meiaEntrada",          expression = "java(domain.possuiMeiaEntrada())")
    ConsultaIngressoDto toDto(Ingresso domain);
}
