package br.maua.corrida;

public class Atualizador implements Runnable {

    int variavel = 0;

    @Override
    public void run() {
        for ( int i = 1; i <= 100_000; i++ ) {
            variavel++;
        }
    }
}
