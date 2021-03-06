/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TelaEntrada.java
 *
 * Created on 26/05/2010, 12:29:27
 */

package visao;

import entrada.Entrada;
import entrada.Ponto;
import java.awt.Cursor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import threads.BarraProgresso;

/**
 *
 * @author Hemerson
 */
public class TelaEntrada extends javax.swing.JInternalFrame {

    DefaultTableModel modelo;
    DefaultListModel modeloLista;
    Parametros param;
    JMenuItem jMenuItemTelaSemivariograma;
    DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
    
    /** Creates new form TelaEntrada */
    public TelaEntrada(Parametros param, JMenuItem jMenuItemTelaSemivariograma) {
        initComponents();
        this.param = param;
        this.jMenuItemTelaSemivariograma = jMenuItemTelaSemivariograma;
        jTableArquivoTexto.getTableHeader().setReorderingAllowed(false);
        jTablePlanilha.getTableHeader().setReorderingAllowed(false);
        modelo = (DefaultTableModel) jTablePlanilha.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        modelo.setColumnCount(0);
        modelo = (DefaultTableModel) jTableArquivoTexto.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        try {
            modeloLista = (DefaultListModel) jListX.getModel();
            modeloLista.removeAllElements();
            modeloLista = (DefaultListModel) jListY.getModel();
            modeloLista.removeAllElements();
            modeloLista = (DefaultListModel) jListZ.getModel();
            modeloLista.removeAllElements();
        } catch (Exception e) {
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBarEntrada = new javax.swing.JProgressBar();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePlanilha = new javax.swing.JTable();
        jButtonAbrirPlanilha = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListX = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListY = new javax.swing.JList();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListZ = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonCarregarDadosPlanilha = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableArquivoTexto = new javax.swing.JTable();
        jButtonArquivoX = new javax.swing.JButton();
        jButtonArquivoY = new javax.swing.JButton();
        jButtonArquivoZ = new javax.swing.JButton();
        jButtonCarregarDadosArquivoTexto = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Software SEMAG v1.0 - Leitura dos Dados de Entrada");

        jProgressBarEntrada.setStringPainted(true);

        jTablePlanilha.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTablePlanilha.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTablePlanilha.setCellSelectionEnabled(true);
        jScrollPane2.setViewportView(jTablePlanilha);

        jButtonAbrirPlanilha.setText("Abrir Planilha");
        jButtonAbrirPlanilha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirPlanilhaActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(jListX);

        jScrollPane4.setViewportView(jListY);

        jScrollPane5.setViewportView(jListZ);

        jLabel1.setText("Variável X");

        jLabel2.setText("Variável Z");

        jLabel3.setText("Variável Y");

        jButtonCarregarDadosPlanilha.setText("Carregar Dados");
        jButtonCarregarDadosPlanilha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCarregarDadosPlanilhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane4, 0, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jButtonAbrirPlanilha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 496, Short.MAX_VALUE)
                        .addComponent(jButtonCarregarDadosPlanilha, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAbrirPlanilha)
                    .addComponent(jButtonCarregarDadosPlanilha))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addGap(21, 21, 21))
        );

        jTabbedPane1.addTab("Planilha", jPanel5);

        jTableArquivoTexto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "X", "Y", "Z"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableArquivoTexto.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane6.setViewportView(jTableArquivoTexto);

        jButtonArquivoX.setText("X");
        jButtonArquivoX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonArquivoXActionPerformed(evt);
            }
        });

        jButtonArquivoY.setText("Y");
        jButtonArquivoY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonArquivoYActionPerformed(evt);
            }
        });

        jButtonArquivoZ.setText("Z");
        jButtonArquivoZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonArquivoZActionPerformed(evt);
            }
        });

        jButtonCarregarDadosArquivoTexto.setText("Carregar Dados");
        jButtonCarregarDadosArquivoTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCarregarDadosArquivoTextoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jButtonArquivoX, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                .addComponent(jButtonArquivoY, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(171, 171, 171)
                .addComponent(jButtonArquivoZ, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(608, Short.MAX_VALUE)
                .addComponent(jButtonCarregarDadosArquivoTexto)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonArquivoZ)
                    .addComponent(jButtonArquivoX)
                    .addComponent(jButtonArquivoY))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCarregarDadosArquivoTexto)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Arquivo de Texto", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                    .addComponent(jProgressBarEntrada, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProgressBarEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAbrirPlanilhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirPlanilhaActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Selecione a planilha com os dados");
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // restringe a amostra a diretorios apenas
        fc.setFileFilter(new FileNameExtensionFilter("Planilha do Microsoft Excel", "xls"));
        fc.setCurrentDirectory(new File("arquivos/"));
        int res = fc.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            File arquivo = fc.getSelectedFile();
            this.trataArquivo(arquivo, "planilha");
        } else { //nao selecionou nenhum diretorio
        }
}//GEN-LAST:event_jButtonAbrirPlanilhaActionPerformed

    private void jButtonCarregarDadosPlanilhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCarregarDadosPlanilhaActionPerformed
        try {
            modeloLista = (DefaultListModel) jListX.getModel();
            String colunaX = (String) modeloLista.getElementAt(jListX.getSelectedIndex());
            String colunaY = (String) modeloLista.getElementAt(jListY.getSelectedIndex());
            String colunaZ = (String) modeloLista.getElementAt(jListZ.getSelectedIndex());
            List<String> elementosX = new ArrayList<String>();
            List<String> elementosY = new ArrayList<String>();
            List<String> elementosZ = new ArrayList<String>();
            modelo = (DefaultTableModel) jTablePlanilha.getModel();
            for (int i = 0; i < modelo.getRowCount(); i++) {
                for (int j = 0; j < modelo.getColumnCount(); j++) {
                    if (modelo.getColumnName(j).equals(colunaX)) {
                        String x = ((String) modelo.getValueAt(i, j));
                        elementosX.add(x.equals("") ? "0.0" : x.replace(",", "."));
                    }
                    if (modelo.getColumnName(j).equals(colunaY)) {
                        String y = ((String) modelo.getValueAt(i, j));
                        elementosY.add(y.equals("") ? "0.0" : y.replace(",", "."));
                    }
                    if (modelo.getColumnName(j).equals(colunaZ)) {
                        String z = ((String) modelo.getValueAt(i, j));
                        elementosZ.add(z.equals("") ? "0.0" : z.replace(",", "."));
                    }
                }
            }
            this.carregaDados(elementosX, elementosY, elementosZ);
        } catch (Exception e) {
            System.out.println("erro: " + e);
            JOptionPane.showMessageDialog(null, "Erro no carregamento dos dados", "Erro!", JOptionPane.INFORMATION_MESSAGE);
        }
}//GEN-LAST:event_jButtonCarregarDadosPlanilhaActionPerformed

    private void jButtonArquivoXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonArquivoXActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Selecione arquivo de texto com os dados para a variável X");
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // restringe a amostra a diretorios apenas
        fc.setFileFilter(new FileNameExtensionFilter("Arquivos de texto", "txt"));
        fc.setCurrentDirectory(new File("arquivos/txt"));
        int res = fc.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            File arquivo = fc.getSelectedFile();
            this.trataArquivo(arquivo, "texto X");
        } else { //nao selecionou nenhum diretorio
        }
}//GEN-LAST:event_jButtonArquivoXActionPerformed

    private void jButtonArquivoYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonArquivoYActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Selecione arquivo de texto com os dados para a variável Y");
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // restringe a amostra a diretorios apenas
        fc.setFileFilter(new FileNameExtensionFilter("Arquivos de texto", "txt"));
        fc.setCurrentDirectory(new File("arquivos/txt"));
        int res = fc.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            File arquivo = fc.getSelectedFile();
            this.trataArquivo(arquivo, "texto Y");
        } else { //nao selecionou nenhum diretorio
        }
}//GEN-LAST:event_jButtonArquivoYActionPerformed

    private void jButtonArquivoZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonArquivoZActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Selecione arquivo de texto com os dados para a variável Z");
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // restringe a amostra a diretorios apenas
        fc.setFileFilter(new FileNameExtensionFilter("Arquivos de texto", "txt"));
        fc.setCurrentDirectory(new File("arquivos/txt"));
        int res = fc.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            File arquivo = fc.getSelectedFile();
            this.trataArquivo(arquivo, "texto Z");
        } else { //nao selecionou nenhum diretorio
        }
}//GEN-LAST:event_jButtonArquivoZActionPerformed

    private void jButtonCarregarDadosArquivoTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCarregarDadosArquivoTextoActionPerformed
        try {
            List<String> elementosX = new ArrayList<String>();
            List<String> elementosY = new ArrayList<String>();
            List<String> elementosZ = new ArrayList<String>();
            modelo = (DefaultTableModel) jTableArquivoTexto.getModel();
            for (int i = 0; i < modelo.getRowCount(); i++) {
                elementosX.add(((String) modelo.getValueAt(i, 0)).replace(",", "."));
                elementosY.add(((String) modelo.getValueAt(i, 1)).replace(",", "."));
                elementosZ.add(((String) modelo.getValueAt(i, 2)).replace(",", "."));
            }
            this.carregaDados(elementosX, elementosY, elementosZ);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no carregamento dos dados", "Erro!", JOptionPane.INFORMATION_MESSAGE);
        }
}//GEN-LAST:event_jButtonCarregarDadosArquivoTextoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAbrirPlanilha;
    private javax.swing.JButton jButtonArquivoX;
    private javax.swing.JButton jButtonArquivoY;
    private javax.swing.JButton jButtonArquivoZ;
    private javax.swing.JButton jButtonCarregarDadosArquivoTexto;
    private javax.swing.JButton jButtonCarregarDadosPlanilha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jListX;
    private javax.swing.JList jListY;
    private javax.swing.JList jListZ;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JProgressBar jProgressBarEntrada;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableArquivoTexto;
    private javax.swing.JTable jTablePlanilha;
    // End of variables declaration//GEN-END:variables


    private void trataArquivo(File arquivo, String tipo) {
        if (tipo.equals("planilha")) {
            try {
                Workbook workbook = Workbook.getWorkbook(arquivo);
                Sheet sheet = workbook.getSheet(0);
                modelo = (DefaultTableModel) jTablePlanilha.getModel();
                while (modelo.getRowCount() > 0) {
                    modelo.removeRow(0);
                }
                modelo.setColumnCount(sheet.getColumns());

                Integer larguraColunas[] = new Integer[sheet.getColumns()];
                for (int i = 0; i < sheet.getColumns(); i++) {
                    larguraColunas[i] = 0;
                }
                Object nomeColunas[] = new Object[modelo.getColumnCount()];
                for (int i = 0; i < sheet.getRows(); i++) {
                    Object linha[] = new Object[sheet.getColumns()];
                    for (int j = 0; j < sheet.getColumns(); j++) {
                        if (i == 0) {
                            nomeColunas[j] = sheet.getCell(j, i).getContents();
                        } else {
                            linha[j] = sheet.getCell(j, i).getContents();
                        }
                        if (larguraColunas[j] < sheet.getCell(j, i).getContents().length()) { //maxima largura da coluna
                            larguraColunas[j] = sheet.getCell(j, i).getContents().length();
                        }
                    }
                    if (i != 0) {
                        modelo.addRow(linha);
                    }
                }

                modelo.setColumnIdentifiers(nomeColunas);
                jTablePlanilha.setModel(modelo);
                for (int i = 0; i < jTablePlanilha.getColumnCount(); i++) {
                    int l = larguraColunas[i];
                    int a = (l <= 15) ? (l <= 6 ? l * 13 : (((l > 6) && (l <= 10)) ? l * 8 : (int) (l * 7.5))) : l * 6;
                    jTablePlanilha.getColumnModel().getColumn(i).setPreferredWidth(a);
                    jTablePlanilha.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
                }

                /* insere colunas nas listas */
                modeloLista = new DefaultListModel();
                for (int i = 0; i < nomeColunas.length; i++) {
                    modeloLista.add(i, nomeColunas[i]);
                }
                jListX.setModel(modeloLista);
                jListY.setModel(modeloLista);
                jListZ.setModel(modeloLista);
                jListX.setSelectedIndex(0);
                jListY.setSelectedIndex(1);
                jListZ.setSelectedIndex(2);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro no carregamento dos dados!", "Erro!", JOptionPane.INFORMATION_MESSAGE);
            } catch (BiffException ex) {
                JOptionPane.showMessageDialog(null, "Erro no carregamento dos dados!", "Erro!", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            try {
                BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
                String coordenada = "";
                List valores = new ArrayList();
                modelo = (DefaultTableModel) jTableArquivoTexto.getModel();
                while ((coordenada = leitor.readLine()) != null) {
                    valores.add(coordenada);
                }
                modelo.setRowCount(valores.size());
                for (int i = 0; i < valores.size(); i++) {
                    if (tipo.split(" ")[1].equals("X")) {
                        modelo.setValueAt(valores.get(i), i, 0);
                    }
                    if (tipo.split(" ")[1].equals("Y")) {
                        modelo.setValueAt(valores.get(i), i, 1);
                    }
                    if (tipo.split(" ")[1].equals("Z")) {
                        modelo.setValueAt(valores.get(i), i, 2);
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    private void carregaDados(List<String> elementosX, List<String> elementosY, List<String> elementosZ) {
        Cursor cursor = new Cursor(Cursor.WAIT_CURSOR);
        this.setCursor(cursor);

        int minimo = 0;
        if (elementosX.size() < elementosY.size()) {
            if (elementosX.size() < elementosZ.size()) {
                minimo = elementosX.size();
            } else {
                minimo = elementosZ.size();
            }
        } else {
            if (elementosY.size() < elementosZ.size()) {
                minimo = elementosY.size();
            } else {
                minimo = elementosZ.size();
            }
        }
        this.param.setPontos(new Entrada());
        for (int i = 0; i < minimo; i++) {
            Ponto ponto = new Ponto(Double.parseDouble(elementosX.get(i)), Double.parseDouble(elementosY.get(i)), Double.parseDouble(elementosZ.get(i)));
            param.getPontos().getListaPontos().add(ponto);
        }

        jProgressBarEntrada.setStringPainted(true);
        BarraProgresso t = new BarraProgresso(jProgressBarEntrada, 0);
        param.getPontos().calculaDistancias(t);

        t.POSICAO = jProgressBarEntrada.getMaximum();
        t.interrupt();
        JOptionPane.showMessageDialog(null, "Dados carregados com sucesso!", "Dados Carregados", JOptionPane.INFORMATION_MESSAGE);
        this.jMenuItemTelaSemivariograma.setEnabled(true);
        this.setVisible(false);
        cursor = new Cursor(Cursor.DEFAULT_CURSOR);
        this.setCursor(cursor);
    }

    public Parametros getParam(){
        return this.param;
    }
}
