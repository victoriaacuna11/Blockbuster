/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blockbuster;

import javax.swing.JOptionPane;

/**
 *
 * @author victoriaacuna
 */
public class ConsultUserInfo extends javax.swing.JFrame {

    /**
     * Creates new form ConsultUserInfo
     */
    public ConsultUserInfo() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        if(!Cartelera.firstUser){
            this.btnSearch.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Lo sentimos.\nAún no se tiene registrado ningún usuario en la base de datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        userCI = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        userPhone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnGoBack = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DATOS DE USUARIO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 52, -1, -1));

        userCI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userCIActionPerformed(evt);
            }
        });
        getContentPane().add(userCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 149, 208, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CÉDULA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 154, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NOMBRE");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 317, -1, -1));

        userName.setEnabled(false);
        getContentPane().add(userName, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 312, 208, -1));

        btnSearch.setText("BUSCAR");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 220, 107, 37));

        userPhone.setEnabled(false);
        getContentPane().add(userPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 389, 208, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("TELÉFONO");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 394, -1, -1));

        btnGoBack.setText("VOLVER");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnGoBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 475, 107, 37));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon3.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if(this.validateCI()){
            int userID = Integer.parseInt(this.userCI.getText().substring(1));
            String userLiteralID = this.userCI.getText().substring(0,1);
            int posUser = Cartelera.buscarUsuario(userID, userLiteralID);
            if(posUser!=-1){
                this.userName.setText(Cartelera.users[posUser].getName());
                this.userPhone.setText(Integer.toString(Cartelera.users[posUser].getPhone()));
            } else {
                JOptionPane.showMessageDialog(this, "La cédula no está inscrita en el sistema.\nPor favor validar que esté correctamente escrita.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Cédula inválida.\nDebe seguir el siguiente formato: A99999999", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void userCIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userCIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userCIActionPerformed

    
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
            java.util.logging.Logger.getLogger(ConsultUserInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultUserInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultUserInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultUserInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultUserInfo().setVisible(true);
            }
        });
    }
    
    public boolean validateCI(){
        
        if(!this.userCI.getText().isEmpty() && this.userCI.getText().length()<10 && this.userCI.getText().length()>1){
            String literalID = this.userCI.getText().substring(0, 1);
            String numericID = this.userCI.getText().substring(1);
            boolean isNumeric = Metodos.isNumeric(numericID);
            boolean isLiteral = Metodos.isNumeric(literalID);
            
            if(isNumeric && !isLiteral){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField userCI;
    private javax.swing.JTextField userName;
    private javax.swing.JTextField userPhone;
    // End of variables declaration//GEN-END:variables
}
