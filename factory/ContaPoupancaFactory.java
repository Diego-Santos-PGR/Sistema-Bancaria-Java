package poo.pilares.modulo_10.desafio.factory;

import poo.pilares.modulo_10.desafio.model.ContaBancaria;
import poo.pilares.modulo_10.desafio.model.ContaPoupanca;

public class ContaPoupancaFactory implements ContaFactory {

    @Override
    public ContaBancaria criarConta(String numero) {
        return new ContaPoupanca(numero);
    }
}