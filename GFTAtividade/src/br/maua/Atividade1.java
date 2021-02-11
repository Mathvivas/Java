package br.maua;

import java.util.Scanner;

public class Atividade1 {

    Scanner scan = new Scanner(System.in);

    public void run() {

        System.out.println("\nDigite o multiplicando: ");
        int mult = scan.nextInt();

        System.out.println("\nDigite o número incial da multiplicação: ");
        int inicio = scan.nextInt();

        System.out.println("\nDigite o número final da multiplicação: ");
        int fim = scan.nextInt();

        System.out.println("\nMultiplicando: " + mult);
        System.out.println("\nInício do Intervalo: " + inicio);
        System.out.println("\nFim do Intervalo: " + fim);

        for ( int i = inicio; i <= fim; i++ ) {
            System.out.println(mult + " x " + i + " = " + (i * mult));
        }
    }
}
