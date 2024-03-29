package br.maua.classes;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Esta classe tem como objetivo realizar a
 * listagem das necessidades da empresa.
 *
 * @author Matheus
 */
public class Listagem {

    public static Integer posVendedor = 3;
    public static Integer posDestino = 1;

    public void adicionarNumeroDeCodigosPorVendedor(String[] codigoSeparado, Map<String, Integer> vendedores) {

        if ( !vendedores.containsKey(codigoSeparado[posVendedor]) ) {
            vendedores.put(codigoSeparado[posVendedor], 1);
        } else {
            vendedores.put(codigoSeparado[posVendedor], (vendedores.get(codigoSeparado[posVendedor]) + 1));
        }
    }

    public void listarNumeroDeCodigosPorVendedor(Map<String, Integer> vendedores) {

        for ( String key : vendedores.keySet() ) {
            System.out.println("\nVendedor: " + key + " --> " + " Envios: " + vendedores.get(key));
        }
    }

    public void adicionarCodigosPorDestino(String codigo, String[] codigoSeparado, Map<String, Set<String>> codDestino) {

        if ( !codDestino.containsKey(codigoSeparado[posDestino]) ) {
            Set<String> setCodigos = new HashSet<>();
            setCodigos.add(codigo);
            codDestino.put(codigoSeparado[posDestino], setCodigos);
        } else {
            Set<String> aux = codDestino.get(codigoSeparado[posDestino]);
            aux.add(codigo);
            codDestino.put(codigoSeparado[posDestino], aux);
        }
    }

    public void listarCodigosPorDestino(Map<String, Set<String>> codDestino) {

        for ( String destino : codDestino.keySet() ) {
            System.out.println("\n-------------------------");
            System.out.println("Destino: " + destino);
            System.out.println("Código(s): " + codDestino.get(destino).toString());
        }
    }
}
