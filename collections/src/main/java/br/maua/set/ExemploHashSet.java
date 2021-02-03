package br.maua.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ExemploHashSet {

    public static void main(String[] args) {
        Set<Double> notasAlunos = new HashSet<>();
        // Não permite ordenação

        notasAlunos.add(5.8);
        notasAlunos.add(9.3);
        notasAlunos.add(6.5);
        notasAlunos.add(10.0);
        notasAlunos.add(5.4);
        notasAlunos.add(7.3);
        notasAlunos.add(3.8);
        notasAlunos.add(4.0);

        // Não garante a ordem que foi inserida
        System.out.println(notasAlunos);

        notasAlunos.remove(3.8);
        System.out.println(notasAlunos);

        System.out.println("size = " + notasAlunos.size());

        Iterator<Double> iterator = notasAlunos.iterator();
        while ( iterator.hasNext() ) {
            System.out.println(iterator.next());
        }

        System.out.println("\n");

        for ( Double nota: notasAlunos ) {
            System.out.println(nota);
        }
    }
}
