package br.maua.loja.dao;

import br.maua.loja.modelo.Produto;

import javax.persistence.EntityManager;

public class ProdutoDAO {

    private EntityManager em;

    public ProdutoDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto produto) {
        this.em.persist(produto);
    }
}
