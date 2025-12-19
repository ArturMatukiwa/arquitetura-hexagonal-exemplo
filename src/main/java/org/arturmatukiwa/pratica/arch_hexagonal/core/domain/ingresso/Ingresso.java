package org.arturmatukiwa.pratica.arch_hexagonal.core.domain.ingresso;

import java.util.Objects;

public class Ingresso {
    private Long id;
    private Double preco;
    private Integer quantidadeTotal;
    private Integer quantidadeVendida;
    private Categoria categoria;
    private Setor setor;
    private Boolean meiaEntrada;

    public Ingresso(Double preco, Integer quantidadeTotal, Categoria categoria, Setor setor,
                    Boolean possuiMeiaEntrada) {
        validarDados(preco, quantidadeTotal, setor, possuiMeiaEntrada, categoria);
        this.quantidadeTotal = quantidadeTotal;
        this.categoria = categoria;
        this.preco = possuiMeiaEntrada ? calcularMeiaEntrada(preco) : preco;
        this.quantidadeVendida = 0;
        this.setor = setor;
        this.meiaEntrada = possuiMeiaEntrada;
    }

    public Ingresso(Long id, Double preco, Integer quantidadeTotal, Integer quantidadeVendida,
                     Categoria categoria, Setor setor, Boolean possuiMeiaEntrada) {

        validarDados(preco, quantidadeTotal, setor, possuiMeiaEntrada, categoria);

        this.id = id;
        this.quantidadeTotal = quantidadeTotal;
        this.categoria = categoria;
        this.preco = possuiMeiaEntrada ? calcularMeiaEntrada(preco) : preco;
        this.quantidadeVendida = quantidadeVendida;
        this.setor = setor;
        this.meiaEntrada = possuiMeiaEntrada;
    }

    private void validarDados(Double preco, Integer quantidadeTotal, Setor setor, Boolean possuiMeiaEntrada, Categoria categoria) {
        Objects.requireNonNull(preco, "'preco' possui valor nulo");
        Objects.requireNonNull(quantidadeTotal, "'quantidadeTotal' possui valor nulo");
        Objects.requireNonNull(setor, "'setor' possui valor nulo");
        Objects.requireNonNull(possuiMeiaEntrada, "'possuiMeiaEntrada' possui valor nulo");
        Objects.requireNonNull(categoria, "'categoria' possui valor nulo");

        if(quantidadeTotal < 1) {
            throw new IllegalArgumentException("'quantidadeTotal' recebida não pode ter valor 0 ou negativo");
        }
    }

    public Integer quantidadeDisponivel() {
        return quantidadeTotal - quantidadeVendida;
    }

    public void marcarVendas(Integer quantidade) {
        Objects.requireNonNull(quantidade, "'quantidade' possui valor nulo");
        if(quantidade < 1) {
            throw new IllegalArgumentException("'quantidade' não pode ter valor 0 ou negativo");
        }
        this.quantidadeVendida += quantidade;
    }

    public void aumentarQuantidade(Integer quantidadeADisponibilizar) {
        Objects.requireNonNull(quantidadeADisponibilizar, "'quantidadeADisponibilizar' possui valor nulo");
        if(quantidadeADisponibilizar < 1) {
            throw new IllegalArgumentException("'quantidadeADisponibilizar' não pode ter valor 0 ou negativo");
        }

        this.quantidadeTotal += quantidadeADisponibilizar;
    }

    private Double calcularMeiaEntrada(Double valorInteiro) {
        return valorInteiro / 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingresso ingresso = (Ingresso) o;
        return Objects.equals(preco, ingresso.preco) && Objects.equals(quantidadeTotal, ingresso.quantidadeTotal) && Objects.equals(quantidadeVendida, ingresso.quantidadeVendida) && categoria == ingresso.categoria && setor == ingresso.setor && Objects.equals(meiaEntrada, ingresso.meiaEntrada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(preco, quantidadeTotal, quantidadeVendida, categoria, setor, meiaEntrada);
    }

    public Long getId() {
        return id;
    }

    public Integer getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public Integer getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public Double getPreco() {
        return preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Setor getSetor() {
        return setor;
    }

    public Boolean possuiMeiaEntrada() {
        return meiaEntrada;
    }
}
