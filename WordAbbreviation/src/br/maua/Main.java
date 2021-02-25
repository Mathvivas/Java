package br.maua;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] palavras;
        String frase;
        String[] utilizados;

        Scanner scan = new Scanner(System.in);

        System.out.println("Digite uma frase a ser abreviada: ");
        frase = scan.nextLine();

        palavras = frase.split(" ");

        for ( String palavra : palavras ) {
            System.out.println(palavra);
        }
    }
}
