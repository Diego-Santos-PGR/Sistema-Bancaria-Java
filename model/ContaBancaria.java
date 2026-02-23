package poo.pilares.modulo_10.desafio.model;

import poo.pilares.modulo_10.desafio.exception.ValorInvalidoException;

public abstract class ContaBancaria {

    private final String numero;
    private double saldo;

    public ContaBancaria(String numero) {

        if (numero == null || numero.isBlank()) {
            throw new IllegalArgumentException("Número da conta inválido.");
        }
        this.numero = numero;
        this.saldo = 0.0;
    }

    public String getNumero() { return numero; }
    public double getSaldo() {
        return saldo;
    }

    public void creditar(double valor) {
        validarValor(valor);
        saldo += valor;
    }

    public void debitar(double valor) {
        validarValor(valor);
        saldo -= valor;
    }

    public void validarValor(double valor) {
        if (valor <= 0) {
            throw new ValorInvalidoException("Valor deve ser positivo.");
        }
    }

    public abstract boolean podeSacar(double valor);
}