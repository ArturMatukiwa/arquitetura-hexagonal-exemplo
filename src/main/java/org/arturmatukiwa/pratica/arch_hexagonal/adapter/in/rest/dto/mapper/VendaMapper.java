package org.arturmatukiwa.pratica.arch_hexagonal.adapter.in.rest.dto.mapper;

import org.arturmatukiwa.pratica.arch_hexagonal.adapter.in.rest.dto.VendaIngressoRealizadaDto;
import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.vendaIngresso.Venda;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CompradorMapper.class, IngressoMapper.class})
public interface VendaMapper {

    @Mapping(target = "id",                source = "id")
    @Mapping(target = "nomeComprador",     source = "comprador.nome")
    @Mapping(target = "categoriaIngresso", source = "ingresso.categoria")
    @Mapping(target = "setorIngresso",     source = "ingresso.setor")
    @Mapping(target = "valorPago",         source = "valorPago")
    @Mapping(target = "horarioVenda",      source = "horarioVenda")
    VendaIngressoRealizadaDto toDto(Venda domain);
}
