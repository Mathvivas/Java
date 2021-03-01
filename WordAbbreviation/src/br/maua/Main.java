package br.maua;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] palavras;
        String frase;
        int contador = 0;
        Map<Character, String> utilizados = new HashMap<>();

        Scanner scan = new Scanner(System.in);

        System.out.println("Digite uma frase a ser abreviada: ");
        frase = scan.nextLine();

        palavras = frase.split(" ");

        for ( String palavra : palavras ) {
            if ( !(utilizados.containsKey(palavra.charAt(0))) ) { // Se o map não contém a primeira letra da palavra
                System.out.print(palavra.charAt(0) + ". ");
                utilizados.put(palavra.charAt(0), palavra);
                contador++;

            } else {
                System.out.print(palavra + " ");
            }
        }

        System.out.print("\nNúmero de abreviações: " + contador);

        System.out.print("\n");

        for ( Map.Entry<Character, String> auxiliar : utilizados.entrySet() ) {
            System.out.println(auxiliar.getKey() + ". = " + auxiliar.getValue());
        }
    }
}
