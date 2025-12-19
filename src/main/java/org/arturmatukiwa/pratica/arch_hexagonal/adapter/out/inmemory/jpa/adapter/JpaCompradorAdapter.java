package org.arturmatukiwa.pratica.arch_hexagonal.adapter.out.inmemory.jpa.adapter;

import org.arturmatukiwa.pratica.arch_hexagonal.adapter.out.inmemory.jpa.entity.JpaCompradorEntity;
import org.arturmatukiwa.pratica.arch_hexagonal.adapter.out.inmemory.jpa.mapper.JpaCompradorMapper;
import org.arturmatukiwa.pratica.arch_hexagonal.adapter.out.inmemory.jpa.repository.JpaCompradorRepository;
import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.comprador.Comprador;
import org.arturmatukiwa.pratica.arch_hexagonal.core.ports.out.CompradorPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaCompradorAdapter implements CompradorPort {

    private static final Logger LOG = LoggerFactory.getLogger(JpaCompradorAdapter.class);
    private final JpaCompradorRepository repository;

    public JpaCompradorAdapter(JpaCompradorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Comprador> buscarPorCpf(String cpf) {
        LOG.info("Buscando comprador por cpf na base de dados");
        Optional<JpaCompradorEntity> entidadeRetornada = repository.findByCpf(cpf);
        return entidadeRetornada.map(JpaCompradorMapper::toDomain);
    }

    @Override
    public Comprador persistir(Comprador novoComprador) {
        LOG.info("Persistindo comprador de nome {} na base de dados: ", novoComprador.getNome());
        JpaCompradorEntity entidadePersistida = repository.save(JpaCompradorMapper.toJpaEntity(novoComprador));
        return JpaCompradorMapper.toDomain(entidadePersistida);
    }

    @Override
    public boolean existePorCpf(String cpf) {
        return repository.existsByCpf(cpf);
    }
}
