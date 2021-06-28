package br.maua.repositorio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

    public static void main(String[] args) throws SQLException {

        String nome = "";
        String descricao = "";

        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.recuperarConexao();

        String sql = "INSERT INTO produto (nome, descricao) VALUES ('" + nome + "', '" + descricao + "')";

        Statement stm = connection.createStatement();
        stm.execute(sql,
                Statement.RETURN_GENERATED_KEYS);

        /*
            Método execute devolve true quando seu resultado é um java.sql.ResultSet
            e false caso contrário (update, delete, insert)
         */


        ResultSet rst = stm.getGeneratedKeys();
        while ( rst.next() ) {
            int id = rst.getInt(1);
            System.out.println("\nO id criado foi: " + id);
        }
    }
}