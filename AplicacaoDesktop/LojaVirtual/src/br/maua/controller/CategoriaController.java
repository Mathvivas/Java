package br.maua.controller;

import br.maua.dao.CategoriaDAO;
import br.maua.factory.ConnectionFactory;
import br.maua.modelo.Categoria;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CategoriaController {

    private CategoriaDAO categoriaDAO;

    public CategoriaController() {
        Connection connection = null;
        try {
            connection = new ConnectionFactory().recuperarConexao();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        this.categoriaDAO = new CategoriaDAO(connection);
    }

    public List<Categoria> listar() {
        return this.categoriaDAO.listar();
    }
}
