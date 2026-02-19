package poo.pilares.modulo_10.desafio.main;

import poo.pilares.modulo_10.desafio.model.ContaBancaria;
import poo.pilares.modulo_10.desafio.observer.GerenciadorNotificacao;
import poo.pilares.modulo_10.desafio.observer.TipoEvento;
import poo.pilares.modulo_10.desafio.observer.UsuarioObserver;
import poo.pilares.modulo_10.desafio.observer.AuditoriaObserver;
import poo.pilares.modulo_10.desafio.observer.EventoConta;
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

        ContaFactory factoryPoupanca = new ContaPoupancaFactory();
        ContaBancaria contaPoupanca = factoryPoupanca.criarConta("5678");


        service.realizarDeposito(contaPoupanca, 1000);
        contaPoupanca.aplicarRendimento();
        gerenciador.notificar(new EventoConta(TipoEvento.RENDIMENTO, contaPoupanca.getSaldo()));

        System.out.println();

        service.realizarSaque(contaPoupanca, 100);
        System.out.println("Saldo atual: " + contaPoupanca.getSaldo());
    }
}