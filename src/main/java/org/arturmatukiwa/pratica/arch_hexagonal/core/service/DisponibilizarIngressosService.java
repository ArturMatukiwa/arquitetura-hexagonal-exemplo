package org.arturmatukiwa.pratica.arch_hexagonal.core.service;

import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.ingresso.Ingresso;
import org.arturmatukiwa.pratica.arch_hexagonal.core.exception.EntidadeNaoEncontradaException;
import org.arturmatukiwa.pratica.arch_hexagonal.core.ports.in.DisponibilizarIngressosUseCase;
import org.arturmatukiwa.pratica.arch_hexagonal.core.ports.in.dto.CadastrarIngressoDto;
import org.arturmatukiwa.pratica.arch_hexagonal.core.ports.out.IngressoPort;

import java.util.Objects;

public class DisponibilizarIngressosService implements DisponibilizarIngressosUseCase {
    private final IngressoPort repository;

    public DisponibilizarIngressosService(IngressoPort repository) {
        this.repository = repository;
    }

    @Override
    public Ingresso executarOperacao(CadastrarIngressoDto dadosIngresso) {
        this.validarEntrada(dadosIngresso);
        Ingresso ingressoPersistir = this.obterIngresso(dadosIngresso);

        Ingresso ingressoPersistido = repository.persistir(ingressoPersistir);
        return ingressoPersistido;
    }

    private void validarEntrada(CadastrarIngressoDto dadosIngresso) {
        Objects.requireNonNull(dadosIngresso, "Os dados do ingresso recebido possui o valor nulo");

        if(dadosIngresso.quantidadeTotal() < 1) {
            throw new IllegalArgumentException("'quantidadeTotal' recebida não pode ter valor 0 ou negativo");
        }
    }

    private Ingresso obterIngresso(CadastrarIngressoDto dadosIngresso) {
        boolean tipoDeIngressoJaExiste = repository.existePorCategoriaSetorEMeiaEntrada(
                dadosIngresso.categoria(),
                dadosIngresso.setor(),
                dadosIngresso.meiaEntrada()
        );

        if(tipoDeIngressoJaExiste) {
            Ingresso ingressoBuscado = repository.buscarPorCategoriaSetorEMeiaEntrada(
                     dadosIngresso.categoria(),
                     dadosIngresso.setor(),
                     dadosIngresso.meiaEntrada()
            ).orElseThrow(EntidadeNaoEncontradaException::new);

            ingressoBuscado.aumentarQuantidade(dadosIngresso.quantidadeTotal());
            return ingressoBuscado;
        }

        return new Ingresso(
                dadosIngresso.precoIntegral(),
                dadosIngresso.quantidadeTotal(),
                dadosIngresso.categoria(),
                dadosIngresso.setor(),
                dadosIngresso.meiaEntrada()
        );
    }
}
