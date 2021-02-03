package br.maua.queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ExemploLinkedList {

    public static void main(String[] args) {
        Queue<String> filaBanco = new LinkedList<>();

        filaBanco.add("Patricia");
        filaBanco.add("Roberto");
        filaBanco.add("Flávio");
        filaBanco.add("Pamela");
        filaBanco.add("Anderson");

        System.out.println(filaBanco);

        String clienteASerAtendido = filaBanco.poll();  // Retorna e remove
        System.out.println(clienteASerAtendido);
        System.out.println(filaBanco);

        String primeiroCliente = filaBanco.peek();   // Retorna, mas não remove
        System.out.println(primeiroCliente);
        System.out.println(filaBanco);

        // filaBanco.clear();       // remove lança uma exceção, peek retorna null

        String primeiroClienteOuErro = filaBanco.element();
        System.out.println(primeiroClienteOuErro);
        System.out.println(filaBanco);

        for ( String client : filaBanco ) {
            System.out.println(client);
        }

        Iterator<String> iteratorFilaBanco = filaBanco.iterator();

        while ( iteratorFilaBanco.hasNext() ) {
            System.out.println("---> " + iteratorFilaBanco.next());
        }

        System.out.println(filaBanco.size());
        System.out.println(filaBanco.isEmpty());
    }
}
