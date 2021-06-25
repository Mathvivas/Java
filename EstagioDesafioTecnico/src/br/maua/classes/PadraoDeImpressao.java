package br.maua.classes;

import br.maua.enums.Produto;
import br.maua.enums.Regiao;

/**
 * Esta classe permite imprimir o resultado encontrado
 * através da análise do código de barras
 *
 * @author Matheus
 */
public class PadraoDeImpressao {

    public void imprimir(String codigo, Regiao origem, Regiao destino, String codLoggi,
                         String codVendedor, Produto tipoProduto) {

        System.out.println("\n|-------------------|");
        System.out.println("Código de Barras: " + codigo);
        System.out.println("Região de Origem: " + origem);
        System.out.println("Região de Destino: " + destino);
        System.out.println("Código Loggi: " + codLoggi);
        System.out.println("Código do Vendedor do Produto: " + codVendedor);
        System.out.println("Tipo do Produto" + tipoProduto);
        System.out.println("|-------------------|");
    }
}
