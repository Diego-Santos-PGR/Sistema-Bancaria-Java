package poo.pilares.modulo_10.desafio.observer;

public class UsuarioObserver implements Observer {

    private final String nome;

    public UsuarioObserver(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(EventoConta evento) {
        System.out.println(nome + " foi notificado: " +
                           evento.getTipo() +
                           " no valor de R$ " +
                           evento.getValor());
    }
}