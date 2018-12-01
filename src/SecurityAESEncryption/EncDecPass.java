package SecurityAESEncryption;
import javax.swing.*;
public class EncDecPass extends javax.swing.JOptionPane {
    private String pass;
    public String getPass(){
try{
    String p = pass;
    System.out.println(pass);
    String encryptedp = PassEnAESCrypt.encrypt(p);
            System.out.println(encryptedp);
}catch (Exception e) {
    JOptionPane.showMessageDialog(null, e);
}return this.pass;
    }
 
    public void setPass(String password){
    try{
    String p = password;
    System.out.println(p);
    String decryptedp = PassEnAESCrypt.decrypt(p);
            System.out.println(decryptedp);
}catch (Exception e) {
    JOptionPane.showMessageDialog(null, e);
}
        pass = password;
    }
    
}
