
package Blockbuster;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author victoriaacuna
 */
public class RentMovie extends javax.swing.JFrame {

    
    public RentMovie() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        if(Cartelera.firstMovie){
            this.fillMovies(this.movieSelected);
        } else {
            this.noMovies(this.movieSelected);
            this.movieSelected.setEnabled(false);
            this.btnRent.setEnabled(false);
        }
        if(!Cartelera.firstUser){
            this.btnRent.setEnabled(false);
            this.movieSelected.setEnabled(false);
            JOptionPane.showMessageDialog(this, "No hay ningún usuario en la base de datos. Lo sentimos.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void fillMovies(JComboBox cb){
        for (int i = 0; i < Cartelera.movieIndexes.length; i++) {
            cb.addItem(Cartelera.movies[Cartelera.movieIndexes[i].getArrayIndex()].getID()+"-. \""+
                    Cartelera.movies[Cartelera.movieIndexes[i].getArrayIndex()].getName()+"\" (" + 
                    Cartelera.movies[Cartelera.movieIndexes[i].getArrayIndex()].getGenre()+")");
        }
        
    }
    
    public void noMovies(JComboBox cb){
        cb.addItem("Lo sentimos. La base de datos se encuentra vacía.");
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
        movieSelected = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        userCI = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        movieDate = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnRent = new javax.swing.JButton();
        btnGoBack = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ALQUILAR UNA PELÍCULA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 55, -1, -1));

        getContentPane().add(movieSelected, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 170, 327, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SELECCIONE UNA PELÍCULA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 148, -1, -1));
        getContentPane().add(userCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 275, 327, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("INTRODUZCA SU NÚMERO DE CÉDULA");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 247, -1, -1));
        getContentPane().add(movieDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 375, 327, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("INTRODUZCA FECHA DE DEVOLUCIÓN (xx/xx/xxxx)");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 347, -1, -1));

        btnRent.setText("ALQUILAR");
        btnRent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRentActionPerformed(evt);
            }
        });
        getContentPane().add(btnRent, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 523, 130, 40));

        btnGoBack.setText("VOLVER");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnGoBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 524, 130, 39));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tiene que haberse registrado para poder alquilar una");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 443, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("película");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 471, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon3.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void btnRentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRentActionPerformed
        
        if(Cartelera.firstMovie){
            if(this.validateCI()){
                int userID = Integer.parseInt(this.userCI.getText().substring(1));
                String userLiteralID = this.userCI.getText().substring(0,1);
                int posUser = Cartelera.buscarUsuario(userID, userLiteralID);
                if(posUser!=-1){
                    if(this.validateDate()){
                        String[] infoMovie = this.movieSelected.getSelectedItem().toString().split("-");
                        int movieID = Integer.parseInt(infoMovie[0]);
                        int pos = Cartelera.buscarPelicula(movieID);
                        System.out.println(Cartelera.movies[pos].getCI());
                        if(Cartelera.movies[pos].getCI().isEmpty()){
                            
                            Cartelera.movies[pos].setDate(this.movieDate.getText());
                            Cartelera.movies[pos].setCI(this.userCI.getText());

                            if(!Cartelera.users[posUser].firstMovie){
                                Cartelera.users[posUser].firstMovie=true;
                                Cartelera.users[posUser].peliculas = new Pelicula[1];
                                Cartelera.users[posUser].peliculas[0]= Cartelera.movies[pos];
                            } else {
                                Pelicula[] p = new Pelicula[Cartelera.users[posUser].peliculas.length+1];
                                for (int i = 0; i < Cartelera.users[posUser].peliculas.length; i++) {
                                    p[i]=Cartelera.users[posUser].peliculas[i];
                                }
                                p[Cartelera.users[posUser].peliculas.length]=Cartelera.movies[pos];
                                Cartelera.users[posUser].peliculas = p;
                            }

//                            for (int i = 0; i < Cartelera.users[posUser].peliculas.length; i++) {
//                                System.out.println(Cartelera.users[posUser].peliculas[i].getName());
//                            }
                            this.setVisible(false);
                        } else {
                            String literalAux = Cartelera.movies[pos].getCI().substring(0, 1);
                            int ciAux = Integer.parseInt(Cartelera.movies[pos].getCI().substring(1));
                            int posAux = Cartelera.buscarUsuario(ciAux, literalAux);
                            JOptionPane.showMessageDialog(this, "Lo sentimos, no puede reservar esta película.\n"
                                    + Cartelera.movies[pos].getName()+" ya está reservada por "+
                                    Cartelera.users[posAux].getName(), "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Fecha inválida.\nPor favor validar que esté en el siguiente formato: xx/xx/xxxx y que sea correcta.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "La cédula no está inscrita en el sistema.\nPor favor validar que esté correctamente escrita.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Cédula inválida.\nDebe seguir el siguiente formato: A99999999", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay ninguna película en la base de datos. Lo sentimos.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRentActionPerformed

    
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
            java.util.logging.Logger.getLogger(RentMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RentMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RentMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RentMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RentMovie().setVisible(true);
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
    private javax.swing.JButton btnRent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField movieDate;
    public javax.swing.JComboBox<String> movieSelected;
    private javax.swing.JTextField userCI;
    // End of variables declaration//GEN-END:variables
}
