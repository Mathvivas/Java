package br.maua;

import br.maua.classes.Menu;
import br.maua.classes.ValidadorDeCodigo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<String> codigoPacotes = new ArrayList<>();
        String op;

        do {
            Menu menu = new Menu();
            menu.menu();

            System.out.println("\nDigite o número desejado: ");
            op = scan.nextLine();

            switch (op) {
                default:
                    System.out.println("\nTente Novamente!");
                    break;
                case "1":
                    System.out.println("\nDigite o Código de Barras do Pacote: ");
                    String cod = scan.nextLine();
                    codigoPacotes.add(cod);
                    break;
                case "2":
                    if ( codigoPacotes.isEmpty() ) {
                        System.out.println("\nLista de Pacotes vazia!");
                    } else {
                        ValidadorDeCodigo validadorDeCodigo = new ValidadorDeCodigo();
                        validadorDeCodigo.validar(codigoPacotes);
                    }
                    break;
                case "0":
                    break;
            }

        } while ( op.equals("1") );
    }
}
