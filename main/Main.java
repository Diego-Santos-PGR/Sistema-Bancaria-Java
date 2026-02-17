package poo.pilares.modulo_10.desafio.main;

import poo.pilares.modulo_10.desafio.model.ContaBancaria;
import poo.pilares.modulo_10.desafio.observer.GerenciadorNotificacao;
import poo.pilares.modulo_10.desafio.observer.UsuarioObserver;
import poo.pilares.modulo_10.desafio.observer.AuditoriaObserver;
import poo.pilares.modulo_10.desafio.service.ContaService;
import poo.pilares.modulo_10.desafio.factory.*;


public class Main {
    public static void main(String[] args) {

        System.out.println();
        GerenciadorNotificacao gerenciador = new GerenciadorNotificacao();

        ContaService service = new ContaService(gerenciador);

        gerenciador.adicionarObserver(new UsuarioObserver("Diego"));
        gerenciador.adicionarObserver(new AuditoriaObserver());

        ContaFactory factory = new ContaSimplesFactory();
        ContaBancaria conta = factory.criarConta(100);

        service.realizarDeposito(conta, 10);

        System.out.println();
        service.realizarSaque(conta, 20);
    }
}