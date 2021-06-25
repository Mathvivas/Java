package br.maua.classes;

import java.util.Map;

/**
 * Esta classe tem como objetivo realizar a
 * listagem das necessidades da empresa
 *
 * @author Matheus
 */
public class Listagem {

    public static Integer posVendedor = 3;

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
}
