/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Tela.java
 *
 * Created on 10/03/2010, 14:01:13
 */
package visao;

import threads.AtualizaMMQ;
import ag.AlgoritmoGenetico;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JDesktopPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hemerson
 */
public class TelaPrincipal extends javax.swing.JFrame {

    TelaEntrada telaEntrada;
    TelaSemivariograma telaSemivariograma;
    TelaAG telaAG;
    TelaResultado telaResultado;

    private UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
    DefaultTableModel modelo;
    DefaultTableModel modeloResultado;
    DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
    DefaultListModel modeloLista;
    private BufferedImage bi;
    Parametros param;
    AlgoritmoGenetico ag;
    AtualizaMMQ atualiza;

    /** Creates new form Tela */
    public TelaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        try {
            UIManager.setLookAndFeel(looks[3].getClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
        }

        /* Background */
        try {
            bi = ImageIO.read(new File("arquivos/background.jpg"));
        } catch (Exception e) {
            System.out.println("Erro no carregamento do background: " + e);
        }

        param = new Parametros();
        telaResultado = new TelaResultado();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new JDesktopPane() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (bi != null) {
                    g.drawImage(bi, 0, 0, this.getWidth(), this.getHeight(), this);
                }
            }
        };
        jInternalFrameSobre = new javax.swing.JInternalFrame();
        jLabelSobre = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArquivo = new javax.swing.JMenu();
        jMenuItemDadosEntrada = new javax.swing.JMenuItem();
        jMenuItemTelaSemivariograma = new javax.swing.JMenuItem();
        jMenuItemAG = new javax.swing.JMenuItem();
        jMenuSobre = new javax.swing.JMenu();
        jMenuItemSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Software SEMAG v1.0");

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));

        jInternalFrameSobre.setClosable(true);
        jInternalFrameSobre.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jInternalFrameSobre.setTitle("Sobre");

        jLabelSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imagemsobre.png"))); // NOI18N
        jLabelSobre.setText("jLabel17");
        jLabelSobre.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, null));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Estimação dos Parâmetros de Semivariogramas ");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Utilizando Algoritmos Genéticos");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel27.setText("Orientador:");

        jLabel28.setText("André Luiz Brun");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel29.setText("Versão:");

        jLabel30.setText("1.0");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel31.setText("Desenvolvedor:");

        jLabel32.setText("Hemerson Leandro Siqueira Carlin");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel33.setText("Contato:");

        jLabel34.setText("<html><a href=\"mailto:mersocarlin@gmail.com\">mersocarlin@gmail.com</a></html>");

        jLabel17.setText("<html>Implementação TCC - <b>Unioeste</b> 2010</html>");

        javax.swing.GroupLayout jInternalFrameSobreLayout = new javax.swing.GroupLayout(jInternalFrameSobre.getContentPane());
        jInternalFrameSobre.getContentPane().setLayout(jInternalFrameSobreLayout);
        jInternalFrameSobreLayout.setHorizontalGroup(
            jInternalFrameSobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrameSobreLayout.createSequentialGroup()
                .addComponent(jLabelSobre, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jInternalFrameSobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                    .addGroup(jInternalFrameSobreLayout.createSequentialGroup()
                        .addGroup(jInternalFrameSobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jInternalFrameSobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel30)
                            .addComponent(jLabel32)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jInternalFrameSobreLayout.setVerticalGroup(
            jInternalFrameSobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelSobre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jInternalFrameSobreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrameSobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrameSobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrameSobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrameSobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jInternalFrameSobre.setBounds(80, 100, 590, 230);
        jDesktopPane1.add(jInternalFrameSobre, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jMenuArquivo.setText("Arquivo");

        jMenuItemDadosEntrada.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemDadosEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/entrada.png"))); // NOI18N
        jMenuItemDadosEntrada.setText("Dados da Entrada");
        jMenuItemDadosEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDadosEntradaActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItemDadosEntrada);

        jMenuItemTelaSemivariograma.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemTelaSemivariograma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/semivariograma.png"))); // NOI18N
        jMenuItemTelaSemivariograma.setText("Semivariograma");
        jMenuItemTelaSemivariograma.setEnabled(false);
        jMenuItemTelaSemivariograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTelaSemivariogramaActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItemTelaSemivariograma);

        jMenuItemAG.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemAG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ag.png"))); // NOI18N
        jMenuItemAG.setText("Algoritmo Genético");
        jMenuItemAG.setEnabled(false);
        jMenuItemAG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAGActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItemAG);

        jMenuBar1.add(jMenuArquivo);

        jMenuSobre.setText("Ajuda");

        jMenuItemSobre.setText("Sobre");
        jMenuItemSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSobreActionPerformed(evt);
            }
        });
        jMenuSobre.add(jMenuItemSobre);

        jMenuBar1.add(jMenuSobre);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemDadosEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDadosEntradaActionPerformed
        jDesktopPane1.removeAll();
        jMenuItemTelaSemivariograma.setEnabled(false);
        jMenuItemAG.setEnabled(false);
        telaEntrada = new TelaEntrada(this.param, jMenuItemTelaSemivariograma);
        jDesktopPane1.add(telaEntrada);
        Component content = this.getContentPane();
        int x = (content.getWidth() - telaEntrada.getWidth()) / 2;
        int y = (content.getHeight() - telaEntrada.getHeight()) / 2;
        telaEntrada.setLocation(x, y);
        telaEntrada.setVisible(true);
    }//GEN-LAST:event_jMenuItemDadosEntradaActionPerformed

    private void jMenuItemAGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAGActionPerformed
        modelo = telaResultado.getModeloTabelaResultadosSessao();
        telaResultado = new TelaResultado();
        telaResultado.getJTableResultadosSessao().setModel(modelo);
        telaResultado.arrumaTabelaResultadosSessao();
        jDesktopPane1.add(this.telaResultado);
        
        telaAG = new TelaAG(this.param, this, this.telaSemivariograma, this.telaResultado);
        jDesktopPane1.add(telaAG);
        Component content = this.getContentPane();
        int x = (content.getWidth() - telaAG.getWidth()) / 2;
        int y = (content.getHeight() - telaAG.getHeight()) / 2;
        telaAG.setLocation(x, y);
        telaAG.setVisible(true);
    }//GEN-LAST:event_jMenuItemAGActionPerformed

    private void jMenuItemSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSobreActionPerformed
        jInternalFrameSobre.setVisible(false);
        Component content = this.getContentPane();
        int x = (content.getWidth() - jInternalFrameSobre.getWidth()) / 2;
        int y = (content.getHeight() - jInternalFrameSobre.getHeight()) / 2;
        jInternalFrameSobre.setLocation(x, y);
        jInternalFrameSobre.setVisible(true);
    }//GEN-LAST:event_jMenuItemSobreActionPerformed

    private void jMenuItemTelaSemivariogramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTelaSemivariogramaActionPerformed
        telaSemivariograma = new TelaSemivariograma(this.param, jMenuItemAG);
        jDesktopPane1.add(telaSemivariograma);
        Component content = this.getContentPane();
        int x = (content.getWidth() - telaSemivariograma.getWidth()) / 2;
        int y = (content.getHeight() - telaSemivariograma.getHeight()) / 2;
        telaSemivariograma.setLocation(x, y);
        telaSemivariograma.setVisible(true);
}//GEN-LAST:event_jMenuItemTelaSemivariogramaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JInternalFrame jInternalFrameSobre;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabelSobre;
    private javax.swing.JMenu jMenuArquivo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAG;
    private javax.swing.JMenuItem jMenuItemDadosEntrada;
    private javax.swing.JMenuItem jMenuItemSobre;
    private javax.swing.JMenuItem jMenuItemTelaSemivariograma;
    private javax.swing.JMenu jMenuSobre;
    // End of variables declaration//GEN-END:variables

    public Parametros getParam(){
        return this.param;
    }
}
