package org.arturmatukiwa.pratica.arch_hexagonal.core.domain.comprador;

import org.arturmatukiwa.pratica.arch_hexagonal.core.exception.PropriedadeInvalidaException;

import java.util.Objects;

public class Comprador {
    private Long id;
    private String nome;
    private String telefone;
    private Cpf cpf;

    public Comprador(Long id, String nome, String telefone, Cpf cpf) {
        Objects.requireNonNull(cpf, "'cpf' possui valor nulo");
        Objects.requireNonNull(id, "'id' possiu valor nulo");

        validarDados(nome, telefone);

        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public Comprador(String nome, String telefone, Cpf cpf) {
        Objects.requireNonNull(cpf, "'cpf' possi valor nulo");

        validarDados(nome, telefone);

        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    private void validarDados(String nome, String telefone) {
        if(nome.isBlank()) {
            throw new PropriedadeInvalidaException("'nome' não pode estar vazio");
        }

        validarTelefoneRecebido(telefone);
    }

    public void alterarTelefone(String telefoneAtualizado) {
        validarTelefoneRecebido(telefoneAtualizado);

        this.telefone =  telefoneAtualizado;
    }

    private void validarTelefoneRecebido(String telefoneRecebido) {
        Objects.requireNonNull(telefoneRecebido, "'telefone' possui valor nulo");
        if(telefoneRecebido.isBlank())  {
            throw new PropriedadeInvalidaException("'telefone' não pode estar vazio");
        }

        if(!telefoneRecebido.matches("\\d+")) {
            throw new PropriedadeInvalidaException("'telefone' possui caracter não numérico. Valor recebido: "+ telefone);
        }

        if(telefoneRecebido.length() != 11) {
            throw new PropriedadeInvalidaException("'telefone' do comprador não possui 11 dígitos. Valor recebido: "+ telefone);
        }
    }


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public Cpf getCpf() {
        return cpf;
    }
}
