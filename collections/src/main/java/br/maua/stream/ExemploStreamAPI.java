package br.maua.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ExemploStreamAPI {

    public static void main(String[] args) {
        // Cria a coleção de estudantes
        List<String> estudantes = new ArrayList<>();

        // Adiciona estudantes para a coleção
        estudantes.add("Pedro");
        estudantes.add("Thayse");
        estudantes.add("Marcelo");
        estudantes.add("Carla");
        estudantes.add("Juliana");
        estudantes.add("Thiago");
        estudantes.add("Rafael");

        // Retorna a contagem de elementos do stream
        System.out.println("Contagem: " + estudantes.stream().count());

        // Retorna o elemento com maior número de letras
        System.out.println("\nMaior número de letras: " + estudantes.stream().max(Comparator.comparingInt(String::length)));

        // Retorna o elemento com menor número de letras
        System.out.println("\nMenor número de letras: " + estudantes.stream().min(Comparator.comparingInt(String::length)));

        // Retorna os elementos que possuem a letra R no nome
        System.out.println("\nCom letra r no nome: " + estudantes.stream().filter((estudante) ->
                estudante.toLowerCase().contains("r")).collect(Collectors.toList()));

        // Retorna uma nova coleção, com os nomes concatenados a quantidade de letra de cada nomes
        System.out.println("\nRetorna uma nova coleção com a quantidade de letras: " + estudantes.stream().map(estudante ->
                estudante.concat(" - ").concat(String.valueOf(estudante.length()))).collect(Collectors.toList()));

        // Retorna somente os 3 primeiros elementos da coleção
        System.out.println("\nRetorna os 3 primeiros elementos: " + estudantes.stream().limit(3).collect(Collectors.toList()));

        // Exibe cada elemento no console, e depois retorna a mesma coleção
        System.out.println("\nRetorna os elemeentos: " + estudantes.stream().peek(System.out::println).collect(
                Collectors.toList()));

        // Exibe cada elemento no console sem retornar outra coleção
        System.out.println("\nRetorna os elementos novamente: ");
        estudantes.stream().forEach(System.out::println);

        // Retorna true se todos os elementos possuem a letra w no nome
        System.out.println("\nTodos os elementos com W no nome? " + estudantes.stream().allMatch((elemento) ->
                elemento.contains("W")));

        // Retorna true se algum dos elementos possuem a letra minúscula no nome
        System.out.println("\nTem algum elemento com a minúscula (a) no nome: " + estudantes.stream().anyMatch((elemento) ->
                elemento.contains("a")));

        // Retorna true se nenhum dos elementos possuem a letra minúscula no nome
        System.out.println("\nNão tem nenhum elemento com a minúscula (a) no nome: " + estudantes.stream().noneMatch(
                (elemento) -> elemento.contains("a")));

        // Retorna o primeiro elemento da coleção, se existir, exibe no console
        System.out.println("\nRetorna o pimeiro elemento da coleção: ");
        estudantes.stream().findFirst().ifPresent(System.out::println);

        // Exemplo de operação encadeada
        System.out.println("\nOperação encadeada: ");
        System.out.println(estudantes.stream()
                .peek(System.out::println)
                .map(estudante -> estudante.concat(" - ").concat(String.valueOf(estudante.length())))
        .peek(System.out::println)
        .filter((estudante) -> estudante.toLowerCase().contains("r"))
        .collect(Collectors.toList()));
        //.collect(Collectors.joining(", ")));      // Separa em um string com vírgula
        //.collect(Collectors.toSet()));
        //.collect(Collectors.groupingBy(estudante -> estudante.substring(estudante.indexOf("-") + 1))));
    }
}
