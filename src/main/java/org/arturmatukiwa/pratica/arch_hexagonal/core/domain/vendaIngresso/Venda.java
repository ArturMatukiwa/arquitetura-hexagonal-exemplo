package org.arturmatukiwa.pratica.arch_hexagonal.core.domain.vendaIngresso;

import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.comprador.Comprador;
import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.ingresso.Ingresso;

import java.time.LocalDateTime;
import java.util.Objects;

public class Venda {
   private Long id;
   private Comprador comprador;
   private Ingresso ingresso;
   private Double valorPago;
   private LocalDateTime horarioVenda;

    public Venda(Comprador comprador, Ingresso ingresso, Double valorPago) {
        this.validarDados(comprador, ingresso, valorPago);
        this.comprador    = comprador;
        this.ingresso     = ingresso;
        this.valorPago    = valorPago;
        this.horarioVenda = LocalDateTime.now();
    }

    public Venda(Long id, Comprador comprador, Ingresso ingresso, Double valorPago, LocalDateTime horarioVenda) {

        this.validarDados(id, comprador, ingresso, valorPago, horarioVenda);
        this.id           = id;
        this.comprador    = comprador;
        this.ingresso     = ingresso;
        this.valorPago    = valorPago;
        this.horarioVenda = horarioVenda;
    }

    private void validarDados(Comprador comprador, Ingresso ingresso, Double valorPago) {
        Objects.requireNonNull(comprador, "'comprador' possui valor nulo");
        Objects.requireNonNull(ingresso,  "'ingresso' possui valor nulo");
        Objects.requireNonNull(valorPago, "'valorPago' possui valor nulo");
    }

    private void validarDados(Long id, Comprador comprador, Ingresso ingresso, Double valorPago, LocalDateTime horarioVenda) {
        Objects.requireNonNull(id,           "'id' possui valor nulo");
        Objects.requireNonNull(comprador,    "'comprador' possui valor nulo");
        Objects.requireNonNull(ingresso,     "'ingresso' possui valor nulo");
        Objects.requireNonNull(valorPago,    "'valorPago' possui valor nulo");
        Objects.requireNonNull(horarioVenda, "'horarioVenda' possui valor nulo");
    }

    public Long getId() {
        return id;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public Ingresso getIngresso() {
        return ingresso;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public LocalDateTime getHorarioVenda() {
        return horarioVenda;
    }
}
