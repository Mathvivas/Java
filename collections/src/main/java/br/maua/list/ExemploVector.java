package br.maua.list;

import java.util.List;
import java.util.Vector;

public class ExemploVector {

    public static void main(String[] args) {
        List<String> esportes = new Vector<>();

        esportes.add("Futebol");
        esportes.add("Basquete");
        esportes.add("Tênis de Mesa");
        esportes.add("Volêi");

        System.out.println(esportes.get(2));

        for( String esporte: esportes ) {
            System.out.println(esporte);
        }
    }
}
