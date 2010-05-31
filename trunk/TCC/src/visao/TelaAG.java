/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TelaAG.java
 *
 * Created on 26/05/2010, 13:49:14
 */
package visao;

import ag.AlgoritmoGenetico;
import ag.Cromossomo;
import java.awt.Component;
import java.awt.Cursor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.table.DefaultTableModel;
import threads.BarraProgresso;

/**
 *
 * @author Hemerson
 */
public class TelaAG extends javax.swing.JInternalFrame {

    AlgoritmoGenetico ag;
    Parametros param;
    DefaultTableModel modeloResultado;
    TelaPrincipal telaPrincipal;
    TelaSemivariograma telaSemivariograma;
    TelaResultado telaResultado;

    /** Creates new form TelaAG */
    public TelaAG(Parametros param, TelaPrincipal telaPrincipal, TelaSemivariograma telaSemivariograma, TelaResultado telaResultado) {
        initComponents();
        this.param = param;
        this.telaPrincipal = telaPrincipal;
        this.telaSemivariograma = telaSemivariograma;
        this.telaResultado = telaResultado;
        this.telaResultado.setVisible(false);
        this.ag = new AlgoritmoGenetico();
        jProgressBarAG.setStringPainted(false);
        jProgressBarAG.setValue(0);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupCruzamento = new javax.swing.ButtonGroup();
        buttonGroupMutacao = new javax.swing.ButtonGroup();
        buttonGroupSelecao = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanelCruzamento = new javax.swing.JPanel();
        jCheckBoxAritmetico = new javax.swing.JCheckBox();
        jCheckBoxBLX = new javax.swing.JCheckBox();
        jCheckBoxHeuristico = new javax.swing.JCheckBox();
        jCheckBoxMediaGeometrica = new javax.swing.JCheckBox();
        jCheckBoxMediaSimples = new javax.swing.JCheckBox();
        jPanelSelecao = new javax.swing.JPanel();
        jCheckBoxRoleta = new javax.swing.JCheckBox();
        jCheckBoxTorneio = new javax.swing.JCheckBox();
        jButtonIniciarAG = new javax.swing.JButton();
        jPanelMutacao = new javax.swing.JPanel();
        jCheckBoxCreep = new javax.swing.JCheckBox();
        jCheckBoxGaussiana = new javax.swing.JCheckBox();
        jCheckBoxNaoUniforme = new javax.swing.JCheckBox();
        jCheckBoxNaoUniformeMultipla = new javax.swing.JCheckBox();
        jCheckBoxUniforme = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldTamPopulacao = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldNumGeracoes = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldTxMutacao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldTxCruzamento = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldElitismo = new javax.swing.JTextField();
        jProgressBarAG = new javax.swing.JProgressBar();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Software SEMAG v1.0 - Algoritmo Genético");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanelCruzamento.setBackground(new java.awt.Color(255, 255, 255));
        jPanelCruzamento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cruzamento", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jCheckBoxAritmetico.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroupCruzamento.add(jCheckBoxAritmetico);
        jCheckBoxAritmetico.setText("Aritmético");

        jCheckBoxBLX.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroupCruzamento.add(jCheckBoxBLX);
        jCheckBoxBLX.setSelected(true);
        jCheckBoxBLX.setText("BLX");

        jCheckBoxHeuristico.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroupCruzamento.add(jCheckBoxHeuristico);
        jCheckBoxHeuristico.setText("Heurístico");

        jCheckBoxMediaGeometrica.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroupCruzamento.add(jCheckBoxMediaGeometrica);
        jCheckBoxMediaGeometrica.setText("Média Geométrica");

        jCheckBoxMediaSimples.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroupCruzamento.add(jCheckBoxMediaSimples);
        jCheckBoxMediaSimples.setText("Média Simples");

        javax.swing.GroupLayout jPanelCruzamentoLayout = new javax.swing.GroupLayout(jPanelCruzamento);
        jPanelCruzamento.setLayout(jPanelCruzamentoLayout);
        jPanelCruzamentoLayout.setHorizontalGroup(
            jPanelCruzamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCruzamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCruzamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxAritmetico)
                    .addComponent(jCheckBoxBLX)
                    .addComponent(jCheckBoxHeuristico)
                    .addComponent(jCheckBoxMediaGeometrica)
                    .addComponent(jCheckBoxMediaSimples))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelCruzamentoLayout.setVerticalGroup(
            jPanelCruzamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCruzamentoLayout.createSequentialGroup()
                .addComponent(jCheckBoxAritmetico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxBLX)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxHeuristico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxMediaGeometrica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxMediaSimples))
        );

        jPanelSelecao.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSelecao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleção", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jCheckBoxRoleta.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroupSelecao.add(jCheckBoxRoleta);
        jCheckBoxRoleta.setSelected(true);
        jCheckBoxRoleta.setText("Roleta");

        jCheckBoxTorneio.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroupSelecao.add(jCheckBoxTorneio);
        jCheckBoxTorneio.setText("Torneio");

        javax.swing.GroupLayout jPanelSelecaoLayout = new javax.swing.GroupLayout(jPanelSelecao);
        jPanelSelecao.setLayout(jPanelSelecaoLayout);
        jPanelSelecaoLayout.setHorizontalGroup(
            jPanelSelecaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSelecaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSelecaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxRoleta)
                    .addComponent(jCheckBoxTorneio))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelSelecaoLayout.setVerticalGroup(
            jPanelSelecaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSelecaoLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jCheckBoxRoleta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxTorneio)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jButtonIniciarAG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/aplicar.png"))); // NOI18N
        jButtonIniciarAG.setToolTipText("Iniciar AG");
        jButtonIniciarAG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarAGActionPerformed(evt);
            }
        });

        jPanelMutacao.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMutacao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mutação", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jCheckBoxCreep.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroupMutacao.add(jCheckBoxCreep);
        jCheckBoxCreep.setText("Creep");

        jCheckBoxGaussiana.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroupMutacao.add(jCheckBoxGaussiana);
        jCheckBoxGaussiana.setText("Gaussiana");
        jCheckBoxGaussiana.setEnabled(false);

        jCheckBoxNaoUniforme.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroupMutacao.add(jCheckBoxNaoUniforme);
        jCheckBoxNaoUniforme.setText("Não-Uniforme");
        jCheckBoxNaoUniforme.setEnabled(false);

        jCheckBoxNaoUniformeMultipla.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroupMutacao.add(jCheckBoxNaoUniformeMultipla);
        jCheckBoxNaoUniformeMultipla.setText("Não-Uniforme Múltipla");
        jCheckBoxNaoUniformeMultipla.setEnabled(false);

        jCheckBoxUniforme.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroupMutacao.add(jCheckBoxUniforme);
        jCheckBoxUniforme.setSelected(true);
        jCheckBoxUniforme.setText("Uniforme");

        javax.swing.GroupLayout jPanelMutacaoLayout = new javax.swing.GroupLayout(jPanelMutacao);
        jPanelMutacao.setLayout(jPanelMutacaoLayout);
        jPanelMutacaoLayout.setHorizontalGroup(
            jPanelMutacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMutacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMutacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxCreep)
                    .addComponent(jCheckBoxGaussiana)
                    .addComponent(jCheckBoxNaoUniforme)
                    .addComponent(jCheckBoxNaoUniformeMultipla)
                    .addComponent(jCheckBoxUniforme))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelMutacaoLayout.setVerticalGroup(
            jPanelMutacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMutacaoLayout.createSequentialGroup()
                .addComponent(jCheckBoxCreep)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxGaussiana)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxNaoUniforme)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxNaoUniformeMultipla)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxUniforme))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do AG", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel5.setText("Tam. População:");

        jTextFieldTamPopulacao.setText("200");
        jTextFieldTamPopulacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTamPopulacaoActionPerformed(evt);
            }
        });
        jTextFieldTamPopulacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldTamPopulacaoFocusGained(evt);
            }
        });

        jLabel6.setText("Num. Gerações:");

        jTextFieldNumGeracoes.setText("50");
        jTextFieldNumGeracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNumGeracoesActionPerformed(evt);
            }
        });
        jTextFieldNumGeracoes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldNumGeracoesFocusGained(evt);
            }
        });

        jLabel7.setText("Tx. Mutação (%):");

        jTextFieldTxMutacao.setText("5");
        jTextFieldTxMutacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTxMutacaoActionPerformed(evt);
            }
        });
        jTextFieldTxMutacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldTxMutacaoFocusGained(evt);
            }
        });

        jLabel8.setText("Tx. Cruzamento (%):");

        jTextFieldTxCruzamento.setText("75");
        jTextFieldTxCruzamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTxCruzamentoActionPerformed(evt);
            }
        });
        jTextFieldTxCruzamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldTxCruzamentoFocusGained(evt);
            }
        });

        jLabel13.setText("Elitismo (%)");

        jTextFieldElitismo.setText("5");
        jTextFieldElitismo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldElitismoActionPerformed(evt);
            }
        });
        jTextFieldElitismo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldElitismoFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldTxCruzamento)
                            .addComponent(jTextFieldTxMutacao)
                            .addComponent(jTextFieldNumGeracoes)
                            .addComponent(jTextFieldTamPopulacao, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldElitismo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTamPopulacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNumGeracoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTxMutacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTxCruzamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldElitismo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jProgressBarAG.setStringPainted(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBarAG, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanelCruzamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanelMutacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanelSelecao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonIniciarAG, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProgressBarAG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelSelecao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelMutacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelCruzamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonIniciarAG, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIniciarAGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarAGActionPerformed
        Cursor cursor = new Cursor(Cursor.WAIT_CURSOR);
        this.setCursor(cursor);
        try {
            /* SETA METODO DE SELECAO */
            ag.setSelecao(jCheckBoxRoleta.isSelected() ? "Roleta"
                    : (jCheckBoxTorneio.isSelected() ? "Torneio" : "Roleta"));

            /* SETA METODO DE CRUZAMENTO */
            ag.setCruzamento(jCheckBoxAritmetico.isSelected() ? "Aritmetico"
                    : (jCheckBoxBLX.isSelected() ? "BLX"
                    : (jCheckBoxHeuristico.isSelected() ? "Heuristico"
                    : (jCheckBoxMediaGeometrica.isSelected() ? "Media Geometrica"
                    : (jCheckBoxMediaSimples.isSelected() ? "Media Simples" : "Media Simples")))));

            /* SETA METODO DE MUTACAO */
            ag.setMutacao(jCheckBoxCreep.isSelected() ? "Creep"
                    : (jCheckBoxGaussiana.isSelected() ? "Gaussiana"
                    : (jCheckBoxNaoUniforme.isSelected() ? "Nao-Uniforme"
                    : (jCheckBoxNaoUniformeMultipla.isSelected() ? "Nao-Uniforme Multipla"
                    : (jCheckBoxMediaSimples.isSelected() ? "Uniforme" : "Uniforme")))));


            this.trataValorDigitado(jTextFieldTamPopulacao.getText());
            this.trataValorDigitado(jTextFieldNumGeracoes.getText());
            this.trataValorDigitado(jTextFieldTxCruzamento.getText());
            this.trataValorDigitado(jTextFieldTxMutacao.getText());
            this.trataValorDigitado(jTextFieldElitismo.getText());

            ag.setGeracoes(new ArrayList<List>());
            ag.setPopulacao(new ArrayList<Cromossomo>());
            ag.setTamanhoPopulacao(Integer.parseInt(jTextFieldTamPopulacao.getText()));
            ag.setTaxaMutacao(Double.parseDouble(jTextFieldTxMutacao.getText()) / 100);
            ag.setTaxaCruzamento(Double.parseDouble(jTextFieldTxCruzamento.getText()) / 100);
            ag.setTamanhoGeracao(Integer.parseInt(jTextFieldNumGeracoes.getText()));
            ag.setElitismo(Double.parseDouble(jTextFieldElitismo.getText()) / 100);

            jProgressBarAG.setStringPainted(true);
            BarraProgresso t = new BarraProgresso(jProgressBarAG, 0);

            modeloResultado = (DefaultTableModel) telaResultado.getJTableResultado().getModel();
            while (modeloResultado.getRowCount() > 0) {
                modeloResultado.removeRow(0);
            }

            long inicio = System.currentTimeMillis();
            ag.inicia(telaSemivariograma.getJSliderAlcance().getMaximum(),
                    telaSemivariograma.getJSliderEfeitoPepita().getMaximum(), param, t,
                    telaResultado.getJTextAreaResultado(), modeloResultado);
            long fim = System.currentTimeMillis();
            long exec = (fim - inicio);
            telaResultado.getJTextAreaResultado().append("\nTempo de Execução: \n");
            telaResultado.getJTextAreaResultado().append(exec + " ms ou " + (exec * 0.001) + " seg");

            this.setVisible(false);

            Component content = telaPrincipal.getContentPane();
            int x = (content.getWidth() - telaResultado.getWidth()) / 2;
            int y = (content.getHeight() - telaResultado.getHeight()) / 2;
            telaResultado.setLocation(x, y);
            telaResultado.setVisible(true);

            t.POSICAO = jProgressBarAG.getMaximum();
            t.interrupt();

            telaResultado.setTelaAG(this);
            telaResultado.setTelaSemivariograma(this.telaSemivariograma);
            telaResultado.getJTabbedPane().setSelectedIndex(0);

            /* Mostra melhor cromossomo */
            int linha = telaResultado.getJTableResultado().getRowCount() - 1;
            int a = new Integer("" + telaResultado.getJTableResultado().getValueAt(linha, 0));
            double c0 = Double.parseDouble("" + telaResultado.getJTableResultado().getValueAt(linha, 1));
            double c1 = Double.parseDouble("" + telaResultado.getJTableResultado().getValueAt(linha, 2));
            double f = Double.parseDouble("" + telaResultado.getJTableResultado().getValueAt(linha, 3));
            telaResultado.getJTextFieldResultadoAlcance().setText("" + a);
            telaResultado.getJTextFieldResultadoEfeitoPepita().setText("" + c0);
            telaResultado.getJTextFieldResultadoContribuicao().setText("" + c1);
            telaResultado.getJTextFieldResultadoFitness().setText("" + f);

            /*insere na tabela resultados sessao */
            modeloResultado = (DefaultTableModel)telaResultado.getJTableResultadosSessao().getModel();
            Object[] linhaResultado = new Object[]{""+(modeloResultado.getRowCount()+1),telaPrincipal.getParam().getMetodoEstimacao(),
            telaPrincipal.getParam().getModeloMatematico(),ag.getCruzamento(), ag.getMutacao(),exec, (String)(""+f).replace(".", ",")};
            modeloResultado.addRow(linhaResultado);
            telaResultado.getJTableResultadosSessao().setModel(modeloResultado);

            telaSemivariograma.desenhaGrafico();
        } catch (Exception e) {
            System.out.println("erro aqui" + e);
            JOptionPane.showMessageDialog(null, "ERRO!", "Erro ao iniciar AG", JOptionPane.INFORMATION_MESSAGE);
        }
        cursor = new Cursor(Cursor.DEFAULT_CURSOR);
        this.setCursor(cursor);
}//GEN-LAST:event_jButtonIniciarAGActionPerformed

    private void jTextFieldTamPopulacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTamPopulacaoActionPerformed
        jTextFieldTamPopulacao.setText(this.trataValorDigitado(jTextFieldTamPopulacao.getText()));
        jTextFieldNumGeracoes.requestFocus();
}//GEN-LAST:event_jTextFieldTamPopulacaoActionPerformed

    private void jTextFieldTamPopulacaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldTamPopulacaoFocusGained
        jTextFieldTamPopulacao.setSelectionStart(0);
        jTextFieldTamPopulacao.setSelectionEnd(jTextFieldTamPopulacao.getText().length());
}//GEN-LAST:event_jTextFieldTamPopulacaoFocusGained

    private void jTextFieldNumGeracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumGeracoesActionPerformed
        jTextFieldNumGeracoes.setText(this.trataValorDigitado(jTextFieldNumGeracoes.getText()));
        jTextFieldTxMutacao.requestFocus();
}//GEN-LAST:event_jTextFieldNumGeracoesActionPerformed

    private void jTextFieldNumGeracoesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNumGeracoesFocusGained
        jTextFieldNumGeracoes.setSelectionStart(0);
        jTextFieldNumGeracoes.setSelectionEnd(jTextFieldNumGeracoes.getText().length());
}//GEN-LAST:event_jTextFieldNumGeracoesFocusGained

    private void jTextFieldTxMutacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTxMutacaoActionPerformed
        jTextFieldTxMutacao.setText(this.trataValorDigitado(jTextFieldTxMutacao.getText()));
        jTextFieldTxCruzamento.requestFocus();
}//GEN-LAST:event_jTextFieldTxMutacaoActionPerformed

    private void jTextFieldTxMutacaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldTxMutacaoFocusGained
        jTextFieldTxMutacao.setSelectionStart(0);
        jTextFieldTxMutacao.setSelectionEnd(jTextFieldTxMutacao.getText().length());
}//GEN-LAST:event_jTextFieldTxMutacaoFocusGained

    private void jTextFieldTxCruzamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTxCruzamentoActionPerformed
        jTextFieldTxCruzamento.setText(this.trataValorDigitado(jTextFieldTxCruzamento.getText()));
        jTextFieldElitismo.requestFocus();
}//GEN-LAST:event_jTextFieldTxCruzamentoActionPerformed

    private void jTextFieldTxCruzamentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldTxCruzamentoFocusGained
        jTextFieldTxCruzamento.setSelectionStart(0);
        jTextFieldTxCruzamento.setSelectionEnd(jTextFieldTxCruzamento.getText().length());
}//GEN-LAST:event_jTextFieldTxCruzamentoFocusGained

    private void jTextFieldElitismoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldElitismoActionPerformed
        jTextFieldElitismo.setText(this.trataValorDigitado(jTextFieldElitismo.getText()));
}//GEN-LAST:event_jTextFieldElitismoActionPerformed

    private void jTextFieldElitismoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldElitismoFocusGained
        jTextFieldElitismo.setSelectionStart(0);
        jTextFieldElitismo.setSelectionEnd(jTextFieldElitismo.getText().length());
}//GEN-LAST:event_jTextFieldElitismoFocusGained
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupCruzamento;
    private javax.swing.ButtonGroup buttonGroupMutacao;
    private javax.swing.ButtonGroup buttonGroupSelecao;
    private javax.swing.JButton jButtonIniciarAG;
    private javax.swing.JCheckBox jCheckBoxAritmetico;
    private javax.swing.JCheckBox jCheckBoxBLX;
    private javax.swing.JCheckBox jCheckBoxCreep;
    private javax.swing.JCheckBox jCheckBoxGaussiana;
    private javax.swing.JCheckBox jCheckBoxHeuristico;
    private javax.swing.JCheckBox jCheckBoxMediaGeometrica;
    private javax.swing.JCheckBox jCheckBoxMediaSimples;
    private javax.swing.JCheckBox jCheckBoxNaoUniforme;
    private javax.swing.JCheckBox jCheckBoxNaoUniformeMultipla;
    private javax.swing.JCheckBox jCheckBoxRoleta;
    private javax.swing.JCheckBox jCheckBoxTorneio;
    private javax.swing.JCheckBox jCheckBoxUniforme;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelCruzamento;
    private javax.swing.JPanel jPanelMutacao;
    private javax.swing.JPanel jPanelSelecao;
    private javax.swing.JProgressBar jProgressBarAG;
    private javax.swing.JTextField jTextFieldElitismo;
    private javax.swing.JTextField jTextFieldNumGeracoes;
    private javax.swing.JTextField jTextFieldTamPopulacao;
    private javax.swing.JTextField jTextFieldTxCruzamento;
    private javax.swing.JTextField jTextFieldTxMutacao;
    // End of variables declaration//GEN-END:variables

    public String trataValorDigitado(String valor) {
        try {
            valor = valor.replace(',', '.');
            String retorno = "";
            for (int i = 0; i < valor.length(); i++) {
                if (this.isNumero(valor.charAt(i))) {
                    retorno += valor.charAt(i);
                }
            }
            return retorno;
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isNumero(char numero) {
        if ((numero == '0') || (numero == '1') || (numero == '2') || (numero == '3') || (numero == '4')) {
            return true;
        } else {
            if ((numero == '5') || (numero == '6') || (numero == '7') || (numero == '8') || (numero == '9')) {
                return true;
            }
        }
        return false;
    }

    public JProgressBar getJProgressBarAG() {
        return this.jProgressBarAG;
    }
}
