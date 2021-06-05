public class Atualizador implements Runnable {
    static int variavel = 0;

    @Override
    public void run() {
        for ( int i = 0; i < 100_000; i++ ) {
            synchronized (this) {
                // Somente uma thread por vez
                variavel++;
            }
        }
    }
}
