import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tiposInvestimento.*;

public class EditorInvest extends javax.swing.JFrame {

    private DefaultTableModel model;
    private int rowIndex;
    
    public EditorInvest(DefaultTableModel model, int rowIndex) {
        initComponents();
        this.model = model;
        this.rowIndex = rowIndex;
    }
    
    public EditorInvest() {
        initComponents();
    }
    
    public void setValor(String valor) {
        txtValor.setText(valor);
    }

    public void setTempo(int tempo) {
        spinnerTempo1.setValue(tempo);
    }

    public String getValor() {
        return txtValor.getText();
    }

    public int getTempo() {
        return (Integer) spinnerTempo1.getValue();
    }

    public void preencherCampos(String valor, int tempo) {
        txtValor.setText(valor);
        spinnerTempo1.setValue(tempo);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spinnerTempo = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        lblTempo = new javax.swing.JLabel();
        spinnerTempo1 = new javax.swing.JSpinner();
        btnEdit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Editar");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Editar investimento");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel3.setText("Novo Valor (R$):");

        lblTempo.setText("Tempo:");

        spinnerTempo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/table_edit.png"))); // NOI18N
        btnEdit.setText("Editar");
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTempo)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinnerTempo1)
                            .addComponent(txtValor)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(btnEdit)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(99, 99, 99))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTempo)
                    .addComponent(spinnerTempo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btnEdit)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try {
            String valorStr = getValor().replace(",", ".");
            double valor = Double.parseDouble(valorStr);
            int tempo = getTempo();

            if (model != null) {
                String tipo = model.getValueAt(rowIndex, 1).toString();

                double montante = 0;
                double rendimento = 0;
                double rendimentoPorcentagem = 0;

                switch (tipo) {
                    case "Poupança" -> {
                        Poupanca p = new Poupanca(valor, tempo);
                        p.calcValorFinal();
                        montante = p.getMontante();
                        rendimento = ((montante - valor)/valor)*100;
                        rendimentoPorcentagem = p.getPorcRendimento();
                    }
                    case "CDB" -> {
                        CDB c = new CDB(valor, tempo);
                        c.calcValorFinal();
                        montante = c.getMontante();
                        rendimento = ((montante - valor)/valor)*100;
                        rendimentoPorcentagem = c.getPorcRendimento();
                    }
                    case "Tesouro Selic" -> {
                        TesouroSelic t = new TesouroSelic(valor, tempo);
                        t.calcValorFinal();
                        montante = t.getMontante();
                        rendimento = ((montante - valor)/valor)*100;
                        rendimentoPorcentagem = t.getPorcRendimento();
                    }
                    case "Ações" -> {
                        Acao a = new Acao(valor, tempo);
                        a.calcValorFinal();
                        montante = a.getMontante();
                        rendimento = ((montante - valor)/valor)*100;
                        rendimentoPorcentagem = a.getPorcRendimento();
                    }
                    default -> {
                        JOptionPane.showMessageDialog(this, "Tipo de investimento desconhecido.", "Aviso!", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }

                boolean isMensal = tipo.equals("Poupança") || tipo.equals("Ações");
                model.setValueAt(String.format("%.2f", valor), rowIndex, 2); // Novo valor inicial
                model.setValueAt(String.format("%.2f", montante), rowIndex, 3); // Valor final
                model.setValueAt(String.format("%.2f", rendimento), rowIndex, 4); // Rendimento em reais
                model.setValueAt(tempo + (isMensal ? " meses" : " anos"), rowIndex, 5); // Tempo com unidade

                JOptionPane.showMessageDialog(this, "Valores atualizados com sucesso!");
                dispose();

            } else {
                JOptionPane.showMessageDialog(this, "Erro: modelo de dados não definido.", "Aviso!", JOptionPane.WARNING_MESSAGE);
            }

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Digite um valor numérico válido.", "Aviso!", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_btnEditActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditorInvest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditorInvest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditorInvest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditorInvest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditorInvest().setVisible(true);
            }
        });
        
    
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblTempo;
    private javax.swing.JSpinner spinnerTempo;
    private javax.swing.JSpinner spinnerTempo1;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}