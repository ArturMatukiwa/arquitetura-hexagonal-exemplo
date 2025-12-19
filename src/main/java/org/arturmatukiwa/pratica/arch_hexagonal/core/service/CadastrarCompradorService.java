package org.arturmatukiwa.pratica.arch_hexagonal.core.service;

import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.comprador.Comprador;
import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.comprador.Cpf;
import org.arturmatukiwa.pratica.arch_hexagonal.core.exception.EntidadeJaExistenteException;
import org.arturmatukiwa.pratica.arch_hexagonal.core.ports.in.CadastrarCompradorUseCase;
import org.arturmatukiwa.pratica.arch_hexagonal.core.ports.in.dto.CadastrarCompradorDto;
import org.arturmatukiwa.pratica.arch_hexagonal.core.ports.out.CompradorPort;

import java.util.Objects;

public class CadastrarCompradorService implements CadastrarCompradorUseCase {

    private final CompradorPort repository;

    public CadastrarCompradorService(CompradorPort repository) {
        this.repository = repository;
    }

    @Override
    public Comprador executarOperacao(CadastrarCompradorDto request) {
        Objects.requireNonNull(request, "A request recebida para cadastrar um comprador possui valor nulo");

        boolean existePorCpf = repository.existePorCpf(request.cpf());
        if(existePorCpf) {
            throw new EntidadeJaExistenteException("Comprador já existe para esse cpf");
        }

        Cpf cpfNovoComprador = new Cpf(
                request.cpf()
        );

        Comprador novoComprador = new Comprador(
                request.nome(),
                request.telefone(),
                cpfNovoComprador
        );

        return repository.persistir(novoComprador);
    }
}
