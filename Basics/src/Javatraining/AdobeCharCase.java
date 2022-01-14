package Javatraining;
import java.util.*;
public class AdobeCharCase{
	public static void main (String[]args) throws java.lang.Exception{
		char p = ChangeCase(c);
	}
static char ChangeCase(char c) throws java.lang.Exception{
		int a = c;
		if(a>=97) a-=32;
		else if(a>=65) a+=32;
		System.out.println((char)a);
		return c;
	}
	static {
		System.out.print("c: ");
		}
	static Scanner scanner = new Scanner(System.in);
	static char c = scanner.next().charAt(0);
}