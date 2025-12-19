package org.arturmatukiwa.pratica.arch_hexagonal.adapter.out.inmemory.jpa.mapper;

import org.arturmatukiwa.pratica.arch_hexagonal.adapter.out.inmemory.jpa.entity.JpaCompradorEntity;
import org.arturmatukiwa.pratica.arch_hexagonal.adapter.out.inmemory.jpa.entity.JpaIngressoEntity;
import org.arturmatukiwa.pratica.arch_hexagonal.adapter.out.inmemory.jpa.entity.JpaVendaEntity;
import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.comprador.Comprador;
import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.ingresso.Ingresso;
import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.vendaIngresso.Venda;

public class JpaVendaMapper {

    public static JpaVendaEntity toJpaEntity(Venda domain) {
        JpaCompradorEntity compradorEntity = JpaCompradorMapper.toJpaEntity(domain.getComprador());
        JpaIngressoEntity ingressoEntity = JpaIngressoMapper.toJpaEntity(domain.getIngresso());

        return new JpaVendaEntity(
                domain.getId(),
                compradorEntity,
                ingressoEntity,
                domain.getValorPago(),
                domain.getHorarioVenda()
        );
    }


    public static Venda toDomain(JpaVendaEntity entidade) {
        Comprador compradorDomain = JpaCompradorMapper.toDomain(entidade.getComprador());
        Ingresso ingressoDomain = JpaIngressoMapper.toDomain(entidade.getIngresso());

        return new Venda(
                entidade.getId(),
                compradorDomain,
                ingressoDomain,
                entidade.getValorPago(),
                entidade.getHorarioVenda()
        );
    }
}
