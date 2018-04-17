import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class App {
public static boolean containsUCL(String str) {
Pattern p = Pattern.compile("[A-Z]", Pattern.CANON_EQ);
Matcher m = p.matcher(str);
return m.find();
}
public static boolean containsNumber(String str){
Pattern p = Pattern.compile("[0-9]", Pattern.CASE_INSENSITIVE);
Matcher m = p.matcher(str);
return m.find();
}
public static boolean containsSpecialChars(String str){
Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
Matcher m = p.matcher(str);
return m.find(); }
public static void main(String[] args) {
System.out.println("Enter password to be encrypted:");
Scanner Input = new Scanner(System.in);
String str = Input.nextLine();
Input.close();
EncryptPassword Cipher = null;
if(!containsUCL(str) && !containsNumber(str) &&
!containsSpecialChars(str))
{ System.out.println("calling Secured Hash method.\n");
try {
Cipher = new EncryptPassword(new SecurePassword(str));
} catch (NoSuchAlgorithmException e) {
// TODO Auto-generated catch block
e.printStackTrace();
} catch (UnsupportedEncodingException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
else
{ System.out.println("Calling unsecured Hash method.\n");
try {
Cipher = new EncryptPassword(new UnsecurePassword(str));
} catch (NoSuchAlgorithmException e) {
// TODO Auto-generated catch block
e.printStackTrace();
} catch (UnsupportedEncodingException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
System.out.println("Encrypted string : "+
Arrays.toString(Cipher.getEncryptedPassword()));
}
}
