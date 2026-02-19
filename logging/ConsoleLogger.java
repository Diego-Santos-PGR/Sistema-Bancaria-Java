package poo.pilares.modulo_10.desafio.logging;

public final class ConsoleLogger implements Logger {

    private ConsoleLogger() {}

    private static class Holder {
        private static final ConsoleLogger INSTANCE = new ConsoleLogger();
    }

    public static ConsoleLogger getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public void log(String mensagem) {
        System.out.println("[LOG] " +  mensagem);
    }
}