/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import control.FuncionarioController;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.FuncionarioModel;

/**
 *
 * @author adeil
 */
public class Tela_Funcionarios extends javax.swing.JPanel {
    FuncionarioController fc = new FuncionarioController();
    FuncionarioModel funcionario = new FuncionarioModel();

    
    public Tela_Funcionarios() {
        initComponents();
        fc.tblListarFuncs(this);
    }
    
    private void limparCampos() {
        inpNome.setText("");
        inpEmail.setText("");
        btnDisponivel.setSelected(false);
        btnIndisponivel.setSelected(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFuncionarios = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        inpNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        inpEmail = new javax.swing.JTextField();
        btnDisponivel = new javax.swing.JRadioButton();
        btnIndisponivel = new javax.swing.JRadioButton();
        btnEditar2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(243, 250, 220));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(92, 104, 22));
        jLabel2.setText("FUNCIONÁRIOS");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo (1).png"))); // NOI18N

        tblFuncionarios.setBackground(new java.awt.Color(243, 250, 220));
        tblFuncionarios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblFuncionarios.setForeground(new java.awt.Color(92, 104, 22));
        tblFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "EMAIL", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFuncionarios.setRowHeight(25);
        tblFuncionarios.setRowMargin(5);
        tblFuncionarios.setSelectionBackground(new java.awt.Color(157, 205, 90));
        tblFuncionarios.getTableHeader().setResizingAllowed(false);
        tblFuncionarios.getTableHeader().setReorderingAllowed(false);
        tblFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFuncionariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFuncionarios);
        if (tblFuncionarios.getColumnModel().getColumnCount() > 0) {
            tblFuncionarios.getColumnModel().getColumn(0).setResizable(false);
            tblFuncionarios.getColumnModel().getColumn(1).setResizable(false);
            tblFuncionarios.getColumnModel().getColumn(2).setResizable(false);
            tblFuncionarios.getColumnModel().getColumn(3).setResizable(false);
        }

        jButton3.setBackground(new java.awt.Color(157, 205, 90));
        jButton3.setText("EXCLUIR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(92, 104, 22));
        jLabel3.setText("Nome:");

        inpNome.setBackground(new java.awt.Color(92, 104, 22));
        inpNome.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(92, 104, 22));
        jLabel5.setText("Email:");

        inpEmail.setBackground(new java.awt.Color(92, 104, 22));
        inpEmail.setForeground(new java.awt.Color(255, 255, 255));

        buttonGroup.add(btnDisponivel);
        btnDisponivel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDisponivel.setForeground(new java.awt.Color(92, 104, 22));
        btnDisponivel.setText("Disponível");
        btnDisponivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisponivelActionPerformed(evt);
            }
        });

        buttonGroup.add(btnIndisponivel);
        btnIndisponivel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnIndisponivel.setForeground(new java.awt.Color(92, 104, 22));
        btnIndisponivel.setText("Indisponível");

        btnEditar2.setBackground(new java.awt.Color(157, 205, 90));
        btnEditar2.setText("EDITAR");
        btnEditar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(283, 283, 283)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDisponivel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnIndisponivel))
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(inpNome, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inpEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inpNome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inpEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDisponivel)
                            .addComponent(btnIndisponivel))
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 223, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFuncionariosMouseClicked
        int selectedRow = tblFuncionarios.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tblFuncionarios.getModel();
        inpNome.setText(model.getValueAt(selectedRow, 1).toString());
        inpEmail.setText(model.getValueAt(selectedRow, 2).toString());
        if("Disponível".equals(model.getValueAt(selectedRow, 3).toString())) {
            btnDisponivel.setSelected(true);
        }
        else {
            btnIndisponivel.setSelected(true);
        }
        
        funcionario.setId(Integer.parseInt(model.getValueAt(selectedRow, 0).toString()));
        
    }//GEN-LAST:event_tblFuncionariosMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int selectedRow = tblFuncionarios.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tblFuncionarios.getModel();

        if(selectedRow >= 0){
            int opt = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este funcionário?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if(opt == 0) {
                fc.excluir(funcionario.getId());
                model.removeRow(selectedRow);
                model.fireTableDataChanged();
                limparCampos();
            }
        
        }
        else {
                JOptionPane.showMessageDialog(null, "Favor selecionar um funcionário pafa editar!!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnDisponivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisponivelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDisponivelActionPerformed

    private void btnEditar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar2ActionPerformed
        String nome = inpNome.getText();
        String email = inpEmail.getText();
        String status;
        if(btnDisponivel.isSelected()){
            status = "Disponível";
        }
        else {
            status = "Indisponível";
        }

        if(nome.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor preencher os campos!!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else {
            FuncionarioModel funcionarioEdit = new FuncionarioModel();
            funcionarioEdit.setId(funcionario.getId());
            funcionarioEdit.setNome(nome);
            funcionarioEdit.setEmail(email);
            funcionarioEdit.setStatus(status);

            fc.atualizar(funcionarioEdit);
            
            limparCampos();
        }
    }//GEN-LAST:event_btnEditar2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JRadioButton btnDisponivel;
    private javax.swing.JButton btnEditar2;
    public javax.swing.JRadioButton btnIndisponivel;
    private javax.swing.ButtonGroup buttonGroup;
    public javax.swing.JTextField inpEmail;
    public javax.swing.JTextField inpNome;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblFuncionarios;
    // End of variables declaration//GEN-END:variables
}
