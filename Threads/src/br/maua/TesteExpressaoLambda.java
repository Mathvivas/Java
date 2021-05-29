package br.maua;

public class TesteExpressaoLambda {
    public static void main(String[] args) {

        new Thread(() -> {
            System.out.printf("lambda: %s\n", Thread.currentThread().getName());
        }).start();

        // SUBSTITUI

        new Thread(new Runnable() {
            @Override
            public void run() {
               // Classe Interna Anônima
                System.out.printf("run: %s\n", Thread.currentThread().getName());
            }
        })
        .start();
    }
}
