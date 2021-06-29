package br.maua.controller;

import br.maua.dao.ProdutoDAO;
import br.maua.factory.ConnectionFactory;
import br.maua.modelo.Produto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProdutoController {

    private ProdutoDAO produtoDAO;

    public ProdutoController() {
        Connection connection = null;
        try {
            connection = new ConnectionFactory().recuperarConexao();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        this.produtoDAO = new ProdutoDAO(connection);
    }

    public void deletar(Integer id) {
        this.produtoDAO.deletar(id);
    }

    public void salvar(Produto produto) {
        this.produtoDAO.salvar(produto);
    }

    public List<Produto> listar() {
        return this.produtoDAO.listar();
    }

    public void alterar(String nome, String descricao, Integer id) {
        this.produtoDAO.alterar(nome, descricao, id);
    }
}
