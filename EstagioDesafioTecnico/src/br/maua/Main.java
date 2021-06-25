package br.maua;

import br.maua.classes.Menu;
import br.maua.classes.ValidadorDeCodigo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Esta classe é responsável por iniciar a aplicação,
 * instanciando a classe Menu e a classe ValidadorDeCodigo.
 * Por meio desta, a aplicação é executada.
 *
 * @author Matheus
 */
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

/*
    Exemplos de códigos de barras
    Pacote 1: 888555555123888
    Pacote 2: 333333555584333
    Pacote 3: 222333555124000
    Pacote 4: 000111555874555
    Pacote 5: 111888555654777
    Pacote 6: 111333555123333
    Pacote 7: 555555555123888
    Pacote 8: 888333555584333
    Pacote 9: 111333555124000
    Pacote 10: 333888555584333
    Pacote 11: 555888555123000
    Pacote 12: 111888555123555
    Pacote 13: 888000555845333
    Pacote 14: 000111555874000
    Pacote 15: 111333555123555
 */
