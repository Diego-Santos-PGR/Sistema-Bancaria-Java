package poo.pilares.modulo_10.desafio.service;

import poo.pilares.modulo_10.desafio.model.ContaBancaria;
import poo.pilares.modulo_10.desafio.observer.EventoConta;
import poo.pilares.modulo_10.desafio.observer.GerenciadorNotificacao;

public class ContaService {

    private final GerenciadorNotificacao gerenciador;

    public ContaService(GerenciadorNotificacao gerenciador) {
        this.gerenciador = gerenciador;
    }

    public void realizarDeposito(ContaBancaria conta, double valor) {

        EventoConta evento = conta.depositar(valor);
        gerenciador.notificar(evento);
    }

    public void realizarSaque(ContaBancaria conta, double valor) {

        EventoConta evento = conta.sacar(valor);
        gerenciador.notificar(evento);
    }
}