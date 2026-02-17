package poo.pilares.modulo_10.desafio.logging;

public final class Logger implements LogService {

    private Logger() {
        System.out.println();
    }

    private static class Holder {
        private static final Logger INSTANCE = new Logger();
    }

    public static Logger getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public void log(String mensagem) {
        System.out.println("[LOG] " +  mensagem);
    }
}