package br.maua.loja.testes;

import br.maua.loja.dao.CategoriaDAO;
import br.maua.loja.dao.ProdutoDAO;
import br.maua.loja.modelo.Categoria;
import br.maua.loja.modelo.Produto;
import br.maua.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDeProduto {

    public static void main(String[] args) {

        cadastrarProduto();

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(em);

        Produto p = produtoDAO.buscarPorId(1L);
        System.out.println(p.getPreco());

        List<Produto> todos = produtoDAO.buscarTodos();
        todos.forEach(prod -> System.out.println(prod.getNome()));
    }

    private static void cadastrarProduto() {
        Produto celular = new Produto();

        celular.setNome("Xiaomi Redmi");
        celular.setDescricao("Muito legal");
        celular.setPreco(new BigDecimal("800"));

        Categoria celulares = new Categoria("CELULARES");

        celular.setCategoria(celulares);

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        CategoriaDAO categoriaDAO = new CategoriaDAO(em);

        em.getTransaction().begin();
        // Inserir no Banco de Dados
        categoriaDAO.cadastrar(celulares);  // Salvar primeiro a categoria
        produtoDAO.cadastrar(celular);
        em.getTransaction().commit();
        em.close();
    }
}
