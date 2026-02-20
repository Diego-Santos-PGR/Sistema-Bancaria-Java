package poo.pilares.modulo_10.desafio.model;

public abstract class ContaBancaria {

    private final String numero;
    private double saldo;

    public ContaBancaria(String numero) {
        this.numero = numero;
        this.saldo = 0.0;
    }

    public String getNumero() { return numero; }
    public double getSaldo() {
        return saldo;
    }

    public void creditar(double valor) { this.saldo += valor; }
    public void debitar(double valor) { this.saldo -= valor; }
}