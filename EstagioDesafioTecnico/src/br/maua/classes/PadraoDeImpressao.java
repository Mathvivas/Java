package br.maua.classes;

import br.maua.enums.Produto;
import br.maua.enums.Regiao;

import java.util.Map;

/**
 * Esta classe permite imprimir o resultado encontrado
 * através da análise do código de barras.
 *
 * @author Matheus
 */
public class PadraoDeImpressao {

    public static Integer posVendedor = 3;

    public void imprimir(String codigo, Regiao origem, Regiao destino, String codLoggi,
                         String codVendedor, Produto tipoProduto) {

        System.out.println("\n|---------------------------------------|");
        System.out.println("Código de Barras: " + codigo);
        System.out.println("Região de Origem: " + origem);
        System.out.println("Região de Destino: " + destino);
        System.out.println("Código Loggi: " + codLoggi);
        System.out.println("Código do Vendedor do Produto: " + codVendedor);
        System.out.println("Tipo do Produto: " + tipoProduto);
        System.out.println("|---------------------------------------|");
    }

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
