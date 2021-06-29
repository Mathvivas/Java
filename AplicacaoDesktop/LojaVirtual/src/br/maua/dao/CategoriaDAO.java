package br.maua.dao;

import br.maua.modelo.Categoria;
import br.maua.modelo.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    private Connection connection;

    public CategoriaDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Categoria> listar() {
        try {
            List<Categoria> categorias = new ArrayList<>();
            String sql = "SELECT id, nome FROM categoria";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.execute();

                try (ResultSet rst = pstm.getResultSet()) {
                    while ( rst.next() ) {
                        Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));

                        categorias.add(categoria);
                    }
                }
            }
            return categorias;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Categoria> listarComProdutos() {
        try {
            Categoria ultima = null;
            List<Categoria> categorias = new ArrayList<>();

            System.out.println("Executando a Query de Listar Categoria");

            String sql = "SELECT C.id, C.nome, P.id, P.nome, P.descricao FROM categoria C INNER JOIN " +
                    "produto P ON C.id = P.categoria_id";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.execute();

                try (ResultSet rst = pstm.getResultSet()) {
                    while ( rst.next() ) {
                        if ( ultima == null || !ultima.getNome().equals(rst.getString(2)) ) {
                            Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));
                            ultima = categoria;
                            categorias.add(categoria);
                        }
                        Produto produto = new Produto(rst.getInt(3), rst.getString(4), rst.getString(5));
                        ultima.adicionar(produto);
                    }
                }
            }
            return categorias;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
