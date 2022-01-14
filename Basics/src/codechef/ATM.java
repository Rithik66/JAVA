package codechef;
import java.util.*;
class Codechef{
	public static void main (String[] args) throws java.lang.Exception{
		Scanner scanner= new Scanner (System.in);
		int x=scanner.nextInt();
		double y=scanner.nextDouble();
		double z= y-(x+0.5);
		if(x%5!=0)System.out.println(y);
		else if(z<0)System.out.println(y);
		else System.out.println(z);
	}
}
