package br.maua.corrida;

public class Piloto implements Runnable {

    private static final double distanciaTotalDaCorrida = 200;    // static, único para todos os pilotos, de classe
    private double distanciaTotalPercorrida = 0;
    private Thread main;

    public Piloto(Thread main) {
        this.main = main;
    }

    @Override
    public void run() {

        try {
            main.join();    // Junta todas as threads até que o método main termine a execução
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while ( distanciaTotalPercorrida <= distanciaTotalDaCorrida ) {
            distanciaTotalPercorrida += Math.random() * 50;     // Entre 0 e 50
            System.out.printf("%s: %.2f m\n", Thread.currentThread().getName(), distanciaTotalPercorrida);

            if ( distanciaTotalPercorrida > distanciaTotalDaCorrida ) {
                System.out.printf("%s acabou.\n", Thread.currentThread().getName());
            }
            else {
                try {
                    Thread.sleep((long) (2000 + Math.random() * 10000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
