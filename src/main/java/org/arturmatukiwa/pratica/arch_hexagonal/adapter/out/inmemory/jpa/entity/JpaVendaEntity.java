package org.arturmatukiwa.pratica.arch_hexagonal.adapter.out.inmemory.jpa.entity;

import jakarta.persistence.*;
import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.comprador.Comprador;
import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.ingresso.Ingresso;

import java.time.LocalDateTime;

@Entity
@Table(name = "venda")
public class JpaVendaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venda")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_comprador")
    private JpaCompradorEntity comprador;

    @ManyToOne
    @JoinColumn(name = "fk_ingresso")
    private JpaIngressoEntity ingresso;

    @Column(name = "valor_pago")
    private Double valorPago;

    @Column(name = "horario_venda")
    private LocalDateTime horarioVenda;

    public JpaVendaEntity() {
    }

    public JpaVendaEntity(Long id, JpaCompradorEntity comprador, JpaIngressoEntity ingresso, Double valorPago, LocalDateTime horarioVenda) {
        this.id           = id;
        this.comprador    = comprador;
        this.ingresso     = ingresso;
        this.valorPago    = valorPago;
        this.horarioVenda = horarioVenda;
    }

    public JpaVendaEntity(JpaCompradorEntity comprador, JpaIngressoEntity ingresso, Double valorPago) {
        this.comprador    = comprador;
        this.ingresso     = ingresso;
        this.valorPago    = valorPago;
        this.horarioVenda = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JpaCompradorEntity getComprador() {
        return comprador;
    }

    public void setComprador(JpaCompradorEntity comprador) {
        this.comprador = comprador;
    }

    public JpaIngressoEntity getIngresso() {
        return ingresso;
    }

    public void setIngresso(JpaIngressoEntity ingresso) {
        this.ingresso = ingresso;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public LocalDateTime getHorarioVenda() {
        return horarioVenda;
    }

    public void setHorarioVenda(LocalDateTime horarioVenda) {
        this.horarioVenda = horarioVenda;
    }
}
