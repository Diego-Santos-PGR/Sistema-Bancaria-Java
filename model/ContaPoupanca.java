package poo.pilares.modulo_10.desafio.model;

public class ContaPoupanca extends ContaBancaria {

    private static final double TAXA_RENDIMENTO = 0.05;

    public ContaPoupanca(String numero) {
        super(numero);
    }

    @Override
    public void aplicarRendimento() {
        double rendimento = getSaldo() * TAXA_RENDIMENTO;
        creditar(rendimento);
    }
}