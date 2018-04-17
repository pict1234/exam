public class RandomNumber{

long previousnumber;
int NumberLenght = 4;

public RandomNumber()
{
previousnumber = System.currentTimeMillis()% Integer.MAX_VALUE;
}

public RandomNumber(int seed)
{
previousnumber = seed;
String number = Long.toString(previousnumber);  //String visarlo
NumberLenght = number.length();
}

public int generate()
{
previousnumber++;
previousnumber = previousnumber*previousnumber;
String number = Long.toString(previousnumber); 
int a = (number.length()/2) - (NumberLenght/2); //braces chukavalya
StringBuilder NewNumber = new StringBuilder();
for(int i =a;i<a+NumberLenght &i>=0;i++) //i< chukavala
{
NewNumber.append(number.charAt(i));//he parameter visarlo
}

previousnumber = Long.parseLong(NewNumber.toString());//He pan visarlo
return (int)previousnumber;
}

}















