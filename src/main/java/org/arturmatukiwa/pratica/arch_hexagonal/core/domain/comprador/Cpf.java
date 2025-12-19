package org.arturmatukiwa.pratica.arch_hexagonal.core.domain.comprador;

import java.util.Objects;

public class Cpf {
    private String valor;

    public Cpf(String valor) {
        if(!valor.matches("\\d{11}")){
            throw new IllegalArgumentException("Cpf "+ valor +" inválido");
        }
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cpf cpf = (Cpf) o;
        return Objects.equals(valor, cpf.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(valor);
    }

    public String getValor() {
        return valor;
    }
}
