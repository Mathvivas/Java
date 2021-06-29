package br.maua.repositorio;

import br.maua.dao.CategoriaDAO;
import br.maua.modelo.Categoria;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestaListagemDeCategoria {

    public static void main(String[] args) throws SQLException {

        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
            List<Categoria> categorias = categoriaDAO.listar();
            categorias.stream().forEach(ct -> System.out.println(ct.getNome()));

        }

    }
}
