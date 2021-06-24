package br.maua.classes;

import br.maua.enums.Produto;
import br.maua.enums.Regiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Esta classe permite realizar a validação do código
 * de barras de acordo com as especificações impostas
 *
 * @author Matheus
 */
public class ValidadorDeCodigo {

    public static final Integer TAMANHO_CODIGO = 15;
    public static final String VENDEDOR_INVALIDO = "584";

    public void validar(String codigo) {

        String[] codigos = codigo.split("(?<=\\G.{3})");

        Produto[] produtos;
        produtos = (Produto[]) Arrays.stream(Produto.values()).toArray();
        Regiao[] regioes;
        regioes = (Regiao[]) Arrays.stream(Regiao.values()).toArray();

        // Verificando o código do vendedor (código 584 é inválido)
        if ( codigos[3].equals(VENDEDOR_INVALIDO) ) {
            System.out.println("\nCódigo do Vendedor é Inválido!");
        }

        if ( codigos[1].equals(Regiao.CENTROOESTE.getCodigo()) && codigos[0].equals(Produto.JOIAS.getCodigo()) ) {
            System.out.println("\nNão é possível despachar pacotes contendo jóias vindo do Centro-Oeste!");
        }

        // Checando se os Produtos possuem código diferente do permitido
        List<String> produtosValidos = new ArrayList<>();
        for (Produto prod : produtos) {
            produtosValidos.add(prod.getCodigo());
        }

        if ( !produtosValidos.contains(codigos[4]) ) {
            System.out.println("\nProduto não permitido!");
        }
    }
}
