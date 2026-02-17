package poo.pilares.modulo_10.desafio.observer;

import java.util.List;
import java.util.ArrayList;

public class GerenciadorNotificacao {

    private final List<Observer> observers = new ArrayList<>();

    public void adicionarObserver(Observer observer) {
        observers.add(observer);
    }

    public void removerObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notificar(EventoConta evento) {
        for (Observer observer : observers) {
            observer.atualizar(evento);
        }
    }
}