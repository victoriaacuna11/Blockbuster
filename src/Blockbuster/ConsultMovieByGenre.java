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
public class ConsultMovieByGenre extends javax.swing.JFrame {

    /**
     * Creates new form ConsultMovieByGenre
     */
    public ConsultMovieByGenre() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        if(!Cartelera.firstMovie){
            this.btnSearch.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Lo sentimos. Aún no hay ninguna película registrada en la base de datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        btnGoBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        movies = new javax.swing.JTextArea();
        movieGenre = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PELÍCULAS POR GÉNERO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 59, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("GÉNERO");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 147, -1, -1));

        btnSearch.setText("BUSCAR");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 218, -1, 38));

        btnGoBack.setText("VOLVER");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnGoBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 503, -1, 38));

        movies.setColumns(20);
        movies.setRows(5);
        movies.setEnabled(false);
        jScrollPane1.setViewportView(movies);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 324, 305, 137));

        movieGenre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Drama", "Comedia", "Deportivo", "Cultural" }));
        getContentPane().add(movieGenre, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 143, 209, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon3.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String genre = this.movieGenre.getSelectedItem().toString();
        boolean encontrada = false;
        String info = "";
        String intro1 = "PELÍCULAS DE "+genre+":\n";
        String intro2 = "NO HAY NINGUNA PELÍCULA\nALQUILADA DE "+genre.toUpperCase()+"\n";
        for (int i = 0; i < Cartelera.movies.length; i++) {
            if(Cartelera.movies[i].getGenre().equals(genre)){
                encontrada=true;
                info=info+"-"+Cartelera.movies[i].getName()+" ("+Cartelera.movies[i].getGenre()+") ID: "+
                Cartelera.movies[i].getID()+"\n";
            }
        }
        if(encontrada){
            this.movies.setText(intro1+info);
        }else{
            this.movies.setText(intro2);
        }
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnGoBackActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultMovieByGenre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultMovieByGenre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultMovieByGenre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultMovieByGenre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultMovieByGenre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> movieGenre;
    private javax.swing.JTextArea movies;
    // End of variables declaration//GEN-END:variables
}
