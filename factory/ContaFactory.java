package poo.pilares.modulo_10.desafio.factory;

import poo.pilares.modulo_10.desafio.model.ContaBancaria;

public interface ContaFactory {
    ContaBancaria criarConta(double saldoInicial);
}