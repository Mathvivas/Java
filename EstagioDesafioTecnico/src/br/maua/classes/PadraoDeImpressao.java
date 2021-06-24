package br.maua.classes;

import br.maua.enums.Produto;
import br.maua.enums.Regiao;

public class PadraoDeImpressao {

    public void imprimir(Regiao origem, Regiao destino, String codLoggi,
                         String codVendedor, Produto produto) {

        System.out.println("\n|-------------------|");
        System.out.println("Região de Origem: " + origem);
        System.out.println("Região de Destino: " + destino);
        System.out.println("Código Loggi: " + codLoggi);
        System.out.println("Código do Vendedor do Produto: " + codVendedor);
        System.out.println("Tipo do Produto" + produto);
        System.out.println("|-------------------|");
    }
}
