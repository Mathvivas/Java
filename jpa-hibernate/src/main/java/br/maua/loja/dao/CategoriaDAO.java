package br.maua.loja.dao;

import br.maua.loja.modelo.Categoria;
import br.maua.loja.modelo.Produto;

import javax.persistence.EntityManager;

public class CategoriaDAO {

    private EntityManager em;

    public CategoriaDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Categoria categoria) {
        this.em.persist(categoria);
    }

    public void atualizar(Categoria categoria) {
        this.em.merge(categoria);       // Força a categoria a estar no modo Managed
    }

    public void remover(Categoria categoria) {
        categoria = em.merge(categoria);    // Manda para o modo Managed
        this.em.remove(categoria);      // Precisa estar no modo Managed
    }
}
