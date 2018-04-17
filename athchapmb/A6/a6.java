import java.util.Scanner; //S capital ahe
public class a6{

	public static char p[] = {'a','b','c','d','e','f','g','h','i','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

	public static char ch[] = {'Q','W','E','R','T','Y','U','I','O','P','A','S','D','F','G','H','J','K','L','Z','X','C','V','B','N','M'};

public static String doEncryption(String s)
{
char c[] = new char[(s.length())];
for(int i=0;i<s.length();i++)
{
for(int j=0;j<26;j++)
{
if(p[j] == s.charAt(i))
{
c[i] = ch[j];	
break; /////break visarlo tya mule mem bound exception
				}

}
System.out.println(s.charAt(i)+" "+c[i]);
}

return (new String(c));
}

public static String doEncryption(String text,int s)
{
if(s<0)						//ha purna block visarlo 
{
return "Invalid Input";
}
StringBuffer result = new StringBuffer();
for(int i =0;i<text.length();i++)
{
if(Character.isUpperCase(text.charAt(i)))
{
char ch = (char)(((int)text.charAt(i)+s-65)%26+65); //ch[] chukla
result.append(ch);

}
else
{
char ch = (char)(((int)text.charAt(i)+s-97)%26+97); //ch[] chukla
result.append(ch);
}


}
return result.toString();
}//end public

public static void main(String[] args)
{
Scanner scanner = new Scanner(System.in);
System.out.println("Enter the password");
String text = scanner.next();
System.out.println("Enter your choice 1.Ceasar 2.Non\n");
int choice = scanner.nextInt();

switch(choice)
{
case 1:
	System.out.println("Enter the shift");
	int s = scanner.nextInt();
	System.out.println("Ceasar\n"+doEncryption(text,s)); // args chukle
	break;//he visarlo
case 2:
	System.out.println("Dusra cypher");			
	System.out.println("Ceasar\n"+doEncryption(text));
	break;
}
scanner.close();
}//end public
}//end a6
