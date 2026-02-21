package poo.pilares.modulo_10.desafio.observer;

public class EventoConta {

    private final TipoEvento tipo;
    private final double valor;

    public EventoConta(TipoEvento tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public TipoEvento getTipo() {
        return tipo;
    }
    public double getValor() {
        return valor;
    }
}