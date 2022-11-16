package trab02;

import java.util.logging.Level;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;
import trab02.doc.DocumentReader;
import trab02.doc.DocumentWriter;
import java.util.logging.Logger;
import java.util.logging.FileHandler;

public class BookFrame extends javax.swing.JFrame {

    static Logger logger = Logger.getLogger(BookFrame.class.getName());
    static FileHandler fh;

    public void addBookRows(Connection con) throws SQLException {
        DefaultTableModel dtm = (DefaultTableModel) bookTable.getModel();
        PersistDAO dao = new PersistDAO(con);

        Object[] rowData = new Object[6];

        ResultSet rs;
        String sql = "SELECT IDLIVROS, TITULO, GENERO, ISBN, PRECO, IDESCRITOR FROM LIVROS";

        try ( PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.execute();
            rs = pstm.getResultSet();

            while (rs.next()) {
                rowData[0] = rs.getInt(1);
                rowData[1] = rs.getString(2);
                rowData[2] = rs.getString(3);
                rowData[3] = rs.getString(4);
                rowData[4] = rs.getDouble(5);
                rowData[5] = rs.getInt(6);
                dtm.addRow(rowData);
            }

        }

    }

    public void addEscritorRows(Connection con) throws SQLException {
        DefaultTableModel dtm = (DefaultTableModel) escritorTable.getModel();
        PersistDAO dao = new PersistDAO(con);

        Object[] rowData = new Object[3];
        ResultSet rs;
        String sql = "SELECT * FROM ESCRITOR";

        try ( PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.execute();
            rs = pstm.getResultSet();

            while (rs.next()) {
                rowData[0] = rs.getInt(1);
                rowData[1] = rs.getString(2);
                rowData[2] = rs.getString(3);
                dtm.addRow(rowData);
            }

        }
    }

    public void clearBooks() {

    }

    public BookFrame() throws SQLException, IOException {
        initComponents();

        Connection con = new ConnectionFactory().establishConnection();
        addBookRows(con);
        addEscritorRows(con);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        escritorTable = new javax.swing.JTable();
        jButtonUpdateEscritor = new javax.swing.JButton();
        jTextFieldNomeAuthor = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextFieldSobrenomeAuthor = new javax.swing.JTextField();
        jButtonInserirEscritor = new javax.swing.JButton();
        jTextFieldIdEscritor = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jButtonDeleteEscritor = new javax.swing.JButton();
        xmlButtonLoadWriter = new javax.swing.JButton();
        xmlButtonExportWriter = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookTable = new javax.swing.JTable();
        jTextFieldIdBook = new javax.swing.JTextField();
        customButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldTituloBook = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldGeneroBook = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldIsbnBook = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldPrecoBook = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldIdEscritorBook = new javax.swing.JTextField();
        jButtonInsertBook = new javax.swing.JButton();
        jButtonDeleteBook = new javax.swing.JButton();
        xmlButtonBookLoad = new javax.swing.JButton();
        xmlButtonExportBook = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Sobrenome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        escritorTable.setFocusable(false);
        escritorTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                escritorTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(escritorTable);

        jButtonUpdateEscritor.setText("Atualizar");
        jButtonUpdateEscritor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateEscritorActionPerformed(evt);
            }
        });

        jTextFieldNomeAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeAuthorActionPerformed(evt);
            }
        });

        jLabel19.setText("Nome");

        jLabel20.setText("Sobrenome");

        jTextFieldSobrenomeAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSobrenomeAuthorActionPerformed(evt);
            }
        });

        jButtonInserirEscritor.setText("Inserir");
        jButtonInserirEscritor.setToolTipText("");
        jButtonInserirEscritor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInserirEscritorActionPerformed(evt);
            }
        });

        jTextFieldIdEscritor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdEscritorActionPerformed(evt);
            }
        });

        jLabel22.setText("ID");

        jButtonDeleteEscritor.setText("Deletar");
        jButtonDeleteEscritor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteEscritorActionPerformed(evt);
            }
        });

        xmlButtonLoadWriter.setForeground(new java.awt.Color(0, 204, 51));
        xmlButtonLoadWriter.setText("Carregar Xml");
        xmlButtonLoadWriter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xmlButtonLoadWriterActionPerformed(evt);
            }
        });

        xmlButtonExportWriter.setForeground(new java.awt.Color(255, 51, 51));
        xmlButtonExportWriter.setText("Exportar Xml");
        xmlButtonExportWriter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xmlButtonExportWriterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel22)
                                    .addGap(46, 46, 46)
                                    .addComponent(jLabel19)
                                    .addGap(91, 91, 91)
                                    .addComponent(jLabel20)
                                    .addGap(0, 109, Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jTextFieldIdEscritor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextFieldNomeAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextFieldSobrenomeAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButtonUpdateEscritor)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonInserirEscritor)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonDeleteEscritor))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(xmlButtonLoadWriter)))
                .addContainerGap(112, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(xmlButtonExportWriter)
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(xmlButtonLoadWriter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldSobrenomeAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNomeAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldIdEscritor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonInserirEscritor)
                    .addComponent(jButtonDeleteEscritor)
                    .addComponent(jButtonUpdateEscritor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(xmlButtonExportWriter, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jTabbedPane2.addTab("Escritores", jPanel2);

        bookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Titulo", "Genero", "ISBN", "Valor", "ID Escritor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bookTable.setFocusable(false);
        bookTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bookTableFocusGained(evt);
            }
        });
        bookTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bookTable);
        if (bookTable.getColumnModel().getColumnCount() > 0) {
            bookTable.getColumnModel().getColumn(0).setResizable(false);
            bookTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            bookTable.getColumnModel().getColumn(1).setResizable(false);
            bookTable.getColumnModel().getColumn(2).setResizable(false);
            bookTable.getColumnModel().getColumn(3).setResizable(false);
            bookTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            bookTable.getColumnModel().getColumn(4).setResizable(false);
        }

        jTextFieldIdBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdBookActionPerformed(evt);
            }
        });

        customButton.setText("Atualizar");
        customButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("ID");

        jTextFieldTituloBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTituloBookActionPerformed(evt);
            }
        });

        jLabel6.setText("Titulo");

        jTextFieldGeneroBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldGeneroBookActionPerformed(evt);
            }
        });

        jLabel7.setText("Genero");

        jLabel8.setText("Isbn");

        jLabel9.setText("Preco");

        jLabel10.setText("ID Escritor");

        jTextFieldIdEscritorBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdEscritorBookActionPerformed(evt);
            }
        });

        jButtonInsertBook.setText("Inserir");
        jButtonInsertBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertBookActionPerformed(evt);
            }
        });

        jButtonDeleteBook.setText("Deletar");
        jButtonDeleteBook.setToolTipText("");
        jButtonDeleteBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteBookActionPerformed(evt);
            }
        });

        xmlButtonBookLoad.setForeground(new java.awt.Color(0, 153, 51));
        xmlButtonBookLoad.setText("Carregar Xml");
        xmlButtonBookLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xmlButtonBookLoadActionPerformed(evt);
            }
        });

        xmlButtonExportBook.setForeground(new java.awt.Color(255, 0, 0));
        xmlButtonExportBook.setText("Exportar Xml");
        xmlButtonExportBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xmlButtonExportBookActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(xmlButtonBookLoad))
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldTituloBook, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldIsbnBook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jTextFieldPrecoBook, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldGeneroBook, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(81, 250, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(customButton)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(79, 79, 79)
                                        .addComponent(jLabel7)
                                        .addGap(54, 54, 54)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldIdEscritorBook, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10))
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonInsertBook)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonDeleteBook)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(xmlButtonExportBook, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldIdBook, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(xmlButtonBookLoad)
                .addGap(13, 13, 13)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldIdBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel6)
                .addGap(10, 10, 10)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTituloBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPrecoBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldIsbnBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldGeneroBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldIdEscritorBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(customButton)
                            .addComponent(jButtonInsertBook)
                            .addComponent(jButtonDeleteBook)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(xmlButtonExportBook, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jTabbedPane2.addTab("Livros", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldIdBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdBookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdBookActionPerformed

    private void customButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customButtonActionPerformed

        String id = jTextFieldIdBook.getText();
        String titulo = jTextFieldTituloBook.getText();
        String genero = jTextFieldGeneroBook.getText();
        String isbn = jTextFieldIsbnBook.getText();
        String preco = jTextFieldPrecoBook.getText();
        String StrIdEscritor = jTextFieldIdEscritorBook.getText();
        try {
            Connection con = new ConnectionFactory().establishConnection();
            PersistDAO dao = new PersistDAO(con);
            dao.updateLivro(id, titulo, genero, isbn, preco, StrIdEscritor);
            DefaultTableModel dtm = (DefaultTableModel) bookTable.getModel();
            dtm.setRowCount(0);
            this.addBookRows(con);
            logger.info("Livro Atualizado");
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

        jTextFieldIdBook.setText("");
        jTextFieldTituloBook.setText("");
        jTextFieldGeneroBook.setText("");
        jTextFieldIsbnBook.setText("");
        jTextFieldPrecoBook.setText("");
        jTextFieldIdEscritorBook.setText("");
    }//GEN-LAST:event_customButtonActionPerformed

    private void jTextFieldTituloBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTituloBookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTituloBookActionPerformed

    private void jTextFieldGeneroBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldGeneroBookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGeneroBookActionPerformed

    private void jTextFieldIdEscritorBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdEscritorBookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdEscritorBookActionPerformed

    private void jButtonInsertBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertBookActionPerformed

        String titulo = jTextFieldTituloBook.getText();
        String genero = jTextFieldGeneroBook.getText();
        String isbn = jTextFieldIsbnBook.getText();
        String StrPreco = jTextFieldPrecoBook.getText();
        Double preco = Double.valueOf(StrPreco);
        String StrIdEscritor = jTextFieldIdEscritorBook.getText();
        int idEscritor = Integer.parseInt(StrIdEscritor);
        Livro livro = new Livro(titulo, genero, isbn, preco, idEscritor);

        try {
            Connection con = new ConnectionFactory().establishConnection();
            PersistDAO dao = new PersistDAO(con);
            dao.saveLivro(livro);
            DefaultTableModel dtm = (DefaultTableModel) bookTable.getModel();
            dtm.setRowCount(0);
            this.addBookRows(con);
            logger.info("Livro Adicionado");

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
        jTextFieldIdBook.setText("");
        jTextFieldTituloBook.setText("");
        jTextFieldGeneroBook.setText("");
        jTextFieldIsbnBook.setText("");
        jTextFieldPrecoBook.setText("");
        jTextFieldIdEscritorBook.setText("");

    }//GEN-LAST:event_jButtonInsertBookActionPerformed

    private void jButtonDeleteBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteBookActionPerformed

        String StrId = jTextFieldIdBook.getText();
        int id = Integer.parseInt(StrId);
        try {
            Connection con = new ConnectionFactory().establishConnection();
            PersistDAO dao = new PersistDAO(con);
            dao.deleteLivro(id);
            DefaultTableModel dtm = (DefaultTableModel) bookTable.getModel();
            dtm.setRowCount(0);
            this.addBookRows(con);
            logger.info("Livro Deletado");
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

        jTextFieldIdBook.setText("");
        jTextFieldTituloBook.setText("");
        jTextFieldGeneroBook.setText("");
        jTextFieldIsbnBook.setText("");
        jTextFieldPrecoBook.setText("");
        jTextFieldIdEscritorBook.setText("");
    }//GEN-LAST:event_jButtonDeleteBookActionPerformed

    private void jTextFieldNomeAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeAuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeAuthorActionPerformed

    private void jTextFieldSobrenomeAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSobrenomeAuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSobrenomeAuthorActionPerformed

    private void jTextFieldIdEscritorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdEscritorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdEscritorActionPerformed

    private void jButtonDeleteEscritorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteEscritorActionPerformed
        String Strid = jTextFieldIdEscritor.getText();
        int id = Integer.parseInt(Strid);

        try {
            Connection con = new ConnectionFactory().establishConnection();
            PersistDAO dao = new PersistDAO(con);
            dao.deleteEscritor(id);
            DefaultTableModel dtm = (DefaultTableModel) escritorTable.getModel();
            dtm.setRowCount(0);
            this.addEscritorRows(con);
            logger.info("Escritor Deletado");
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
        jTextFieldIdEscritor.setText("");
        jTextFieldNomeAuthor.setText("");
        jTextFieldSobrenomeAuthor.setText("");
    }//GEN-LAST:event_jButtonDeleteEscritorActionPerformed

    private void jButtonInserirEscritorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInserirEscritorActionPerformed
        String StrId = jTextFieldIdEscritor.getText();
        int id = Integer.parseInt(StrId);
        String nome = jTextFieldNomeAuthor.getText();
        String sobrenome = jTextFieldSobrenomeAuthor.getText();
        Escritor escritor = new Escritor(id, nome, sobrenome);
        try {
            Connection con = new ConnectionFactory().establishConnection();
            PersistDAO dao = new PersistDAO(con);
            dao.saveEscritor(escritor);
            DefaultTableModel dtm = (DefaultTableModel) escritorTable.getModel();
            dtm.setRowCount(0);
            this.addEscritorRows(con);
            logger.info("Escritor Adicionado");
        } catch (SQLException ex) {

            logger.log(Level.SEVERE, null, ex);
        }

        jTextFieldIdEscritor.setText("");
        jTextFieldNomeAuthor.setText("");
        jTextFieldSobrenomeAuthor.setText("");

    }//GEN-LAST:event_jButtonInserirEscritorActionPerformed

    private void jButtonUpdateEscritorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateEscritorActionPerformed

        String id = jTextFieldIdEscritor.getText();
        String nome = jTextFieldNomeAuthor.getText();
        String sobrenome = jTextFieldSobrenomeAuthor.getText();

        try {
            Connection con = new ConnectionFactory().establishConnection();
            PersistDAO dao = new PersistDAO(con);
            dao.updateEscritor(id, nome, sobrenome);
            DefaultTableModel dtm = (DefaultTableModel) escritorTable.getModel();
            dtm.setRowCount(0);
            this.addEscritorRows(con);
            logger.info("Escritor Atualizado");
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

        jTextFieldIdEscritor.setText("");
        jTextFieldNomeAuthor.setText("");
        jTextFieldSobrenomeAuthor.setText("");


    }//GEN-LAST:event_jButtonUpdateEscritorActionPerformed

    private void xmlButtonBookLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xmlButtonBookLoadActionPerformed

        // String path = xmlLocationTextFieldBook.getText();
        DocumentReader dr = new DocumentReader();
        String path = "./livros.xml";
        //  if (path == null || path == "") {
        //  path = "./livros.xml";
        // }

        try {

            Connection con = new ConnectionFactory().establishConnection();
            PersistDAO dao = new PersistDAO(con);
            List<Livro> livros = dr.readLivros(path);

            dao.cleanTableBook();
            for (int i = 0; i < livros.size(); i++) {
                dao.saveLivro(livros.get(i));
            }
            // dao.saveLivro(livros.get());

            DefaultTableModel dtm = (DefaultTableModel) bookTable.getModel();
            dtm.setRowCount(0);
            this.addBookRows(con);
            logger.info("Xml de Livro Carregado");
        } catch (XPathExpressionException | SAXException | ParserConfigurationException | IOException ex) {
            logger.log(Level.WARNING, null, ex);
        } catch (SQLException ex) {
            // new Message("Escritores nao cadastrados");
            logger.log(Level.WARNING, "Escritor nao cadastrado");

        }

    }//GEN-LAST:event_xmlButtonBookLoadActionPerformed

    private void xmlButtonLoadWriterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xmlButtonLoadWriterActionPerformed

        DocumentReader dr = new DocumentReader();
        String path = "./escritores.xml";

        try {
            Connection con = new ConnectionFactory().establishConnection();
            PersistDAO dao = new PersistDAO(con);
            List<Escritor> escritores = dr.readEscritores(path);

            for (int i = 0; i < escritores.size(); i++) {
                dao.saveEscritor(escritores.get(i));
            }

            DefaultTableModel dtm = (DefaultTableModel) escritorTable.getModel();
            dtm.setRowCount(0);
            this.addEscritorRows(con);
            logger.info("Xml de Escritores Carregado com Sucesso");
        } catch (XPathExpressionException | SAXException | ParserConfigurationException | IOException ex) {
            Logger.getLogger(BookFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            logger.log(Level.WARNING, "Escritor(es) ja cadastrado(s)");
            // new Message("Escritores ja cadastrados");

        }


    }//GEN-LAST:event_xmlButtonLoadWriterActionPerformed

    private void xmlButtonExportWriterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xmlButtonExportWriterActionPerformed

        try {
            Connection con = new ConnectionFactory().establishConnection();
            DocumentWriter dw = new DocumentWriter(con);
            dw.writeEscritores();
            logger.info("Xml de Escritores Exportado com Sucesso");
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_xmlButtonExportWriterActionPerformed

    private void xmlButtonExportBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xmlButtonExportBookActionPerformed

        try {
            Connection con = new ConnectionFactory().establishConnection();
            DocumentWriter dw = new DocumentWriter(con);
            dw.writeLivros();
            logger.info("Xml de Livro Exportado");
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_xmlButtonExportBookActionPerformed

    private void bookTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bookTableFocusGained


    }//GEN-LAST:event_bookTableFocusGained

    private void bookTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookTableMouseClicked

        int index = bookTable.getSelectedRow();

        Object id = bookTable.getValueAt(index, 0);
        Object titulo = bookTable.getValueAt(index, 1);
        Object genero = bookTable.getValueAt(index, 2);
        Object isbn = bookTable.getValueAt(index, 3);
        Object valor = bookTable.getValueAt(index, 4);
        Object idescritor = bookTable.getValueAt(index, 5);

        jTextFieldIdBook.setText(id.toString());
        jTextFieldTituloBook.setText(titulo.toString());
        jTextFieldGeneroBook.setText(genero.toString());
        jTextFieldIsbnBook.setText(isbn.toString());
        jTextFieldPrecoBook.setText(valor.toString());
        jTextFieldIdEscritorBook.setText(idescritor.toString());
    }//GEN-LAST:event_bookTableMouseClicked

    private void escritorTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_escritorTableMouseClicked
        int index = escritorTable.getSelectedRow();

        Object id = escritorTable.getValueAt(index, 0);
        Object nome = escritorTable.getValueAt(index, 1);
        Object sobrenome = escritorTable.getValueAt(index, 2);

        jTextFieldIdEscritor.setText(id.toString());
        jTextFieldNomeAuthor.setText(nome.toString());
        jTextFieldSobrenomeAuthor.setText(sobrenome.toString());

    }//GEN-LAST:event_escritorTableMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    fh = new FileHandler("BookFrame.log", true);
                    logger.addHandler(fh);
                    new BookFrame().setVisible(true);
                } catch (SQLException | IOException ex) {
                    logger.log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bookTable;
    private javax.swing.JButton customButton;
    private javax.swing.JTable escritorTable;
    private javax.swing.JButton jButtonDeleteBook;
    private javax.swing.JButton jButtonDeleteEscritor;
    private javax.swing.JButton jButtonInserirEscritor;
    private javax.swing.JButton jButtonInsertBook;
    private javax.swing.JButton jButtonUpdateEscritor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextFieldGeneroBook;
    private javax.swing.JTextField jTextFieldIdBook;
    private javax.swing.JTextField jTextFieldIdEscritor;
    private javax.swing.JTextField jTextFieldIdEscritorBook;
    private javax.swing.JTextField jTextFieldIsbnBook;
    private javax.swing.JTextField jTextFieldNomeAuthor;
    private javax.swing.JTextField jTextFieldPrecoBook;
    private javax.swing.JTextField jTextFieldSobrenomeAuthor;
    private javax.swing.JTextField jTextFieldTituloBook;
    private javax.swing.JButton xmlButtonBookLoad;
    private javax.swing.JButton xmlButtonExportBook;
    private javax.swing.JButton xmlButtonExportWriter;
    private javax.swing.JButton xmlButtonLoadWriter;
    // End of variables declaration//GEN-END:variables
}
