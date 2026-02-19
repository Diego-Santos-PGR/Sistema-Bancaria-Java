package poo.pilares.modulo_10.desafio.observer;

import poo.pilares.modulo_10.desafio.model.ContaBancaria;
import poo.pilares.modulo_10.desafio.logging.Logger;

public class AuditoriaObserver implements Observer {

    private final Logger logger;

    public AuditoriaObserver(Logger logger) {
        this.logger = logger;
    }
    @Override
    public void atualizar(EventoConta evento) {
        logger.log("Evento: " + evento.getTipo());
    }
}