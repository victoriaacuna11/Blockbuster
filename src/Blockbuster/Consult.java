/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blockbuster;

/**
 *
 * @author victoriaacuna
 */
public class Consult extends javax.swing.JFrame {

    /**
     * Creates new form Consult
     */
    public Consult() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnMovieInfo = new javax.swing.JButton();
        btnUserInfo = new javax.swing.JButton();
        btnMovieUser = new javax.swing.JButton();
        btnMovieDate = new javax.swing.JButton();
        btnMovieDate1 = new javax.swing.JButton();
        btnGoBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("¿QUÉ DESEA CONSULTAR?");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        btnMovieInfo.setText("DATOS DE UNA PELÍCULA");
        btnMovieInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovieInfoActionPerformed(evt);
            }
        });
        getContentPane().add(btnMovieInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 307, 53));

        btnUserInfo.setText("DATOS DE UN USUARIO");
        btnUserInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserInfoActionPerformed(evt);
            }
        });
        getContentPane().add(btnUserInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 307, 53));

        btnMovieUser.setText("PELÍCULAS ALQUILADAS POR UN USUARIO");
        btnMovieUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovieUserActionPerformed(evt);
            }
        });
        getContentPane().add(btnMovieUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, 53));

        btnMovieDate.setText("PELÍCULAS ALQUILADAS POR UN USUARIO");
        btnMovieDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovieDateActionPerformed(evt);
            }
        });
        getContentPane().add(btnMovieDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, 53));

        btnMovieDate1.setText("PELÍCULAS POR GÉNERO");
        btnMovieDate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovieDate1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMovieDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 307, 53));

        btnGoBack.setText("VOLVER");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnGoBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 520, -1, 37));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon3.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUserInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserInfoActionPerformed
        ConsultUserInfo ui = new ConsultUserInfo();
    }//GEN-LAST:event_btnUserInfoActionPerformed

    private void btnMovieUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovieUserActionPerformed
        ConsultMoviesByUser cmbu = new ConsultMoviesByUser();
    }//GEN-LAST:event_btnMovieUserActionPerformed

    private void btnMovieDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovieDateActionPerformed
        ConsultMovieByDate cmbd = new ConsultMovieByDate();
    }//GEN-LAST:event_btnMovieDateActionPerformed

    private void btnMovieDate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovieDate1ActionPerformed
        ConsultMovieByGenre cmbg = new ConsultMovieByGenre();
    }//GEN-LAST:event_btnMovieDate1ActionPerformed

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void btnMovieInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovieInfoActionPerformed
        ConsultMovieInfo cmi = new ConsultMovieInfo();
    }//GEN-LAST:event_btnMovieInfoActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Consult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consult().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnMovieDate;
    private javax.swing.JButton btnMovieDate1;
    private javax.swing.JButton btnMovieInfo;
    private javax.swing.JButton btnMovieUser;
    private javax.swing.JButton btnUserInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
