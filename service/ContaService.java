package poo.pilares.modulo_10.desafio.service;

import poo.pilares.modulo_10.desafio.interfaces.Rendivel;
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

    private static final double VALOR_MINIMO = 1.0;

    public ContaService(Logger logger, GerenciadorNotificacao notificacao) {
        this.logger = logger;
        this.notificacao = notificacao;
    }

    public void realizarDeposito(ContaBancaria conta, double valor) {

        if (valor < VALOR_MINIMO) {
            throw new ValorInvalidoException("Valor inválido para deposito");
        }
        conta.creditar(valor);
        logger.log(String.format("Depósito de: R$ %.2f realizado com sucesso.", valor));
        notificacao.notificar(new EventoConta(TipoEvento.DEPOSITO, valor));
    }

    public void realizarSaque(ContaBancaria conta, double valor) {

        if (valor < VALOR_MINIMO) {
            throw new ValorInvalidoException("Valor inválido para saque.");
        }

        if (!conta.podeSacar(valor)) {
            throw new SaldoInsuficienteException("Saldo insuficiente para saque.");
        }
        conta.debitar(valor);
        logger.log(String.format("Saque de: R$ %.2f realizado com sucesso.", valor));
        notificacao.notificar(new EventoConta(TipoEvento.SAQUE, valor));
    }

    public void aplicarRendimento(ContaBancaria conta) {

        if (conta instanceof Rendivel rendivel) {

            double valorRendimento = rendivel.aplicarRendimento();
            logger.log(String.format("Rendimento aplicado R$ %.2f", valorRendimento));
            notificacao.notificar(new EventoConta(TipoEvento.RENDIMENTO, valorRendimento));
        }
    }
}