package br.maua.repositorio;

import br.maua.factory.ConnectionFactory;

import java.sql.*;

public class TestaListagem {
    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();

        PreparedStatement stm = connection.prepareStatement("SELECT id, nome, descricao FROM produto");
        stm.execute();

        ResultSet rst = stm.getResultSet();

        while ( rst.next() ) {
            Integer id = rst.getInt("id");
            System.out.println(id);
            String nome = rst.getString("nome");
            System.out.println(nome);
            String descricao = rst.getString("descricao");
            System.out.println(descricao);
        }

        System.out.println("\nFechando conexão.");
        connection.close();
    }
}
