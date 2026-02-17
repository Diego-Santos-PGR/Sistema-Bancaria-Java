package poo.pilares.modulo_10.desafio.observer;

public class EventoConta {

    private final String tipo;
    private final double valor;

    public EventoConta(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }
}