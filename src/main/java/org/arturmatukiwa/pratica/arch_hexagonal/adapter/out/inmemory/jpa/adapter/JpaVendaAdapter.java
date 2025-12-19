package org.arturmatukiwa.pratica.arch_hexagonal.adapter.out.inmemory.jpa.adapter;

import org.arturmatukiwa.pratica.arch_hexagonal.adapter.out.inmemory.jpa.entity.JpaVendaEntity;
import org.arturmatukiwa.pratica.arch_hexagonal.adapter.out.inmemory.jpa.mapper.JpaVendaMapper;
import org.arturmatukiwa.pratica.arch_hexagonal.adapter.out.inmemory.jpa.repository.JpaVendaRepository;
import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.vendaIngresso.Venda;
import org.arturmatukiwa.pratica.arch_hexagonal.core.ports.out.VendaPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class JpaVendaAdapter implements VendaPort {

    private static final Logger LOG = LoggerFactory.getLogger(JpaVendaAdapter.class);
    private final JpaVendaRepository repository;

    public JpaVendaAdapter(JpaVendaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Venda persistir(Venda venda) {
        LOG.info("Persistindo venda na base de dados");
        JpaVendaEntity entidadePersistida = repository.save(JpaVendaMapper.toJpaEntity(venda));
        return JpaVendaMapper.toDomain(entidadePersistida);
    }
}
