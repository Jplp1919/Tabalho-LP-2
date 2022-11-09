
package trab02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class preparedDelete {


    public static void main(String[] args) throws SQLException {
        deleteLivro();
    
}

    private static void deleteLivro() throws SQLException {
        ConnectionFactory cf = new ConnectionFactory();
        Connection connection = cf.establishConnection();
        PreparedStatement stm = connection.prepareStatement("DELETE FROM LIVRO WHERE ID > ?");
        
        stm.setInt(1, 2);
        stm.execute();
        
        Integer listaModificadas = stm.getUpdateCount();
        System.out.println("Quantidade de linhas modificadas: " +listaModificadas);
    }
}
