package br.maua.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/*
    Entrada de chave e valor
    Permite valores repetidos, mas não permite repetição de chave
    Permite adição, busca por chave ou valor, atualização, remoção e navegação
    Pode ser ordenada
*/

public class ExemploHashTable {

    public static void main(String[] args) {
        Hashtable<String, Integer> estudantes = new Hashtable<>();

        estudantes.put("Carlos", 33);
        estudantes.put("Mariana", 21);
        estudantes.put("Rafaela", 18);
        estudantes.put("Pedro", 44);

        System.out.println(estudantes);

        // Atualiza a chave
        estudantes.put("Pedro", 55);

        System.out.println(estudantes);

        estudantes.remove("Pedro");

        System.out.println(estudantes);

        int idade = estudantes.get("Mariana");
        System.out.println(idade);

        System.out.println("size = " + estudantes.size());

        // Navega nos registros
        for ( Map.Entry<String, Integer> entry : estudantes.entrySet() ) {
            System.out.println(entry.getKey() + " -- " + entry.getValue());
        }

        // Navega nos registros
        for ( String key : estudantes.keySet() ) {
            System.out.println(key + " --- " + estudantes.get(key));
        }
    }
}
