package trab02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;


public class ConnectionFactory {

   private final String DATABASE_URL = "jdbc:mysql://localhost:3306/bookstoredb";
    static final String USERNAME = "root";
    static final String PASSWORD = "root";
     public ConnectionFactory(){
      

     }
    public Connection establishConnection() throws SQLException  {
        return DriverManager.getConnection(DATABASE_URL,
                USERNAME, PASSWORD);
       
      
      
    }
}
