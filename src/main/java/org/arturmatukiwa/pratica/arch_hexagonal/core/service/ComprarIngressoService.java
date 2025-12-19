package org.arturmatukiwa.pratica.arch_hexagonal.core.service;

import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.comprador.Comprador;
import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.ingresso.Categoria;
import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.ingresso.Ingresso;
import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.ingresso.Setor;
import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.vendaIngresso.Venda;
import org.arturmatukiwa.pratica.arch_hexagonal.core.exception.EntidadeNaoEncontradaException;
import org.arturmatukiwa.pratica.arch_hexagonal.core.exception.IngressosNaoDisponiveisException;
import org.arturmatukiwa.pratica.arch_hexagonal.core.ports.in.ComprarIngressoUseCase;
import org.arturmatukiwa.pratica.arch_hexagonal.core.ports.in.dto.ComprarIngressoDto;
import org.arturmatukiwa.pratica.arch_hexagonal.core.ports.out.CompradorPort;
import org.arturmatukiwa.pratica.arch_hexagonal.core.ports.out.IngressoPort;
import org.arturmatukiwa.pratica.arch_hexagonal.core.ports.out.VendaPort;

import java.util.Objects;

public class ComprarIngressoService implements ComprarIngressoUseCase {
    private final IngressoPort ingressoPort;
    private final CompradorPort compradorPort;
    private final VendaPort vendaPort;

    public ComprarIngressoService(IngressoPort ingressoPort, CompradorPort compradorPort, VendaPort vendaPort) {
        this.ingressoPort = ingressoPort;
        this.compradorPort = compradorPort;
        this.vendaPort = vendaPort;
    }

    @Override
    public Venda executarOperacao(ComprarIngressoDto request) {
        Objects.requireNonNull(request, "'request' possui valor nulo");

        if(request.porcentagemDesconto() < 0 || request.porcentagemDesconto() > 100) {
            throw new IllegalArgumentException("o valor de 'porcentagemDesconto' deve ter entre 0 e 100 ");
        }

        Comprador compradorEncontrado = this.buscarComprador(request.cpfComprador());

        Ingresso ingressoEncontrado   = this.buscarIngressoDesejado(
                request.setorIngresso(),
                request.categoriaIngresso(),
                request.quantidadeDesejada()
        );

        ingressoEncontrado.marcarVendas(request.quantidadeDesejada());
        Double valorComDesconto =  this.calcularDesconto(ingressoEncontrado, request.porcentagemDesconto());

        Venda novaVenda = new Venda(compradorEncontrado, ingressoEncontrado, valorComDesconto);

        ingressoPort.persistir(ingressoEncontrado);
        return vendaPort.persistir(novaVenda);
    }

    private Ingresso buscarIngressoDesejado(String setor, String categoria, Integer quantidade) {
        Setor setorParaBusca = Setor.fromString(setor);
        Categoria categoriaParaBusca = Categoria.fromString(categoria);

        return ingressoPort.buscarIngressosPorSetorECategoria(setorParaBusca, categoriaParaBusca, quantidade)
                .orElseThrow(() -> new IngressosNaoDisponiveisException("Ingressos esgotados para o setor e categoria"));

    };

    private Comprador buscarComprador(String cpf) {
        return compradorPort.buscarPorCpf(cpf)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Nenhum comprador foi encontrado para o cpf:" + cpf));
    }

    private Double calcularDesconto(Ingresso ingresso, Double porcentagemDesconto) {
        Double valorPago = ingresso.getPreco();

        if(porcentagemDesconto > 0) {
            valorPago = valorPago * (1 - porcentagemDesconto / 100);
        }

        return valorPago;
    }
}
