package trab02.doc;

import java.util.List;
import org.w3c.dom.Document;
import trab02.Escritor;
import trab02.PersistDAO;
import java.sql.Connection;
import java.sql.SQLException;
import org.w3c.dom.Element;

public class DocumentWriterEscritor {
    //  Document doc;

    Document doc = ManipuladorXML.newDocument();
    Connection con;

    public DocumentWriterEscritor(Connection con) {
        this.con = con;
    }

    /**
     * <Escritor>
     * <Id> ... </Id>
     * <Nome> ... </Nome>
     * <Sobrenome> ... </Sobrenome>
     * </Escritor>
     *
     */
    public void writeEscritor(Escritor escritor, Element master) {
        // PersistDAO dao = new  PersistDAO(con);

        //<Escritor>
        Element root = doc.createElement("Escritor");
        master.appendChild(root);

        // <Id>
        Element id = doc.createElement("Id");
        id.setTextContent(Integer.toString(escritor.getId()));
        root.appendChild(id);

        // <Nome>
        Element nome = doc.createElement("Nome");
        nome.setTextContent(escritor.getPrimeiroNome());
        root.appendChild(nome);
        
       // <Sobrenome>
       Element sobrenome = doc.createElement("Sobrenome");
       sobrenome.setTextContent(escritor.getSobreNome());
       root.appendChild(sobrenome);
       
        
    }

    public void writeEscritores() throws SQLException {
        PersistDAO dao = new PersistDAO(con);
        List<Escritor> listaEscritores = dao.listarEscritores();
        Escritor escritor ;
        Element master = doc.createElement("Escritores");
        doc.appendChild(master);
        for (int i =0; i < listaEscritores.size(); i++){
         escritor = listaEscritores.get(i);
         this.writeEscritor(escritor, master);
         
      }
       ManipuladorXML.writeXmlFile(doc, "./escritores.xml");
    }

}
