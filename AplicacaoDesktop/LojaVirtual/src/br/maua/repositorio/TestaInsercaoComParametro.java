package br.maua.repositorio;

import br.maua.factory.ConnectionFactory;

import java.sql.*;

public class TestaInsercaoComParametro {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory factory = new ConnectionFactory();
        try (Connection connection = factory.recuperarConexao()) {

            connection.setAutoCommit(false);

            try (
                    PreparedStatement stm = connection.prepareStatement(
                            "INSERT INTO produto (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)
            ) {
                adicionarVariavel("SmartTV", "45 polegadas", stm);
                adicionarVariavel("Rádio", "Rádio de bateria", stm);

                // Será inserido somente se os dois produtos forem criados
                connection.commit();

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("ROLLBACK EXECUTADO.");
                connection.rollback();
            }
        }
    }

    private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
        stm.setString(1, nome);
        stm.setString(2, descricao);
        stm.execute();

        try (ResultSet rst = stm.getGeneratedKeys()) {
            while (rst.next()) {
                int id = rst.getInt(1);
                System.out.println("\nO id criado foi: " + id);
            }
        }
    }
}