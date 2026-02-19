package poo.pilares.modulo_10.desafio.service;

import poo.pilares.modulo_10.desafio.exception.ValorInvalidoException;
import poo.pilares.modulo_10.desafio.exception.SaldoInsuficienteException;
import poo.pilares.modulo_10.desafio.logging.Logger;
import poo.pilares.modulo_10.desafio.model.ContaBancaria;
import poo.pilares.modulo_10.desafio.observer.EventoConta;
import poo.pilares.modulo_10.desafio.observer.GerenciadorNotificacao;
import poo.pilares.modulo_10.desafio.observer.TipoEvento;

public class ContaService {

    private final Logger logger;
    private final GerenciadorNotificacao notificacao;

    private static final double VALOR_MINIMO_DEPOSITO = 1.0;
    private static final double VALOR_MINIMO_SAQUE = 1.0;

    public ContaService(Logger logger, GerenciadorNotificacao notificacao) {
        this.logger = logger;
        this.notificacao = notificacao;
    }

    public void realizarDeposito(ContaBancaria conta, double valor) {

        if (valor < VALOR_MINIMO_DEPOSITO) {
            throw new ValorInvalidoException("Valor deve ser maior ou igual a R$ 1.00");
        }
        conta.creditar(valor);
        logger.log(String.format("Depósito de: R$ %.2f realizado com sucesso.", valor));
        notificacao.notificar(new EventoConta(TipoEvento.DEPOSITO, valor));
    }

    public void realizarSaque(ContaBancaria conta, double valor) {

        if (valor < VALOR_MINIMO_SAQUE) {
            throw new ValorInvalidoException("Valor inválido para saque.");
        }

        if (valor > conta.getSaldo()) {
            throw new SaldoInsuficienteException("Saldo insuficiente para saque.");
        }
        conta.debitar(valor);
        logger.log(String.format("Saque de: R$ %.2f realizado com sucesso.", valor));
        notificacao.notificar(new EventoConta(TipoEvento.SAQUE, valor));
    }
}