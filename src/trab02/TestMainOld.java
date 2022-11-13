package trab02;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;
import trab02.doc.DocumentReader;
import trab02.doc.DocumentWriter;
import trab02.doc.ManipuladorXML;

public class TestMainOld {

    public static void main(String[] args) throws SQLException, XPathExpressionException {

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
        //dw.writeEscritores();
       // dw.writeLivros();
        DocumentReader dr = new DocumentReader();
       
        try {
           List<Escritor> listadeEscritores = dr.readEscritores("./escritores.xml");
            System.out.println(listadeEscritores.size());
           listadeEscritores.stream().forEach(le -> {
           System.out.println(le.getSobreNome() + ", " + le.getPrimeiroNome());
           });
        } catch (SAXException | ParserConfigurationException | IOException ex) {
            Logger.getLogger(TestMainOld.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       try {
           List<Livro> lista = dr.readLivros("./livros.xml");
           System.out.println("Teste ---- ");
           System.out.println(lista.size());
           lista.stream().forEach(le -> {
           System.out.println(le.getTitulo() + ", " + le.getPreco());
           });
        } catch (SAXException | ParserConfigurationException | IOException ex) {
            Logger.getLogger(TestMainOld.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      }
    }


