package poo.pilares.modulo_10.desafio.factory;

import poo.pilares.modulo_10.desafio.model.ContaBancaria;
import poo.pilares.modulo_10.desafio.model.ContaCorrente;

public class ContaCorrenteFactory implements ContaFactory {

    @Override
    public ContaBancaria criarConta(String numero) {
        return new ContaCorrente(numero);
    }
}