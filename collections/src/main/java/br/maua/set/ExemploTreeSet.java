package br.maua.set;

import java.util.Iterator;
import java.util.TreeSet;

public class ExemploTreeSet {

    public static void main(String[] args) {
        TreeSet<String> treeCapitais = new TreeSet<>();
        // TreeSet é performático para leitura, e mais lento para modificação pois
        // tem a necessidade de reordenar após cada alteração.

        // Monta a árvore com as capitais
        treeCapitais.add("Porto Alegre");
        treeCapitais.add("Florianópolis");
        treeCapitais.add("Curitiba");
        treeCapitais.add("São Paulo");
        treeCapitais.add("Rio de Janeiro");
        treeCapitais.add("Belo Horizonte");

        // Não mantém a ordem inserida
        System.out.println(treeCapitais);

        // Retorna a primeira capital no topo da árvore
        System.out.println(treeCapitais.first());

        // Retorna a última capital no final da árvore
        System.out.println(treeCapitais.last());

        // Retorna a primeira capital abaixo na árvore da capital parametrizada
        System.out.println(treeCapitais.lower("Florianópolis"));

        // Retorna a primeira capital acima na árvore da capital parametrizada
        System.out.println(treeCapitais.higher("Florianópolis"));

        // Exibe todas as capitais
        System.out.println(treeCapitais);

        // Retorna a primeira capital no topo da árvore, removendo do set
        System.out.println(treeCapitais.pollFirst());

        // Retorna a última capital no final da árvore, removendo do set
        System.out.println(treeCapitais.pollLast());

        // Exibe todas as capitais
        System.out.println(treeCapitais);

        // Navega por todos os itens
        Iterator<String> iterator = treeCapitais.iterator();
    }
}
