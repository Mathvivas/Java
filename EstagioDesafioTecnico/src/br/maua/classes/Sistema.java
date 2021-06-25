package br.maua.classes;

import br.maua.enums.Produto;
import br.maua.enums.Regiao;

import java.util.Arrays;

/**
 * Esta classe possui o objetivo de analisar os
 * códigos de barras válidos, descobrindo sua
 * origem, destino e o tipo de produto.
 *
 * @author Matheus
 */
public class Sistema {

    public void rodar(Produto[] produtos, String[] codigos) {

        Regiao[] regioes;
        regioes = Arrays.stream(Regiao.values()).toArray(Regiao[]::new);

        Regiao origem = null, destino = null;
        Produto tipoProduto = null;

        for ( Regiao reg : regioes ) {
            if ( reg.getCodigo().equals(codigos[0]) ) {
                origem = reg;

            } else if ( reg.getCodigo().equals(codigos[1]) ) {
                destino = reg;
            }
        }

        for ( Produto prod : produtos ) {
            if ( prod.getCodigo().equals(codigos[4]) ) {
                tipoProduto = prod;
            }
        }

        String codigo = String.join("", codigos);
        PadraoDeImpressao padraoDeImpressao = new PadraoDeImpressao();
        padraoDeImpressao.imprimir(codigo, origem, destino, codigos[2], codigos[3], tipoProduto);
    }
}
