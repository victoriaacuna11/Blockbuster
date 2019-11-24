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
public class CreateUser extends javax.swing.JFrame {

    User users[];
    User newUser[];
    
    public CreateUser(User users[]) {
        initComponents();
        this.users=users;
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        userCI = new javax.swing.JTextField();
        userName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        userPhone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnCreateUser = new javax.swing.JButton();
        btnGoBack = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CREAR USUARIO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NOMBRE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 209, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CI");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 283, -1, 37));
        getContentPane().add(userCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 282, 230, 37));
        getContentPane().add(userName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 196, 230, 37));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NÚMERO DE");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 358, -1, 19));
        getContentPane().add(userPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 367, 230, 37));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TELÉFONO");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 383, 76, 25));

        btnCreateUser.setText("CREAR");
        btnCreateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateUserActionPerformed(evt);
            }
        });
        getContentPane().add(btnCreateUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 480, 96, 43));

        btnGoBack.setText("VOLVER");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnGoBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, -1, 43));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon3.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateUserActionPerformed
        
        if(this.validateUsername()){
            if(this.validateCI()){
                if(this.validatePhone()){
                    
                    
                    if(!Cartelera.firstUser){
                        User u = new User(Integer.parseInt(this.userPhone.getText()), this.userName.getText(), this.userCI.getText());
                        Cartelera.firstUser=true;
                        this.newUser = new User[1];
                        this.newUser[0]=u;
                        Cartelera.users=this.newUser;
                        
                        UserIndex index = new UserIndex(Integer.parseInt(u.getCI().substring(1)), 0, u.getCI().substring(0, 1));
                        UserIndex[] ui = new UserIndex[1];
                        ui[0] = index;
                        Cartelera.userIndexes = ui;
                        this.setVisible(false);
                    }else{
                        
                        int posTemporal = Cartelera.buscarUsuario(Integer.parseInt(this.userCI.getText().substring(1)),this.userCI.getText().substring(0,1));
                        if(posTemporal==-1){
                            
                            User u = new User(Integer.parseInt(this.userPhone.getText()), this.userName.getText(), this.userCI.getText());
                            this.newUser = new User[this.users.length+1];
                            for (int i = 0; i < this.users.length; i++) {
                                this.newUser[i]=this.users[i];
                            }
                            this.newUser[this.newUser.length-1]=u;
                            Cartelera.users=this.newUser;

                            UserIndex newIndex = new UserIndex(Integer.parseInt(u.getCI().substring(1)),this.newUser.length-1,u.getCI().substring(0,1));
                            UserIndex[] newUIs = new UserIndex[this.newUser.length];
                            for (int i = 0; i < newUIs.length-1; i++) {
                                newUIs[i]=Cartelera.userIndexes[i];
                            }
                            newUIs[newUIs.length-1]=newIndex;
                            newUIs=this.ordenarIndices(newUIs);
                            Cartelera.userIndexes=newUIs;
                            this.setVisible(false); 
                            
                        } else {
                            JOptionPane.showMessageDialog(this, "La cédula " + Cartelera.users[posTemporal].getCI() + " ya está registrada y pertenece a "
                                    + Cartelera.users[posTemporal].getName()+".\nPor favor, valide su cédula.", "ERROR", JOptionPane.ERROR_MESSAGE);
                            this.userCI.setText("");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "El teléfono es incorrecto.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Cédula inválida.\nDebe seguir el siguiente formato: A99999999", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "El nombre debe ser máximo de 30 caracteres.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_btnCreateUserActionPerformed

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
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new CreateUser().setVisible(true);
            }
        });
    }

    public boolean validateUsername(){
        if(!this.userName.getText().isEmpty() && this.userName.getText().length()<31){
            return true;
        } else {
            return false;
        }
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
    
    public boolean validatePhone(){
        if(!this.userPhone.getText().isEmpty() && Metodos.isNumeric(this.userPhone.getText())){
            return true;
        } else {
            return false;
        }
    }
    
    public UserIndex[] ordenarIndices(UserIndex[] newUIs){
        for (int i = 0; i < newUIs.length - 1; i++){
            int min = i;
            for (int j = i + 1; j < newUIs.length; j++){
                if (newUIs[j].getUserCI() < newUIs[min].getUserCI()){
                    min = j;
                }
            }
            if (i != min){
                UserIndex aux= newUIs[i];
                newUIs[i] = newUIs[min];
                newUIs[min] = aux;
            }
        }
        return newUIs;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateUser;
    private javax.swing.JButton btnGoBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField userCI;
    private javax.swing.JTextField userName;
    private javax.swing.JTextField userPhone;
    // End of variables declaration//GEN-END:variables
}
