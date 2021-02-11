package br.maua;

import java.util.Scanner;

public class Atividade1 {

    Scanner scan = new Scanner(System.in);

    public void run() {

        System.out.println("\nDigite o multiplicando: ");
        int mult = scan.nextInt();

        if ( (mult < 0) || (mult > 3000) ) {
            System.out.println("\nValor Inválido! Multiplicador precisa estar entre 0 e 3000!");
        }

        System.out.println("\nDigite o número incial da multiplicação: ");
        int inicio = scan.nextInt();

        System.out.println("\nDigite o número final da multiplicação: ");
        int fim = scan.nextInt();

        int intervalo = fim - inicio;

        if ( fim < inicio ) {
            System.out.println("\nO início do intervalo deve ser menor que seu fim!");
        }

        if ( intervalo > 10 ) {
            System.out.println("\nO intervalo não pode ter uma diferença maior que 10.");
        }

        System.out.println("\nMultiplicando: " + mult);
        System.out.println("\nInício do Intervalo: " + inicio);
        System.out.println("\nFim do Intervalo: " + fim);

        for ( int i = inicio; i <= fim; i++ ) {
            System.out.println(mult + " x " + i + " = " + (i * mult));
        }
    }
}
