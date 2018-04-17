import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class EncryptPassword {
byte[] Password;
EncryptPassword(SecurePassword SP) throws NoSuchAlgorithmException,UnsupportedEncodingException
{
MessageDigest SHA = MessageDigest.getInstance("MD5");
Password = SHA.digest(SP.Password.getBytes("UTF-8"));
}
EncryptPassword(UnsecurePassword USP) throws NoSuchAlgorithmException,UnsupportedEncodingException
{
MessageDigest MD5 = MessageDigest.getInstance("SHA-1");
Password = MD5.digest(USP.Password.getBytes("UTF-8"));
}
byte[] getEncryptedPassword()
{
return Password;
}
}
