package br.maua.loja.testes;

import br.maua.loja.dao.ProdutoDAO;
import br.maua.loja.modelo.Produto;
import br.maua.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroDeProduto {

    public static void main(String[] args) {

        Produto celular = new Produto();

        celular.setNome("Xiaomi Redmi");
        celular.setDescricao("Muito legal");
        celular.setPreco(new BigDecimal("800"));

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(em);

        em.getTransaction().begin();
        // Inserir no Banco de Dados
        produtoDAO.cadastrar(celular);
        em.getTransaction().commit();
        em.close();
    }
}
