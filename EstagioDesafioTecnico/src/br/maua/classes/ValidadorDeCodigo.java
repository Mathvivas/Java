package br.maua.classes;

import br.maua.enums.Produto;
import br.maua.enums.Regiao;

import java.util.*;

/**
 * Esta classe permite realizar a validação do código
 * de barras de acordo com as especificações impostas
 *
 * @author Matheus
 */
public class ValidadorDeCodigo {

    public static final String VENDEDOR_INVALIDO = "584";

    public void validar(List<String> codigoPacotes) {

        Set<String> codigosInvalidos = new HashSet<>();
        Set<String> codigosValidos = new HashSet<>();

        for (String codigoDeUmPacote : codigoPacotes) {

            String[] codigoSeparado = codigoDeUmPacote.split("(?<=\\G.{3})");

            Produto[] produtos;
            produtos = (Produto[]) Arrays.stream(Produto.values()).toArray();

            // Verificando o código do vendedor (código 584 é inválido)
            if (codigoSeparado[3].equals(VENDEDOR_INVALIDO)) {
                System.out.println("\nCódigo do Vendedor é Inválido!");
                codigosInvalidos.add(codigoDeUmPacote);
                break;
            }
            // Verificando se existe jóias vindo do Centro-Oeste
            else if (codigoSeparado[1].equals(Regiao.CENTROOESTE.getCodigo()) && codigoSeparado[0].equals(Produto.JOIAS.getCodigo())) {
                System.out.println("\nNão é possível despachar pacotes contendo jóias vindo do Centro-Oeste!");
                codigosInvalidos.add(codigoDeUmPacote);
                break;
            }

            // Checando se os Produtos possuem código diferente do permitido
            List<String> produtosValidos = new ArrayList<>();
            for (Produto prod : produtos) {
                produtosValidos.add(prod.getCodigo());
            }

            if (!produtosValidos.contains(codigoSeparado[4])) {
                System.out.println("\nProduto não permitido!");
                codigosInvalidos.add(codigoDeUmPacote);
                break;
            }

            // Caso o Código passe do Validador, ele é válido
            codigosValidos.add(codigoDeUmPacote);
            Sistema sistema = new Sistema();
            sistema.rodar(produtos, codigoSeparado, codigosValidos, codigosInvalidos);
        }
    }
}
