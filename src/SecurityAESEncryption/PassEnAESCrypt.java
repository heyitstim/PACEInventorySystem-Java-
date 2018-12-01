package SecurityAESEncryption;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
public class PassEnAESCrypt {
    private static final String ALGO = "AES";
    private static final String KEY = "2471aFb54d3e9177";
    
    public static String encrypt(String pass) throws Exception{
         Key key = generateKey();
        Cipher cipher = Cipher.getInstance(PassEnAESCrypt.ALGO);
        cipher.init(Cipher.ENCRYPT_MODE,key);
        byte [] encryptedByteValue = cipher.doFinal(pass.getBytes("utf-8"));
        String encryptedValue64 = new BASE64Encoder().encode(encryptedByteValue);
        return encryptedValue64;
      
    }
    public static String decrypt(String pass) throws Exception{
        Key key = generateKey();
        Cipher cipher = Cipher.getInstance(PassEnAESCrypt.ALGO);
        cipher.init(Cipher.DECRYPT_MODE,key);
        byte[] decryptedValue64 = new BASE64Decoder().decodeBuffer(pass);
        byte[] decryptedByteValue = cipher.doFinal(decryptedValue64);
        String decryptedValue = new String(decryptedByteValue,"utf-8");
        return decryptedValue;
    }
    private static Key generateKey() throws Exception{
        Key key = new SecretKeySpec(PassEnAESCrypt.KEY.getBytes(), PassEnAESCrypt.ALGO);
        return key;
    }
}
