package br.maua.set;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class ExemploLinkedHashSet {

    public static void main(String[] args) {
        LinkedHashSet<Integer> sequenciaNumerica = new LinkedHashSet<>();

        sequenciaNumerica.add(1);
        sequenciaNumerica.add(2);
        sequenciaNumerica.add(4);
        sequenciaNumerica.add(8);
        sequenciaNumerica.add(16);

        // Segue a ordem inserida
        System.out.println(sequenciaNumerica);

        sequenciaNumerica.remove(4);
        System.out.println(sequenciaNumerica);

        System.out.println("size = " + sequenciaNumerica.size());

        Iterator<Integer> iterator = sequenciaNumerica.iterator();
        while ( iterator.hasNext() ) {
            System.out.println(iterator.next());
        }

        System.out.println("\n");

        for ( Integer numero : sequenciaNumerica ) {
            System.out.println(numero);
        }
    }
}
