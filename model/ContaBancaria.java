package poo.pilares.modulo_10.desafio.model;

import java.util.List;
import java.util.ArrayList;

import poo.pilares.modulo_10.desafio.exception.ValorInvalidoException;
import poo.pilares.modulo_10.desafio.exception.SaldoInsuficienteException;
import poo.pilares.modulo_10.desafio.interfaces.Depositavel;
import poo.pilares.modulo_10.desafio.interfaces.Sacavel;
import poo.pilares.modulo_10.desafio.observer.EventoConta;
import poo.pilares.modulo_10.desafio.logging.LogService;

// Representa a entidade do domínio financeiro do sistema
// modelando uma conta bancária com seus dados essenciais
// como titular e saldo
public class ContaBancaria implements Sacavel, Depositavel {

    private double saldo;
    private final LogService logService;

    private static final double VALOR_MINIMO_DEPOSITO = 1.0;
    private static final double VALOR_MINIMO_SAQUE = 1.0;

    public ContaBancaria(double saldoInicial, LogService logService) {
        this.saldo = saldoInicial;
        this.logService = logService;
    }

    @Override
    public EventoConta depositar(double valor) {
        if (valor < VALOR_MINIMO_DEPOSITO) {
            throw new ValorInvalidoException(String.format("Valor inválido para deposito: R$ %.2f", valor));
        }
        saldo += valor;
        logService.log(String.format("Depósito de: R$ %.2f realizado com sucesso.%n", valor));
        return new EventoConta("DEPOSITO", valor);
    }

    @Override
    public EventoConta sacar(double valor) {
        if (valor < VALOR_MINIMO_SAQUE) {
            throw new ValorInvalidoException(String.format("Valor inválido para saque: R$ %.2f", valor));
        }

        if (valor > saldo) {
            throw new SaldoInsuficienteException(String.format("Saldo insuficiente para saque: R$ %.2f", valor));
        }
        saldo -= valor;
        logService.log(String.format("Saque de: R$ %.2f realizado com sucesso.%n", valor));
        return new EventoConta("SAQUE", valor);
    }
    public double getSaldo() {
        return saldo;
    }
}