import java.security.MessageDigest;    // security cha s chota ahe
import java.util.Scanner;
import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;//spec nahi lihila
import javax.crypto.spec.SecretKeySpec; //.spec nahi lihila

public class App{
public static void main(String[]args)
{
Scanner Input = new Scanner(System.in);
System.out.println("Enter the String\n");

String str = Input.nextLine();

System.out.println("Enter the Key\n");

int PK = Input.nextInt();

RandomNumber R1 = new RandomNumber(PK);
RandomNumber R2 = new RandomNumber(PK);
try{

byte key[] = Integer.toString(R1.generate()).getBytes("UTF-8");
MessageDigest SHA =  MessageDigest.getInstance("SHA-1");
key = SHA.digest(key);
key = Arrays.copyOf(key,16);
SecretKeySpec SK = new SecretKeySpec(key,"AES");
byte[] iv = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
IvParameterSpec IvSpec = new IvParameterSpec(iv);

Cipher Encrypt;
Encrypt = Cipher.getInstance("AES/CBC/PKCS5Padding");
Encrypt.init(Cipher.ENCRYPT_MODE,SK,IvSpec);
byte[] encrypted = Encrypt.doFinal(str.getBytes());
System.out.println("Message....Encrypted"+ Arrays.toString(encrypted));

byte key1[] = Integer.toString(R2.generate()).getBytes("UTF-8");
MessageDigest SHA1 =  MessageDigest.getInstance("SHA-1");
key1 = SHA1.digest(key1);
key1 = Arrays.copyOf(key1,16);
SecretKeySpec SK1 = new SecretKeySpec(key1,"AES");

Cipher Decrypt;
Decrypt = Cipher.getInstance("AES/CBC/PKCS5Padding");
Decrypt.init(Cipher.DECRYPT_MODE,SK1,IvSpec);
byte[] decrypted = Decrypt.doFinal(encrypted);
System.out.println("Message....Decrypted"+ new String(decrypted,"UTF-8"));
}//end try
catch(Exception e) // E capital ahe
{
e.printStackTrace();
Input.close();
}
Input.close();
}
}//end public class app




