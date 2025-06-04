import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

/**
 *
 * @authors Antônio Marcos
 */
public class TesteSwinguera extends javax.swing.JFrame {
    private TelaAdicionar telaAdicionar;
    private EditorInvest editorInvest;
    Object[] opcoes = {"Sim", "Não"};
    
    public TesteSwinguera() {
        initComponents();
        
        table.setAutoCreateRowSorter(true);
        ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) table.getColumnModel().getColumn(i).setCellRenderer(center);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        popAdicionar = new javax.swing.JMenuItem();
        popEditar = new javax.swing.JMenuItem();
        popRemover = new javax.swing.JMenuItem();
        popExportar = new javax.swing.JMenuItem();
        popCancelar = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        btnExportTxt = new javax.swing.JButton();
        btnTelaAdicionar = new javax.swing.JButton();
        EditorInvest = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        spinBuscarID = new javax.swing.JSpinner();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        popAdicionar.setText("Adicionar");
        popAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popAdicionarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(popAdicionar);

        popEditar.setText("Editar");
        popEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popEditarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(popEditar);

        popRemover.setText("Remover");
        popRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popRemoverActionPerformed(evt);
            }
        });
        jPopupMenu1.add(popRemover);

        popExportar.setText("Exportar");
        popExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popExportarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(popExportar);

        popCancelar.setText("Cancelar");
        jPopupMenu1.add(popCancelar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simulador de investimentos");
        setMinimumSize(new java.awt.Dimension(925, 300));

        jPanel2.setComponentPopupMenu(jPopupMenu1);
        jPanel2.setMaximumSize(new java.awt.Dimension(3840, 2160));

        btnExportTxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/table_go.png"))); // NOI18N
        btnExportTxt.setText("Exportar para txt");
        btnExportTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExportTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportTxtActionPerformed(evt);
            }
        });

        btnTelaAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnTelaAdicionar.setText("Adicionar");
        btnTelaAdicionar.setToolTipText("Adiciona uma simulação");
        btnTelaAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTelaAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelaAdicionarActionPerformed(evt);
            }
        });

        EditorInvest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/table_edit.png"))); // NOI18N
        EditorInvest.setText("Editar");
        EditorInvest.setToolTipText("Edita uma simulação, é necessário selecionar uma linha");
        EditorInvest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EditorInvest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditorInvestActionPerformed(evt);
            }
        });

        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btnRemove.setText("Remover");
        btnRemove.setToolTipText("Remove uma simulação, é necessário selecionar uma linha");
        btnRemove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tipo Investimento", "Investimento inicial (R$)", "Resultado (R$)", "Rendimento (%)", "Tempo", "Taxa (%)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setComponentPopupMenu(jPopupMenu1);
        table.setMaximumSize(new java.awt.Dimension(3840, 2160));
        table.setMinimumSize(new java.awt.Dimension(305, 0));
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(10);
            table.getColumnModel().getColumn(1).setPreferredWidth(80);
            table.getColumnModel().getColumn(2).setPreferredWidth(90);
            table.getColumnModel().getColumn(3).setPreferredWidth(50);
            table.getColumnModel().getColumn(4).setPreferredWidth(40);
            table.getColumnModel().getColumn(5).setPreferredWidth(10);
            table.getColumnModel().getColumn(6).setPreferredWidth(10);
        }

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/magnifier.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel2.setText("Pesquisar por ID:");

        spinBuscarID.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        spinBuscarID.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spinBuscarID, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnExportTxt))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(EditorInvest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTelaAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(jLabel2)
                    .addComponent(spinBuscarID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(btnTelaAdicionar)
                .addGap(18, 18, 18)
                .addComponent(EditorInvest)
                .addGap(18, 18, 18)
                .addComponent(btnRemove)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExportTxt)
                .addContainerGap())
        );

        btnTelaAdicionar.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void add() {
        if (telaAdicionar == null || !telaAdicionar.isDisplayable()) {
            telaAdicionar = new TelaAdicionar(this, (DefaultTableModel) table.getModel());
            telaAdicionar.setVisible(true);
        } else {
            telaAdicionar.toFront();
            telaAdicionar.requestFocus();
            Toolkit.getDefaultToolkit().beep();
        }
    }
    
    private void edit() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int selectedRowIndex = table.getSelectedRow();

        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(null, "Por favor, selecione uma linha para editar.", "Aviso!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int quantColunas = table.getColumnCount();
        Object[] dados = new Object[quantColunas];
        for (int i = 0; i < quantColunas; i++) {
            dados[i] = table.getValueAt(selectedRowIndex, i);
        }
        
        int id = (int) dados[0];

        int opcaoEsc = JOptionPane.showOptionDialog(null,
            "Tem certeza que deseja editar?\nID: " + id,
            "Confirmação de edição do ID " + id,
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opcoes,
            opcoes[0]
        );

        if (opcaoEsc == JOptionPane.YES_OPTION) {
            editorInvest = new EditorInvest(model, selectedRowIndex);

            // Preenche os campos com os valores existentes
            editorInvest.setValor(dados[2].toString());
            String tempoStr = dados[5].toString().replaceAll("[^\\d]", "");
            editorInvest.setTempo(Integer.parseInt(tempoStr));

            editorInvest.setLocationRelativeTo(null);
            editorInvest.setVisible(true);
        }
    }
    
    private void remove() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int selectedRowIndex = table.getSelectedRow();
        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(null, "Por favor, selecione uma linha para remover.", "Aviso!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int id = (int) table.getValueAt(selectedRowIndex, 0);
        int opcaoEsc = JOptionPane.showOptionDialog(null, 
                "Tem certeza que deseja remover\n\"ID: " + id + "\"?", 
                "Confirmação de remoção do ID " + id, 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
        );
        
        if (opcaoEsc == JOptionPane.YES_OPTION) {
            model.removeRow(selectedRowIndex);
            JOptionPane.showMessageDialog(null, "ID " + id + " removido!");
        }
    }
    
    private void export() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Nenhuma simulação para exportar.", "Aviso!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int opc = JOptionPane.showOptionDialog(null, "Tem certeza que deseja exportar a tabela para arquivo txt?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
        if (opc == JOptionPane.YES_OPTION) {
            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("registros.txt"))) {
                // Cabeçalho com larguras fixas
                writer.write(String.format("%-4s| %-18s| %-25s| %-15s| %-15s| %-10s| %-10s",
                        "ID", "Tipo Investimento", "Investimento Inicial (R$)", "Resultado (R$)",
                        "Rendimento (%)", "Tempo", "Taxa (%)"));
                writer.newLine();

                writer.write("--------------------------------------------------------------------------------------------------------------");
                writer.newLine();

                // Dados da tabela com as mesmas larguras do cabeçalho
                for (int i = 0; i < model.getRowCount(); i++) {
                    String linha = String.format("%-4s| %-18s| %-25s| %-15s| %-15s| %-10s| %-10s",
                            model.getValueAt(i, 0), model.getValueAt(i, 1), model.getValueAt(i, 2),
                            model.getValueAt(i, 3), model.getValueAt(i, 4), model.getValueAt(i, 5),
                            model.getValueAt(i, 6));
                    writer.write(linha);
                    writer.newLine();
                }

                writer.flush();
                JOptionPane.showMessageDialog(this, "Exportação concluída! Arquivo salvo como 'registros.txt'.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Erro ao exportar: " + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private int descobrirIndexID(int valor) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int index = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            int idTabela = (int) model.getValueAt(i, 0);
            if (valor == idTabela) return index;
            index++;
        }
        return -1;
    }
    
    private void btnTelaAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelaAdicionarActionPerformed
        add();
    }//GEN-LAST:event_btnTelaAdicionarActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        remove();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void EditorInvestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditorInvestActionPerformed
        edit();
    }//GEN-LAST:event_EditorInvestActionPerformed

    private void btnExportTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportTxtActionPerformed
        export();
    }//GEN-LAST:event_btnExportTxtActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int valor = (int) spinBuscarID.getValue();

        // Percorre todas as linhas da tabela
        for (int i = 0; i < model.getRowCount(); i++) {
            // Pega o valor da coluna 0 da linha (onde está o ID)
            int idTabela = (int) model.getValueAt(i, 0);

            // Compara o ID da tabela com o ID digitado
            if (valor == idTabela) {
                int id = (int) model.getValueAt(i, 0);
                int index = descobrirIndexID(valor);
                table.setRowSelectionInterval(index, index);
                table.scrollRectToVisible(table.getCellRect(index, index, true));
                // Monta a mensagem com as informações encontradas
                String msg = "ID: " + id + "\n";
                msg += "Tipo: " + model.getValueAt(i, 1) + "\n";
                msg += "Valor Inicial: R$ " + model.getValueAt(i, 2) + "\n";
                msg += "Montante: R$ " + model.getValueAt(i, 3) + "\n";
                msg += "Rendimento: " + model.getValueAt(i, 4) + "%\n";
                msg += "Tempo: " + model.getValueAt(i, 5) + "\n";
                msg += "Taxa: " + model.getValueAt(i, 6) + (model.getValueAt(i, 6).toString().startsWith("I") ? "" : "%");
                Object[] opcs = {"Editar", "Remover", "Cancelar"};
                // Mostra a mensagem
                int opc = JOptionPane.showOptionDialog(null, msg, "Busca do ID " + id, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcs, opcs[2]);
                switch (opc) {
                    case 0:
                        edit();
                        break;
                    case 1:
                        remove();
                        break;
                }
                return;
            }
        }

        // Se não achou nenhum ID igual
        JOptionPane.showMessageDialog(null, "Investimento com ID " + valor + " não encontrado.", "Aviso!", JOptionPane.WARNING_MESSAGE);
    
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void popAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popAdicionarActionPerformed
        add();
    }//GEN-LAST:event_popAdicionarActionPerformed

    private void popEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popEditarActionPerformed
        edit();
    }//GEN-LAST:event_popEditarActionPerformed

    private void popRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popRemoverActionPerformed
        remove();
    }//GEN-LAST:event_popRemoverActionPerformed

    private void popExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popExportarActionPerformed
        export();
    }//GEN-LAST:event_popExportarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TesteSwinguera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TesteSwinguera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TesteSwinguera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TesteSwinguera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TesteSwinguera().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EditorInvest;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnExportTxt;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnTelaAdicionar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem popAdicionar;
    private javax.swing.JMenuItem popCancelar;
    private javax.swing.JMenuItem popEditar;
    private javax.swing.JMenuItem popExportar;
    private javax.swing.JMenuItem popRemover;
    private javax.swing.JSpinner spinBuscarID;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
