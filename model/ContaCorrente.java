package poo.pilares.modulo_10.desafio.model;

public class ContaCorrente extends ContaBancaria {

    private static final double LIMITE_TOTAL = 500.0;
    private double limiteDisponivel = LIMITE_TOTAL;

    public ContaCorrente(String numero) {
        super(numero);
    }

    @Override
    public boolean podeSacar(double valor) {
        return valor > 0 && valor <= getSaldo() + limiteDisponivel;
    }

    @Override
    public void debitar(double valor) {
        validarValor(valor);

        if (valor <= getSaldo()) {
            super.debitar(valor);
        } else {
            double restante = valor - getSaldo();
            super.debitar(getSaldo());
            limiteDisponivel -= restante;
        }
    }

    public double getLimiteDisponivel() {
        return limiteDisponivel;
    }

    public double getLimiteUtilizado() {
        return LIMITE_TOTAL - limiteDisponivel;
    }

    public double getLimiteTotal() {
        return LIMITE_TOTAL;
    }
}