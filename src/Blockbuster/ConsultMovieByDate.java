
package Blockbuster;

import javax.swing.JOptionPane;

/**
 *
 * @author victoriaacuna
 */
public class ConsultMovieByDate extends javax.swing.JFrame {

    public ConsultMovieByDate() {
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
        jLabel2 = new javax.swing.JLabel();
        movieDate = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        btnGoBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        movies = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PELÍCULAS A SER DEVUELTAS ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("EN UNA FECHA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));
        getContentPane().add(movieDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 126, 228, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("FECHA");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 131, -1, -1));

        btnSearch.setText("BUSCAR");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, -1, 38));

        btnGoBack.setText("VOLVER");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnGoBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 519, -1, 38));

        movies.setColumns(20);
        movies.setRows(5);
        movies.setEnabled(false);
        jScrollPane1.setViewportView(movies);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 283, 302, 173));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon3.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if(this.validateDate()){
            String movies = "";
            boolean encontrada=false;
            String intro1 = "PELÍCULAS ALQUILADAS PARA "+this.movieDate.getText()+":\n";
            String intro2 = "NO HAY NINGUNA PELÍCULA ALQUILADA PARA "+this.movieDate.getText()+":\n";
            for (int i = 0; i < Cartelera.movies.length; i++) {
                if(Cartelera.movies[i].getDate().equals(this.movieDate.getText())){
                    encontrada=true;
                    movies=movies+Cartelera.movies[i].getName()+" ("+Cartelera.movies[i].getGenre()+") ID: "+
                            Cartelera.movies[i].getID()+". Alquilada por CI usuario: "+Cartelera.movies[i].getCI()+"\n";
                }
            }
            if(encontrada){
                this.movies.setText(intro1+movies);
            }else{
                this.movies.setText(intro2);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Fecha inválida.\nPor favor validar que esté en el siguiente formato: xx/xx/xxxx y que sea correcta.", "ERROR", JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(ConsultMovieByDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultMovieByDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultMovieByDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultMovieByDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultMovieByDate().setVisible(true);
            }
        });
    }
    public boolean validateDate(){
        if(!this.movieDate.getText().isEmpty()){
            String[] date = this.movieDate.getText().split("/");
            if(date.length==3){
                if(date[0].length()==2 && date[1].length()==2 && date[2].length()==4){
                    if(Metodos.isNumeric(date[0]) && Metodos.isNumeric(date[1]) && Metodos.isNumeric(date[2])){
                        return this.isDateCorrect(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    public boolean isDateCorrect(int day, int month, int year){
        if(year>=Cartelera.actualYear){
            if(month<13 && month>0){
                if(day<32){
                    if((month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12) && day>31){
                        return false;
                    }
                    if((month==4 || month==6 || month==9 || month==11) && month>30){
                        return false;
                    }
                    if(month==2 && day>28){
                        return false;
                    }
                    return true;
                } else {
                    return false;
                }
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField movieDate;
    private javax.swing.JTextArea movies;
    // End of variables declaration//GEN-END:variables
}
