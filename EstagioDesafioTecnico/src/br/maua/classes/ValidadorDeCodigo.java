package br.maua.classes;

import br.maua.enums.Produto;
import br.maua.enums.Regiao;

import java.util.*;

/**
 * Esta classe permite realizar a validação do código
 * de barras de acordo com as especificações impostas.
 *
 * @author Matheus
 */
public class ValidadorDeCodigo {

    public static final String VENDEDOR_INVALIDO = "584";
    PadraoDeImpressao padraoDeImpressao = new PadraoDeImpressao();
    Map<String, Integer> vendedores = new HashMap<>();
    Sistema sistema = new Sistema();

    public void validar(List<String> codigoPacotes) {

        for (String codigoDeUmPacote : codigoPacotes) {

            String[] codigoSeparado = codigoDeUmPacote.split("(?<=\\G.{3})");

            Produto[] produtos;
            produtos = Arrays.stream(Produto.values()).toArray(Produto[]::new);

            // Verificando o código do vendedor (código 584 é inválido)
            if (codigoSeparado[3].equals(VENDEDOR_INVALIDO)) {
                System.out.println("\nCódigo do Vendedor é Inválido! Código " + codigoDeUmPacote + " Inválido");
                break;
            }
            // Verificando se existem jóias vindo do Centro-Oeste
            else if (codigoSeparado[1].equals(Regiao.CENTROOESTE.getCodigo()) && codigoSeparado[0].equals(Produto.JOIAS.getCodigo())) {
                System.out.println("\nNão é possível despachar pacotes contendo jóias vindo do Centro-Oeste! " +
                        "Código " + codigoDeUmPacote + " Inválido");
                break;
            }

            // Checando se os Produtos possuem código diferente do permitido
            List<String> produtosValidos = new ArrayList<>();
            for (Produto prod : produtos) {
                produtosValidos.add(prod.getCodigo());
            }

            if (!produtosValidos.contains(codigoSeparado[4])) {
                System.out.println("\nProduto não permitido! Código " + codigoDeUmPacote + " Inválido");
                break;
            }

            identificarSulBrinquedo(codigoDeUmPacote, codigoSeparado);

            padraoDeImpressao.adicionarNumeroDeCodigosPorVendedor(codigoSeparado, vendedores);
            padraoDeImpressao.listarNumeroDeCodigosPorVendedor(vendedores);

            sistema.rodar(produtos, codigoSeparado);
        }
    }

    public void identificarSulBrinquedo(String codigoDeUmPacote, String[] codigoSeparado) {
        /*
             Identificar se algum pacote que tem como origem a região Sul tem
             Brinquedos em seu conteúdo
         */
        if ( codigoSeparado[0].equals("000") && codigoSeparado[4].equals("888") ) {
            System.out.println("\nCódigo " + codigoDeUmPacote + " está enviando brinquedos do Sul.");
        }
    }
}
