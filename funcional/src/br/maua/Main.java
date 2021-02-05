package br.maua;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    int[] valores = {1, 2, 3, 4};

        /*
            Funcional:
            Declaramos o que desejamos, sem explicitar como será feito.
         */
        Arrays.stream(valores)
                .filter(valor -> valor % 2 == 0)
                .map(valor -> valor * 2)
                .forEach(valor -> System.out.println(valor));

        System.out.println("\nOutro método\n");

        // Imperativo
        for ( int i = 0; i < valores.length; i++ ) {
            int val = 0;

            if ( valores[i] % 2 == 0 ) {
                val = valores[i] * 2;

                if ( val != 0 ) {
                    System.out.println(val);
                }
            }
        }
    }
}
