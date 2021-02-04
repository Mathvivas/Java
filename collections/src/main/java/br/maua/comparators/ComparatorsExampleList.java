package br.maua.comparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorsExampleList {

    public static void main(String[] args) {
        List<Estudante> estudantes = new ArrayList<>();

        estudantes.add(new Estudante("Pedro", 19));
        estudantes.add(new Estudante("Carlos", 23));
        estudantes.add(new Estudante("Mariana", 21));
        estudantes.add(new Estudante("João", 18));
        estudantes.add(new Estudante("Thiago", 20));
        estudantes.add(new Estudante("George", 22));
        estudantes.add(new Estudante("Larissa", 21));

        System.out.println("\n---| Ordem de Inserção |---");
        System.out.println(estudantes);

        // Sintaxe Lambda
        estudantes.sort((first, second) -> (first.getIdade() - second.getIdade()));

        System.out.println("\n---| Ordem Natural dos Números - Idade |---");
        System.out.println(estudantes);

        // Sintaxe Lambda
        estudantes.sort((first, second) -> (second.getIdade() - first.getIdade()));

        System.out.println("\n---| Ordem Reversa dos Números - Idade |---");
        System.out.println(estudantes);

        estudantes.sort(Comparator.comparingInt(Estudante::getIdade));

        System.out.println("\n---| Ordem Natural dos Números - Idade (method reference) |---");
        System.out.println(estudantes);

        estudantes.sort(Comparator.comparingInt(Estudante::getIdade).reversed());

        System.out.println("\n---| Ordem Reversa dos Números - Idade (method reference) |---");
        System.out.println(estudantes);

        Collections.sort(estudantes);

        System.out.println("\n---| Ordem Natural dos Números - Idade (interface Comparable) |---");
        System.out.println(estudantes);

        Collections.sort(estudantes, new EstudanteOrdemIdadeReversaComparator());

        System.out.println("\n---| Ordem Natural dos Números - idade (interface Comparator |---");
        System.out.println(estudantes);
    }
}
