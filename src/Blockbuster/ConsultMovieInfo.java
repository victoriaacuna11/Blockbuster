
package Blockbuster;

import javax.swing.JOptionPane;

/**
 *
 * @author victoriaacuna
 */
public class ConsultMovieInfo extends javax.swing.JFrame {

    /**
     * Creates new form ConsultMovieInfo
     */
    public ConsultMovieInfo() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        if(!Cartelera.firstMovie){
            this.btnSearch.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Lo sentimos.\nAún no se tiene registrado ninguna película en la base de datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGoBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        movieID = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        movieName = new javax.swing.JTextField();
        movieGenre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        movieDate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        movieCI = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGoBack.setText("VOLVER");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnGoBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 508, -1, 40));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DATOS DE PELÍCULA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 42, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 125, -1, -1));

        movieID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movieIDActionPerformed(evt);
            }
        });
        getContentPane().add(movieID, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 120, 234, -1));

        btnSearch.setText("BUSCAR");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 172, 107, 37));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NOMBRE");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 246, -1, -1));

        movieName.setEnabled(false);
        getContentPane().add(movieName, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 241, 234, -1));

        movieGenre.setEnabled(false);
        getContentPane().add(movieGenre, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 301, 234, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("GÉNERO");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 306, -1, -1));

        movieDate.setEnabled(false);
        getContentPane().add(movieDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 449, 234, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CÉDULA");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 396, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("FECHA");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 454, -1, -1));

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("DATOS DE ALQUILER");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 361, -1, -1));

        movieCI.setEnabled(false);
        getContentPane().add(movieCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 396, 234, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon3.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void movieIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movieIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_movieIDActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if(this.validateID()){
            int ID = Integer.parseInt(this.movieID.getText());
            int pos = Cartelera.buscarPelicula(ID);
            if(pos!=-1){
                this.movieName.setText(Cartelera.movies[pos].getName());
                this.movieGenre.setText(Cartelera.movies[pos].getGenre());
                if(Cartelera.movies[pos].getCI().equals("")){
                    this.movieCI.setText("No ha sido alquilada.");
                } else {
                    this.movieCI.setText(Cartelera.movies[pos].getCI());
                    this.movieDate.setText(Cartelera.movies[pos].getDate());
                }
            }else{
                JOptionPane.showMessageDialog(this, "El ID no está asociado a ninguna película en el sistema.\nCompruebe que lo haya escrito bien.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "El ID es inválido.\nDebe ser un número entero entre el 1 y el 999999", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultMovieInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultMovieInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultMovieInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultMovieInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultMovieInfo().setVisible(true);
            }
        });
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
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField movieCI;
    private javax.swing.JTextField movieDate;
    private javax.swing.JTextField movieGenre;
    private javax.swing.JTextField movieID;
    private javax.swing.JTextField movieName;
    // End of variables declaration//GEN-END:variables
}
