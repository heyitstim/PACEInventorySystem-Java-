package gmca.pace.inventory.system;
import DatabaseConnection.dbcom;
import SecurityAESEncryption.*;
import SecurityAESEncryption.EncDecPass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
public final class ALogin extends javax.swing.JFrame {
    Connection con;
    dbcom DBCon;
    PreparedStatement pst;
    ResultSet rs;   
    EncDecPass enc = new EncDecPass();
    String p = "";
    public ALogin() {
        initComponents();
        DBCon = new dbcom();
        con = DBCon.getConnection();
        System.out.println(con);
        System.out.println(pst);
        rootPane.setDefaultButton(jButton1);
        getSup();
        getVal();
    }
    public void getVal(){
        ValuePasser v = new ValuePasser();
        String val = jComboBox1.getSelectedItem().toString();
        v.setValue(val);
    }
    public void NormAuth() throws Exception{
        String getName = jComboBox1.getSelectedItem().toString();
        p = "";
        char [] pw = jPasswordField1.getPassword();
        p = "";
        for (int i=0; i < pw.length; i++){
            p+=String.valueOf(pw[i]);
        }
        System.out.println(p);
        System.out.println(getName);
        String pquery = "SELECT e_pass FROM employees WHERE e_name ="+"'"+getName+"'";
        try{
            pst = con.prepareStatement(pquery);
            rs = pst.executeQuery();
            System.out.println(pst);
            System.out.println(rs);
            if(rs.next()){
            String un = rs.getString(ICONIFIED);
            String yay = PassEnAESCrypt.decrypt(un);
            if(p.equals(yay)){
                JOptionPane.showMessageDialog(null, "Login Succeed", "LOGIN!", INFORMATION_MESSAGE);
                this.hide();
                MWindow mw = new MWindow(jComboBox1.getSelectedItem().toString());
                mw.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "PASSWORD INCORRECT!", "ERROR CODE!", WARNING_MESSAGE);
                jPasswordField1.setText(null);
            }
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
     public void getSup(){
     String gdquery = "SELECT e_name FROM employees";   
     try{
     pst = con.prepareStatement(gdquery);
     rs = pst.executeQuery(gdquery);
     System.out.println(rs);
     System.out.println(pst);
     while(rs.next()){
         jComboBox1.addItem(rs.getString(1));
     }
     }catch (SQLException e){
         JOptionPane.showMessageDialog(null, e);
     }
    }
     public void getAdmin() throws Exception{
        String getName = jComboBox1.getSelectedItem().toString();
        p = "";
        char [] pw = jPasswordField1.getPassword();
        p = "";
        for (int i=0; i < pw.length; i++){
            p+=String.valueOf(pw[i]);
        }
        System.out.println(p);
        System.out.println(getName);
        String pquery = "SELECT e_pass FROM employees WHERE e_name ='administrator'";
        try{
            pst = con.prepareStatement(pquery);
            rs = pst.executeQuery();
            System.out.println(pst);
            System.out.println(rs);
            if(rs.next()){
            String un = rs.getString(ICONIFIED);
            String yay = PassEnAESCrypt.decrypt(un);
            if(p.equals(yay)){
                JOptionPane.showMessageDialog(null, "Login Succeed", "LOGIN!", INFORMATION_MESSAGE);
                this.hide();
                AForm af = new AForm();
                af.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "PASSWORD INCORRECT!", "ERROR CODE!", WARNING_MESSAGE);
                jPasswordField1.setText(null);
            }
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(rootPane, e);
        }
     }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(1500, 1500));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel1.setText("USERNAME");

        jLabel2.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel2.setText("PASSWORD");

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jButton1.setText("LOGIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("CANCEL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordField1)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(291, 291, 291))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String val = jComboBox1.getSelectedItem().toString();
        if("administrator".equals(val)){
            try {
                getAdmin();
            } catch (Exception ex) {
                Logger.getLogger(ALogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
        try {
            NormAuth();
        } catch (Exception ex) {
            Logger.getLogger(ALogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
        
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
       
    }//GEN-LAST:event_jPasswordField1ActionPerformed

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
            java.util.logging.Logger.getLogger(ALogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ALogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ALogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ALogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ALogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    public javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    // End of variables declaration//GEN-END:variables
}
