package trab02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class preparedInsert {

    private static void addVAR(PreparedStatement stm, String nome, String descricao) throws SQLException {
        stm.setString(1, nome);
        stm.setString(2, descricao);

        if (nome.equalsIgnoreCase("Radio")) {
            throw new RuntimeException("This ain't Radio Shack");
        }

        stm.execute();

        ResultSet rset = stm.getGeneratedKeys();
        while (rset.next()) {
            Integer id = rset.getInt(1);
            System.out.println(id);
        }
        rset.close();
    }

    public static void main(String[] args) throws SQLException {

        ConnectionFactory cf = new ConnectionFactory();
        try ( Connection connection = cf.establishConnection()) {
            connection.setAutoCommit(false);

            try ( PreparedStatement stm = connection.prepareStatement("INSERT INTO produto (Nome, Descricao) VALUES(?, ?)",
                    Statement.RETURN_GENERATED_KEYS)) {

                addVAR(stm, "Air Fryier", "Fritadeira de ar quente");
                addVAR(stm, "Micro-Ondas", "Forno de micro-ondas");
                connection.commit();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("ROLL BACK");
                connection.rollback();
            }
        }
    }

}
