package br.maua;

public class TesteRunnable {
    public static void main(String[] args) {

        Thread t = new Thread(new MinhaPrimeiraAtividade());
        t.start();      // O método run da MinhaPrimeiraAtividade será executado
        System.out.println("Main acabando...");
        System.out.printf("Thread do método main: %s\n", Thread.currentThread().getName());
    }
}
