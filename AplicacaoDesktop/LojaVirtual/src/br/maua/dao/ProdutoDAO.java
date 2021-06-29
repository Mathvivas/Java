package br.maua.dao;

import br.maua.modelo.Categoria;
import br.maua.modelo.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private Connection connection;

    public ProdutoDAO(Connection connection) {
        this.connection = connection;
    }

    public void salvar(Produto produto) throws SQLException {
        String sql = "INSERT INTO produto (nome, descricao) VALUES (?, ?)";

        try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstm.setString(1, produto.getNome());
            pstm.setString(2, produto.getDescricao());
            pstm.execute();

            try (ResultSet rst = pstm.getGeneratedKeys()) {
                while ( rst.next() ) {
                    produto.setId(rst.getInt(1));
                }
            }
        }
    }

    public List<Produto> listar() throws SQLException {
        List<Produto> produtos = new ArrayList<>();

        String sql = "SELECT id, nome, descricao FROM produto";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.execute();

            try (ResultSet rst = pstm.getResultSet()) {
                while ( rst.next() ) {
                    Produto produto = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3));

                    produtos.add(produto);
                }
            }
        }
        return produtos;
    }

    public List<Produto> buscar(Categoria ct) throws SQLException {
        List<Produto> produtos = new ArrayList<>();

        System.out.println("Executando a Query de Buscar Produto por Categoria");

        String sql = "SELECT id, nome, descricao FROM produto WHERE categoria_id = ?";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, ct.getId());
            pstm.execute();

            try (ResultSet rst = pstm.getResultSet()) {
                while ( rst.next() ) {
                    Produto produto = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3));

                    produtos.add(produto);
                }
            }
        }
        return produtos;
    }

    public void salvarComCategoria(Produto produto) throws SQLException {
        String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO, CATEGORIA_ID) VALUES (?, ?, ?)";

        try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstm.setString(1, produto.getNome());
            pstm.setString(2, produto.getDescricao());
            pstm.setInt(3, produto.getCategoriaId());

            pstm.execute();

            try (ResultSet rst = pstm.getGeneratedKeys()) {
                while (rst.next()) {
                    produto.setId(rst.getInt(1));
                }
            }
        }
    }

    public void deletar(Integer id) throws SQLException {
        try (PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID = ?")) {
            stm.setInt(1, id);
            stm.execute();
        }
    }

    public void alterar(String nome, String descricao, Integer id) throws SQLException {
        try (PreparedStatement stm = connection
                .prepareStatement("UPDATE PRODUTO P SET P.NOME = ?, P.DESCRICAO = ? WHERE ID = ?")) {
            stm.setString(1, nome);
            stm.setString(2, descricao);
            stm.setInt(3, id);
            stm.execute();
        }
    }

    private void trasformarResultSetEmProduto(List<Produto> produtos, PreparedStatement pstm) throws SQLException {
        try (ResultSet rst = pstm.getResultSet()) {
            while (rst.next()) {
                Produto produto = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3));

                produtos.add(produto);
            }
        }
    }
}
