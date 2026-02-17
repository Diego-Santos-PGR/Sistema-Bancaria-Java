package poo.pilares.modulo_10.desafio.observer;

import poo.pilares.modulo_10.desafio.logging.Logger;

public class AuditoriaObserver implements Observer {

    @Override
    public void atualizar(EventoConta evento) {
        Logger.getInstance().log("Evento: " + evento.getTipo());
    }
}