package trab02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersistDAO {

    private Connection con;

    public PersistDAO(Connection con) {
        this.con = con;

    }

    public void saveEscritor(Escritor escritor) throws SQLException {

        String sql = "INSERT INTO ESCRITOR (PRIMEIRONOME, SOBRENOME) VALUES (?, ?)";

        try (PreparedStatement pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstm.setString(1, escritor.getPrimeiroNome());
            pstm.setString(2, escritor.getSobreNome());
            pstm.execute();

            try (ResultSet rst = pstm.getGeneratedKeys()) {
                while (rst.next()) {
                    escritor.setId(rst.getInt(1));
                }
            }
        }
    }

    public void saveLivro(Livro livro) throws SQLException {

        String sql = "INSERT INTO LIVROS (TITULO, GENERO, ISBN, PRECO, IDESCRITOR) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstm.setString(1, livro.getTitulo());
            pstm.setString(2, livro.getGenero());
            pstm.setString(3, livro.getIsbn());
            pstm.setDouble(4, livro.getPreco());
            pstm.setInt(5, livro.getIdEscritor());
            pstm.execute();

            try (ResultSet rst = pstm.getGeneratedKeys()) {
                while (rst.next()) {
                    livro.setId(rst.getInt(1));
                }
            }
        }
    }

   public void deleteLivro(int id) throws SQLException {

        String sql = "DELETE FROM LIVROS WHERE IDLIVROS = ?";
        try (PreparedStatement pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstm.setInt(1, id);
            pstm.execute();

            Integer listaModificadas = pstm.getUpdateCount();
            System.out.println("Quantidade de linhas modificadas: " + listaModificadas);
        }
    }

    public void deleteEscritor(int id) throws SQLException {

        String sql = "DELETE FROM Escritor WHERE IDESCRITOR = ?";
        try (PreparedStatement pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstm.setInt(1, id);
            pstm.execute();

            Integer listaModificadas = pstm.getUpdateCount();
            System.out.println("Quantidade de linhas modificadas: " + listaModificadas);
        }
    }

    public List<Livro> listarLivros() throws SQLException {
        List<Livro> livros = new ArrayList<Livro>();

        String sql = "SELECT IDLIVROS, TITULO, GENERO, ISBN, PRECO, IDESCRITOR FROM LIVROS";

        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.execute();

            try (ResultSet rs = pstm.getResultSet()) {
                while (rs.next()) {
                    Livro livro
                            = new Livro(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6));

                    livros.add(livro);
                }
                return livros;
            }
        }
    }

    public List<Escritor> listarEscritores() throws SQLException {
        List<Escritor> escritores = new ArrayList<>();

        String sql = "SELECT * FROM ESCRITOR";

        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.execute();
            try (ResultSet rs = pstm.getResultSet()) {
                while (rs.next()) {
                    Escritor escritor = new Escritor(rs.getInt(1), rs.getString(2), rs.getString(3));
                    escritores.add(escritor);
                }
            }

        }
        return escritores;
    }

    public List<Livro> buscarLivro(int i) throws SQLException {
        List<Livro> livros = new ArrayList<Livro>();

        String sql = "SELECT IDLIVROS, TITULO, GENERO, ISBN, PRECO, IDESCRITOR FROM LIVROS WHERE IDESCRITOR = ?";

        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, i);
            pstm.execute();

            try (ResultSet rs = pstm.getResultSet()) {
                while (rs.next()) {
                    Livro livro
                            = new Livro(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6));

                    livros.add(livro);
                }
                return livros;
            }
        }
    }

    public ResultSet getResults() throws SQLException {
        List<Livro> livros = new ArrayList<Livro>();
        ResultSet rs;
        String sql = "SELECT IDLIVROS, TITULO, GENERO, ISBN, PRECO, IDESCRITOR FROM LIVROS";

        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.execute();
            rs = pstm.getResultSet();
        }
        return rs;
    }

    public void updateLivro(String col, String data, String id) throws SQLException {
        String sql = "";
        String titulo = "titulo";
        String genero = "genero";
        String preco = "preco";
        String isbn = "isbn";

        if (col.equalsIgnoreCase(titulo)) {
            sql = "UPDATE LIVROS SET TITULO = ? WHERE IDLIVROS = ?";
        } else if (col.equalsIgnoreCase(genero)) {
            sql = "UPDATE LIVROS SET GENERO = ? WHERE IDLIVROS = ?";
        } else if (col.equalsIgnoreCase(preco)) {
            sql = "UPDATE LIVROS SET PRECO = ? WHERE IDLIVROS = ?";
        } else if (col.equalsIgnoreCase(isbn)) {
            sql = "UPDATE LIVROS SET ISBN = ? WHERE IDLIVROS = ?";
        } 

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            // ps.setString(1, col);

            ps.setString(1, data);
            ps.setString(2, id);
            ps.execute();

        }
    }
    
    
        public void updateEscritor(String col, String data, String id) throws SQLException {
        String sql = "";
        String nome = "nome";
        String sobrenome = "sobrenome";


        if (col.equalsIgnoreCase(nome)) {
            sql = "UPDATE ESCRITOR SET PRIMEIRONOME = ? WHERE IDESCRITOR = ?";
        } else if (col.equalsIgnoreCase(sobrenome)) {
            sql = "UPDATE ESCRITOR SET SOBRENOME = ? WHERE IDESCRITOR = ?";
        }                           

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            System.out.println(data);
            ps.setString(1, data);
            ps.setString(2, id);
            ps.execute();

        }
    }

}
