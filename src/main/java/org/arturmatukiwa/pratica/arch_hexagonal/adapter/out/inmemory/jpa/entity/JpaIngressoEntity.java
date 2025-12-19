package org.arturmatukiwa.pratica.arch_hexagonal.adapter.out.inmemory.jpa.entity;

import jakarta.persistence.*;
import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.ingresso.Categoria;
import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.ingresso.Setor;

@Entity
@Table(name = "ingresso")
public class JpaIngressoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingresso")
    private Long id;

    @Column(name = "preco")
    private Double preco;

    @Column(name = "quantidade_total")
    private Integer quantidadeTotal;

    @Column(name = "quantidade_vendida")
    private Integer quantidadeVendida;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria")
    private Categoria categoria;

    @Enumerated(EnumType.STRING)
    @Column(name = "setor")
    private Setor setor;

    @Column(name = "meia_entrada")
    private Boolean meiaEntrada;

    public JpaIngressoEntity() {
    }

    public JpaIngressoEntity(Long id, Double preco, Integer quantidadeTotal, Integer quantidadeVendida, Categoria categoria, Setor setor, Boolean meiaEntrada) {
        this.id                = id;
        this.preco             = preco;
        this.quantidadeTotal   = quantidadeTotal;
        this.quantidadeVendida = quantidadeVendida;
        this.categoria         = categoria;
        this.setor             = setor;
        this.meiaEntrada       = meiaEntrada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(Integer quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public Integer getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(Integer quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public Boolean getMeiaEntrada() {
        return meiaEntrada;
    }

    public void setMeiaEntrada(Boolean meiaEntrada) {
        this.meiaEntrada = meiaEntrada;
    }
}
