package poo.pilares.modulo_10.desafio.main;

import poo.pilares.modulo_10.desafio.factory.ContaCorrenteFactory;
import poo.pilares.modulo_10.desafio.model.ContaBancaria;
import poo.pilares.modulo_10.desafio.model.ContaCorrente;
import poo.pilares.modulo_10.desafio.observer.GerenciadorNotificacao;
import poo.pilares.modulo_10.desafio.observer.UsuarioObserver;
import poo.pilares.modulo_10.desafio.observer.AuditoriaObserver;
import poo.pilares.modulo_10.desafio.service.ContaService;
import poo.pilares.modulo_10.desafio.factory.ContaFactory;
import poo.pilares.modulo_10.desafio.factory.ContaPoupancaFactory;
import poo.pilares.modulo_10.desafio.logging.Logger;
import poo.pilares.modulo_10.desafio.logging.ConsoleLogger;

public class Main {
    public static void main(String[] args) {

        System.out.println();
        Logger logger = ConsoleLogger.getInstance();
        GerenciadorNotificacao gerenciador = new GerenciadorNotificacao();

        gerenciador.adicionarObserver(new UsuarioObserver("Diego"));
        gerenciador.adicionarObserver(new AuditoriaObserver(logger));

        ContaService service = new ContaService(logger, gerenciador);

        // CONTA POUPANCA - FACTORY
        ContaFactory factoryPoupanca = new ContaPoupancaFactory();
        ContaBancaria contaPoupanca = factoryPoupanca.criarConta("5678");

        // CONTA POUPANCA - DEPOSITO
        service.realizarDeposito(contaPoupanca, 2000);
        service.aplicarRendimento(contaPoupanca);

        System.out.println();

        // CONTA POUPANCA - SAQUE
        service.realizarSaque(contaPoupanca, 200);
        System.out.println("Saldo atual: " + contaPoupanca.getSaldo());

        System.out.println();

        // CONTA CORRENTE - FACTORY
        ContaFactory factoryCorrente = new ContaCorrenteFactory();
        ContaBancaria contaCorrente = factoryCorrente.criarConta("1234");

        // CONTA CORRENTE - DEPOSITO
        service.realizarDeposito(contaCorrente, 1000);
        service.aplicarRendimento(contaCorrente);

        System.out.println();

        // CONTA CORRENTE - SAQUE
        service.realizarSaque(contaCorrente, 1300);
        System.out.println("Saldo atual: " + contaCorrente.getSaldo());

        // Só acessa limite se for realmente ContaCorrente
        if (contaCorrente instanceof ContaCorrente corrente) {
            System.out.println("Limite disponível: " + corrente.getLimiteDisponivel());
        }
    }
}