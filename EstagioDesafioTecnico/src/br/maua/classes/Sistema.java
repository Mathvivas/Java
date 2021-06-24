package br.maua.classes;

import br.maua.enums.Produto;
import br.maua.enums.Regiao;

import java.util.Arrays;
import java.util.Set;

/**
 * Esta classe possui o objetivo de analisar os
 * códigos de barras válidos, descobrindo sua
 * origem, destino e o tipo de produto
 *
 * @author Matheus
 */
public class Sistema {

    public void rodar(Produto[] produtos, String[] codigos, Set<String> codigosValidos, Set<String> codigosInvalidos) {

        Regiao[] regioes;
        regioes = (Regiao[]) Arrays.stream(Regiao.values()).toArray();

    }
}
