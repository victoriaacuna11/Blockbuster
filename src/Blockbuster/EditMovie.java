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
public class EditMovie extends javax.swing.JFrame {

    /**
     * Creates new form EditMovie
     */
    public EditMovie() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        movieID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        movieName = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnGoBack = new javax.swing.JButton();
        btnEditMovie = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MODIFICAR PELÍCULA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 67, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 40, 20));
        getContentPane().add(movieID, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 158, 226, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NUEVO NOMBRE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 358, -1, -1));

        movieName.setEnabled(false);
        getContentPane().add(movieName, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 353, 226, -1));

        btnSearch.setText("BUSCAR");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 247, 150, 37));

        btnGoBack.setText("VOLVER");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnGoBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 489, 150, 39));

        btnEditMovie.setText("GUARDAR CAMBIOS");
        btnEditMovie.setEnabled(false);
        btnEditMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditMovieActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditMovie, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 489, 150, 39));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon3.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if(Cartelera.firstMovie){
            if(this.validateID()){
                int ID = Integer.parseInt(this.movieID.getText());
                int pos = Cartelera.buscarPelicula(ID);
                if(pos!=-1){
                    this.btnEditMovie.setEnabled(true);
                    this.movieName.setEnabled(true);
                    this.movieName.setText(Cartelera.movies[pos].getName());

                }else {
                   JOptionPane.showMessageDialog(this, "El ID no está asociado a ninguna película en el sistema.\nCompruebe que lo haya escrito bien.", "ERROR", JOptionPane.ERROR_MESSAGE); 
                   this.btnEditMovie.setEnabled(false);
                   this.movieName.setEnabled(false);
                   this.movieName.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(this, "El ID es inválido.\nDebe ser un número entero entre el 1 y el 999999", "ERROR", JOptionPane.ERROR_MESSAGE);
                this.btnEditMovie.setEnabled(false);
                this.movieName.setEnabled(false);
                   this.movieName.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay ninguna película en la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void btnEditMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditMovieActionPerformed
        if(this.validateMovieName()){
            if(this.validateID()){
                int ID = Integer.parseInt(this.movieID.getText());
                int pos = Cartelera.buscarPelicula(ID);
                if(pos!=-1){
                    Cartelera.movies[pos].setName(this.movieName.getText());
                    this.setVisible(false);
                }else {
                   JOptionPane.showMessageDialog(this, "El ID no está asociado a ninguna película en el sistema.\nCompruebe que lo haya escrito bien.", "ERROR", JOptionPane.ERROR_MESSAGE); 
                   this.btnEditMovie.setEnabled(false);
                   this.movieName.setEnabled(false);
                   this.movieName.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(this, "El ID es inválido.\nDebe ser un número entero entre el 1 y el 999999", "ERROR", JOptionPane.ERROR_MESSAGE);
                this.btnEditMovie.setEnabled(false);
                this.movieName.setEnabled(false);
                   this.movieName.setText("");
            }
        }else {
            JOptionPane.showMessageDialog(this, "El nombre de la película debe ser máximo de 30 caracteres.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditMovieActionPerformed

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
            java.util.logging.Logger.getLogger(EditMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditMovie().setVisible(true);
            }
        });
    }
    
    public boolean validateMovieName(){
        if(!this.movieName.getText().isEmpty() && this.movieName.getText().length()<31){
            return true;
        } else {
            return false;
        }
    }
    
    public boolean validateID(){
        if(!this.movieID.getText().isEmpty() && this.movieID.getText().length()<7){
            if(Metodos.isNumeric(this.movieID.getText())){
                if((Integer.parseInt(this.movieID.getText()))<1000000 && (Integer.parseInt(this.movieID.getText()))>0){
                    return true;
                }else {
                    return false;
                }
            } else {
                return false;
            }
        }else{
            return false;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditMovie;
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField movieID;
    private javax.swing.JTextField movieName;
    // End of variables declaration//GEN-END:variables
}
