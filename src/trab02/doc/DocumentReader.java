package trab02.doc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import trab02.Escritor;
import trab02.Livro;

public class DocumentReader {

    public List<Escritor> readEscritores(String path) throws XPathExpressionException, SAXException, ParserConfigurationException, IOException {
        File file = new File(path);
        List<Escritor> escritores = new ArrayList<>();
       
        DocumentBuilderFactory dbf
                = DocumentBuilderFactory.newInstance();

        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);

        doc.getDocumentElement().normalize();
        doc.getDocumentElement().getNodeName();
        NodeList nodeList
                = doc.getElementsByTagName("Escritor");

        for (int i = 0; i < nodeList.getLength(); ++i) {
             Escritor escritor = new Escritor();
            Node node = nodeList.item(i);
            node.getNodeName();
            if (node.getNodeType()
                    == Node.ELEMENT_NODE) {
                Element tElement = (Element) node;
                String idString
                        = tElement
                                .getElementsByTagName("Id")
                                .item(0)
                                .getTextContent();
                String nome = tElement
                        .getElementsByTagName(
                                "Nome")
                        .item(0)
                        .getTextContent();
                String sobrenome = tElement
                        .getElementsByTagName(
                                "Sobrenome")
                        .item(0)
                        .getTextContent();
                int id = Integer.parseInt(idString);
                escritor.setId(id);
                escritor.setPrimeiroNome(nome);
                escritor.setSobreNome(sobrenome);
               escritores.add(escritor);
            }
        }
        return escritores;
    }
    /*
        public List<Livro> readLivros(String path) throws XPathExpressionException, SAXException, ParserConfigurationException, IOException {
        File file = new File(path);
        List<Livro> livros = new ArrayList<>();
       
        DocumentBuilderFactory dbf
                = DocumentBuilderFactory.newInstance();

        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);

        doc.getDocumentElement().normalize();
        doc.getDocumentElement().getNodeName();
        NodeList nodeList
                = doc.getElementsByTagName("Escritor");

        for (int i = 0; i < nodeList.getLength(); ++i) {
             Livro livro = new Livro();
            Node node = nodeList.item(i);
            node.getNodeName();
            if (node.getNodeType()
                    == Node.ELEMENT_NODE) {
                Element tElement = (Element) node;
                String idString
                        = tElement
                                .getElementsByTagName("Id")
                                .item(0)
                                .getTextContent();
                String nome = tElement
                        .getElementsByTagName(
                                "Nome")
                        .item(0)
                        .getTextContent();
                String sobrenome = tElement
                        .getElementsByTagName(
                                "Sobrenome")
                        .item(0)
                        .getTextContent();
                int id = Integer.parseInt(idString);
                escritor.setId(id);
                escritor.setPrimeiroNome(nome);
                escritor.setSobreNome(sobrenome);
               escritores.add(escritor);
            }
        }
        return escritores;
    } */
    
}
