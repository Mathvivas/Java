package br.maua;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] palavras;
        String frase;
        List<Character> utilizados = new ArrayList<Character>();

        Scanner scan = new Scanner(System.in);

        System.out.println("Digite uma frase a ser abreviada: ");
        frase = scan.nextLine();

        palavras = frase.split(" ");

        for ( String palavra : palavras ) {
            if (!utilizados.contains(palavra.charAt(0))) { // Se o array não contém a primeira letra da palavra
                System.out.print(palavra.charAt(0) + " ");
                utilizados.add(palavra.charAt(0));

            } else {
                System.out.print(palavra);
            }
        }

        //System.out.println(palavras[0].charAt(0));
    }
}
