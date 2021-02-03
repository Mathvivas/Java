package br.maua.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ExemploList {

    public static void main(String[] args) {

        List<String> nomes = new ArrayList<>();

        nomes.add("Matheus");
        nomes.add("Carlos");
        nomes.add("Juliana");
        nomes.add("Bárbara");

        System.out.println(nomes);

        Collections.sort(nomes);

        System.out.println(nomes);

        nomes.set(2, "Larissa");

        System.out.println(nomes);

        nomes.remove(1);
        nomes.remove("Larissa");

        System.out.println(nomes);

        int pos = nomes.indexOf("Wesley");  // Retorna -1, pois não existe
        System.out.println(pos);

        // foreach
        for ( String nome : nomes ) {
            System.out.println("--> " + nome);
        }

        Iterator<String> iterator = nomes.iterator();

        while (iterator.hasNext()) {
            System.out.println("----> " + iterator.next());
        }
    }
}
