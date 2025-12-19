package org.arturmatukiwa.pratica.arch_hexagonal.core.service;

import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.ingresso.Ingresso;
import org.arturmatukiwa.pratica.arch_hexagonal.core.exception.EntidadeNaoEncontradaException;
import org.arturmatukiwa.pratica.arch_hexagonal.core.ports.in.ConsultaIngressoPorIdUseCase;
import org.arturmatukiwa.pratica.arch_hexagonal.core.ports.out.IngressoPort;

import java.util.Objects;

public class ConsultaIngressoPorIdService implements ConsultaIngressoPorIdUseCase {
    private final IngressoPort ingressoPort;

    public ConsultaIngressoPorIdService(IngressoPort ingressoPort) {
        this.ingressoPort = ingressoPort;
    }

    @Override
    public Ingresso executarOperacao(Long id) {
        Objects.requireNonNull(id, "'id' possui valor nulo");

        Ingresso ingressoEncontrado = ingressoPort.buscarPorId(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Ingresso não encontrado para o id: "+ id));

        return ingressoEncontrado;
     }
}
