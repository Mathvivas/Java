package br.maua.loja.dao;

import br.maua.loja.modelo.Cliente;
import br.maua.loja.modelo.Pedido;
import br.maua.loja.modelo.Produto;

import javax.persistence.EntityManager;

public class ClienteDAO {

    private EntityManager em;

    public ClienteDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Cliente cliente) {
        this.em.persist(cliente);
    }

    public Cliente buscarPorId(Long id) {
        return em.find(Cliente.class, id);
    }
}
