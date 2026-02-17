package poo.pilares.modulo_10.desafio.factory;

import poo.pilares.modulo_10.desafio.logging.LogService;
import poo.pilares.modulo_10.desafio.logging.Logger;
import poo.pilares.modulo_10.desafio.model.ContaBancaria;

public class ContaSimplesFactory implements ContaFactory {

    @Override
    public ContaBancaria criarConta(double saldoInicial) {
        LogService logger = Logger.getInstance();
        return new ContaBancaria(saldoInicial, logger);
    }
}