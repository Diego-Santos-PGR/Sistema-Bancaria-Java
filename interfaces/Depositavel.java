package poo.pilares.modulo_10.desafio.interfaces;

import poo.pilares.modulo_10.desafio.observer.EventoConta;

public interface Depositavel {
    EventoConta depositar(double valor);
}