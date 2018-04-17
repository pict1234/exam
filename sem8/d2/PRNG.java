import java.util.*;

public class PRNG{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int s,n,u,r;
		int i=0;

		System.out.println("Enter seed: ");
		s = sc.nextInt();
	
		System.out.println("Enter n: ");
		n = sc.nextInt();

		System.out.println("RANDOM NUMBERS: ");
		
		while (i<n)
		{
			s = s*9;
			u = s%10;
			r= s/10;
			s = u+r;
			i++;
			System.out.println(s);
		}
	}
}

