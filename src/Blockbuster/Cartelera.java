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
public class Cartelera extends javax.swing.JFrame {
    
    static Pelicula movies[];
    static User users[];
    static boolean firstMovie;
    static boolean firstUser;
    static MovieIndex movieIndexes[];
    static UserIndex userIndexes[];
    static int actualYear;
    
    public Cartelera() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        this.firstUser=false;
        this.firstMovie=false;
        
        Metodos.crearPeliculas();
        Metodos.crearIndexPeliculas();
        Metodos.crearIndexUsuarios();
        Metodos.crearUsuarios();
        
        
        this.actualYear=2019;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCreateMovie = new javax.swing.JButton();
        btnEditMovie = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnRentMovie = new javax.swing.JButton();
        btnCreateUser = new javax.swing.JButton();
        btnEditUser = new javax.swing.JButton();
        btnReturnMovie = new javax.swing.JButton();
        btnConsult = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCreateMovie.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        btnCreateMovie.setText("CREAR PELÍCULA");
        btnCreateMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateMovieActionPerformed(evt);
            }
        });
        getContentPane().add(btnCreateMovie, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 163, 175, 56));

        btnEditMovie.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        btnEditMovie.setText("MODIFICAR PELÍCULA");
        btnEditMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditMovieActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditMovie, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 163, -1, 56));

        btnExit.setBackground(new java.awt.Color(0, 0, 0));
        btnExit.setText("SALIR");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 522, -1, 49));

        btnRentMovie.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        btnRentMovie.setText("RESERVAR PELÍCULA");
        btnRentMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRentMovieActionPerformed(evt);
            }
        });
        getContentPane().add(btnRentMovie, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 255, 175, 56));

        btnCreateUser.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        btnCreateUser.setText("CREAR USUARIO");
        btnCreateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateUserActionPerformed(evt);
            }
        });
        getContentPane().add(btnCreateUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 343, 175, 56));

        btnEditUser.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        btnEditUser.setText("MODIFICAR USUARIO");
        btnEditUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditUserActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 343, -1, 56));

        btnReturnMovie.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        btnReturnMovie.setText("DEVOLVER PELÍCULA");
        btnReturnMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnMovieActionPerformed(evt);
            }
        });
        getContentPane().add(btnReturnMovie, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 255, 179, 56));

        btnConsult.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        btnConsult.setText("CONSULTAR");
        btnConsult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultActionPerformed(evt);
            }
        });
        getContentPane().add(btnConsult, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 432, 175, 53));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CLUB DE VIDEO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 80, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon3.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateMovieActionPerformed
        CreateMovie cm = new CreateMovie(Cartelera.movies);

    }//GEN-LAST:event_btnCreateMovieActionPerformed

    private void btnCreateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateUserActionPerformed
        CreateUser cu = new CreateUser(Cartelera.users);
    }//GEN-LAST:event_btnCreateUserActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        Metodos.Escribir();
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnEditUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditUserActionPerformed
        EditUser eu = new EditUser();
    }//GEN-LAST:event_btnEditUserActionPerformed

    private void btnEditMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditMovieActionPerformed
        EditMovie em = new EditMovie();
    }//GEN-LAST:event_btnEditMovieActionPerformed

    private void btnRentMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRentMovieActionPerformed
        RentMovie rm = new RentMovie();
    }//GEN-LAST:event_btnRentMovieActionPerformed

    private void btnReturnMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnMovieActionPerformed
        ReturnMovie rnm = new ReturnMovie();
    }//GEN-LAST:event_btnReturnMovieActionPerformed

    private void btnConsultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultActionPerformed
        Consult c = new Consult();
    }//GEN-LAST:event_btnConsultActionPerformed

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
            java.util.logging.Logger.getLogger(Cartelera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cartelera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cartelera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cartelera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cartelera().setVisible(true);
            }
        });
    }
    
    public static int buscarPelicula(int dato){
        int n = Cartelera.movieIndexes.length;
        int centro,inf=0,sup=n-1;
        while(inf<=sup){
          centro=(sup+inf)/2;
          if(Cartelera.movieIndexes[centro].getMovieID()==dato) {
              return Cartelera.movieIndexes[centro].getArrayIndex();
          } else if(dato < Cartelera.movieIndexes[centro].getMovieID() ){
             sup=centro-1;
          } else {
            inf=centro+1;
          }
        }
        return -1;
    }
    
    public static int buscarUsuario(int dato, String literal){
        int n = Cartelera.userIndexes.length;
        int centro,inf=0,sup=n-1;
        while(inf<=sup){
          centro=(sup+inf)/2;
          if(Cartelera.userIndexes[centro].getUserCI()==dato) {
              return Cartelera.buscarLiteralCI(centro, literal);
          } else if(dato < Cartelera.userIndexes[centro].getUserCI()){
             sup=centro-1;
          } else {
            inf=centro+1;
          }
        }
        return -1;
    }
    
    public static int buscarLiteralCI(int dato, String literal){
        int pos=dato;
        boolean seguir = true;
        int n = pos -1;
        while(seguir){
            if(n>-1 && Cartelera.userIndexes[n].getUserCI()==Cartelera.userIndexes[pos].getUserCI()){
                pos=n;
                n=n-1;
            } else {
                seguir=!seguir;
            }
        }
        int posInicial=pos;
        seguir=true;
        n=pos+1;
        while(seguir){
            if(n<Cartelera.userIndexes.length && Cartelera.userIndexes[n].getUserCI()==Cartelera.userIndexes[pos].getUserCI()){
                pos=n;
                n=n+1;
            } else {
                seguir=!seguir;
            }
        }
        int posFinal = pos;
        int posDefinitiva=-1;
        for (int i = posInicial; i < posFinal+1; i++) {
            if(Cartelera.userIndexes[i].getUserLiteralCI().equals(literal)){
                posDefinitiva=Cartelera.userIndexes[i].getArrayIndex();
            }
        }
        return posDefinitiva;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsult;
    private javax.swing.JButton btnCreateMovie;
    private javax.swing.JButton btnCreateUser;
    private javax.swing.JButton btnEditMovie;
    private javax.swing.JButton btnEditUser;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnRentMovie;
    private javax.swing.JButton btnReturnMovie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
