package trab02;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import trab02.doc.DocumentWriter;
import trab02.doc.ManipuladorXML;

public class TestMainOld {

    public static void main(String[] args) throws SQLException {

        // Escritor king = new Escritor("Stephen", "King");   
        Connection con = new ConnectionFactory().establishConnection();
        PersistDAO dao = new PersistDAO(con);
        // dao.saveEscritor(king);
        // Livro it = new Livro("Carrie", "Terror", "978-0-385-08695-0", 25.00, 1 );
        //dao.saveLivro(it);
       // List<Livro> listadeLivros = dao.listarLivros();
        //List<Escritor> listadeEscritores = dao.listarEscritores();
       //listadeLivros.stream().forEach(lp -> System.out.println(lp));
      /*  listadeEscritores.stream().forEach(le -> {
           System.out.println(le.getSobreNome() + ", " + le.getPrimeiroNome());
            try {
                for (Livro livro : new PersistDAO(con).buscarLivro(1)) {
                
                    System.out.println(dao.listarInfo());
                    System.out.println(le.getPrimeiroNome() + " " + le.getSobreNome() + " - " + livro.getTitulo());
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });*/
    //  List<Escritor> listadeEscritores = dao.listarInfo();
     // for (int i =0; i < listadeEscritores.size(); i++){
      //    System.out.println(listadeEscritores.get(i));
      
        DocumentWriter dw = new DocumentWriter(con);
        dw.writeEscritores();
              
      }
    }


