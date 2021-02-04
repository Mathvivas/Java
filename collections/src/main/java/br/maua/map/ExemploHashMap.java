package br.maua.map;

import java.util.HashMap;
import java.util.Map;

/*
    Entrada de chave e valor
    Permite valores repetidos, mas não permite repetição de chave
    Permite adição, busca por chave ou valor, atualização, remoção e navegação
    Pode ser ordenada, mas não mantém a ordem de inserção
*/

public class ExemploHashMap {

    public static void main(String[] args) {
        Map<String, Integer> campeosMundialFifa = new HashMap<>();

        // Adiciona os campeões mundiais fifa no mapa
        campeosMundialFifa.put("Brasil", 5);
        campeosMundialFifa.put("Alemanha", 4);
        campeosMundialFifa.put("Itália", 4);
        campeosMundialFifa.put("Uruguai", 2);
        campeosMundialFifa.put("Argentina", 2);
        campeosMundialFifa.put("França", 2);
        campeosMundialFifa.put("Inglaterra", 1);
        campeosMundialFifa.put("Espanha", 1);

        System.out.println(campeosMundialFifa);

        // Atualiza o valor para a chave Brasil
        campeosMundialFifa.put("Brasil", 6);
        System.out.println(campeosMundialFifa);

        // Retorna a Argentina
        System.out.println(campeosMundialFifa.get("Argentina"));

        // Retorna se existe ou não um campeão França
        System.out.println(campeosMundialFifa.containsKey("França"));

        // Remove o campeão França
        campeosMundialFifa.remove("França");

        // Retorna se existe ou não um campeão França
        System.out.println(campeosMundialFifa.containsKey("França"));

        // Retorna se existe ou não alguma seleção hexa campeã
        System.out.println(campeosMundialFifa.containsValue(6));

        // Retorna o tamanho do map
        System.out.println("\nsize = " + campeosMundialFifa.size());

        System.out.println("\n");

        // Navega nos registos do map
        for ( Map.Entry<String, Integer> entry : campeosMundialFifa.entrySet() ) {
            System.out.println(entry.getKey() + " --- " + entry.getValue());
        }

        System.out.println("\n");

        // Navega nos registos do map
        for ( String key : campeosMundialFifa.keySet() ) {
            System.out.println(key + " --- " + campeosMundialFifa.get(key));
        }

        System.out.println(campeosMundialFifa.containsValue(5));
    }
}
