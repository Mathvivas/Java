package br.maua.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.recuperarConexao();

        PreparedStatement stm = connection.prepareStatement("DELETE FROM produto WHERE id = ?");
        stm.setInt(1, 3);
        stm.execute();

        int linhasModificadas = stm.getUpdateCount();
        System.out.println("Quantidade de linhas modificadas: " + linhasModificadas);
    }
}
