package br.maua.repositorio;

import br.maua.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.recuperarConexao();

        Statement stm = connection.createStatement();
        stm.execute("INSERT INTO produto (nome, descricao) VALUES ('Mouse', 'Mouse sem fio')",
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
