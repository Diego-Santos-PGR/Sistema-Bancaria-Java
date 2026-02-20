package poo.pilares.modulo_10.desafio.model;

import poo.pilares.modulo_10.desafio.interfaces.Rendivel;

public class ContaPoupanca extends ContaBancaria implements Rendivel {

    private static final double TAXA_RENDIMENTO = 0.05;

    public ContaPoupanca(String numero) {
        super(numero);
    }

    @Override
    public double aplicarRendimento() {
        double rendimento = getSaldo() * TAXA_RENDIMENTO;
        creditar(rendimento);
        return rendimento;
    }
}