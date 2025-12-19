package org.arturmatukiwa.pratica.arch_hexagonal.adapter.in.rest.dto.mapper;

import org.arturmatukiwa.pratica.arch_hexagonal.adapter.in.rest.dto.ConsultaCompradorDto;
import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.comprador.Comprador;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompradorMapper {

    @Mapping(target = "id",       source = "id")
    @Mapping(target = "nome",     source = "nome")
    @Mapping(target = "telefone", source = "telefone")
    @Mapping(target = "cpf",      source = "cpf.valor")
    public ConsultaCompradorDto toDto(Comprador domain);
}
