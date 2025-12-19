package org.arturmatukiwa.pratica.arch_hexagonal.adapter.out.inmemory.jpa.adapter;

import org.arturmatukiwa.pratica.arch_hexagonal.adapter.out.inmemory.jpa.entity.JpaIngressoEntity;
import org.arturmatukiwa.pratica.arch_hexagonal.adapter.out.inmemory.jpa.mapper.JpaIngressoMapper;
import org.arturmatukiwa.pratica.arch_hexagonal.adapter.out.inmemory.jpa.repository.JpaIngressoRepository;
import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.ingresso.Categoria;
import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.ingresso.Ingresso;
import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.ingresso.Setor;
import org.arturmatukiwa.pratica.arch_hexagonal.core.ports.out.IngressoPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaIngressoAdapter implements IngressoPort {

    private static final Logger LOG = LoggerFactory.getLogger(JpaIngressoAdapter.class);
    private final JpaIngressoRepository repository;

    public JpaIngressoAdapter(JpaIngressoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Ingresso> buscarPorId(Long id) {
        LOG.info("Buscando comprador na base de dados para o id: {}", id);
        Optional<JpaIngressoEntity> entidadeEncontrada = repository.findById(id);
        return entidadeEncontrada.map(JpaIngressoMapper::toDomain);
    }

    @Override
    public Ingresso persistir(Ingresso ingresso) {
        LOG.info(
                "Persistindo ingresso {} para o setor {} na base de dados: ",
                    ingresso.getCategoria().toString().toLowerCase(),
                    ingresso.getSetor().toString()
                );
        JpaIngressoEntity entidadePersistida = repository.save(JpaIngressoMapper.toJpaEntity(ingresso));
        return JpaIngressoMapper.toDomain(entidadePersistida);
    }

    @Override
    public Optional<Ingresso> buscarIngressosPorSetorECategoria(Setor setor, Categoria categoria, Integer quantidade) {
        Optional<JpaIngressoEntity> ingressoEncontrado = repository.findQuantityByCategoryAndSector(categoria, setor, quantidade);
        return ingressoEncontrado.map(JpaIngressoMapper::toDomain);
    }

    @Override
    public boolean existePorCategoriaSetorEMeiaEntrada(Categoria categoria, Setor setor, Boolean meiaEntrada) {
        return repository.existsByCategoriaAndSetorAndMeiaEntrada(categoria, setor, meiaEntrada);
    }

    @Override
    public Optional<Ingresso> buscarPorCategoriaSetorEMeiaEntrada(Categoria categoria, Setor setor, Boolean meiaEntrada) {
        Optional<JpaIngressoEntity> ingressoEncontrado = repository.findByCategoriaAndSetorAndMeiaEntrada(categoria, setor, meiaEntrada);
        return ingressoEncontrado.map(JpaIngressoMapper::toDomain);
    }
}