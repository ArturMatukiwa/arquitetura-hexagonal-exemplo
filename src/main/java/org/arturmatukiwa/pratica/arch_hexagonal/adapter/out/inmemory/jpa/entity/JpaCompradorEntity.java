package org.arturmatukiwa.pratica.arch_hexagonal.adapter.out.inmemory.jpa.entity;

import jakarta.persistence.*;
import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.comprador.Cpf;

@Entity
@Table(name = "comprador")
public class JpaCompradorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comprador")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "cpf")
    private String cpf;

    public JpaCompradorEntity() {
    }

    public JpaCompradorEntity(Long id, String nome, String telefone, String cpf) {
        this.id       = id;
        this.nome     = nome;
        this.telefone = telefone;
        this.cpf      = cpf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
