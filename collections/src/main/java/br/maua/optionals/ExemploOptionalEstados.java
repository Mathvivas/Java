package br.maua.optionals;

import java.util.Optional;

public class ExemploOptionalEstados {

    public static void main(String[] args) {
                                        // Optional.of requer um valor não nulo
        Optional<String> optionalString = Optional.of("Valor presente");
                                        // Método "of" não existe com tipo int (neste caso)

        System.out.println("Valor opcional que está presente");
        optionalString.ifPresentOrElse(System.out::println, () -> System.out.println("não está presente"));
        // Se estiver presente, executa a função lambda, se não, printa "não está presente"

        Optional<String> optionalNull = Optional.ofNullable(null);

        System.out.println("Valor opcional que não está presente");
        optionalNull.ifPresentOrElse(System.out::println, () -> System.out.println("null = não está presente"));

        Optional<String> emptyOptional = Optional.empty();

        System.out.println("Valor opcional que não está presente");
        emptyOptional.ifPresentOrElse(System.out::println, () -> System.out.println("empty = não está presente"));

        Optional<String> optionalNullErro = Optional.of(null);

        System.out.println("Valor opcional que lança erro NullPointerException");
        optionalNullErro.ifPresentOrElse(System.out::println, () -> System.out.println("erro = não está presente"));
    }
}
