package Javatraining;
import java.util.Scanner;
public class Ropes {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a =scanner.nextInt();
		int b =scanner.nextInt();
		int[] c = new int[a];
		int j=0,res = 0;
		for(int i=0;i<a;i++) {
			c[i]=scanner.nextInt();
		}
		for(j =0;j+1<a;j++) {
			c[j+1]=(c[j]+c[j+1])-(2*b);
			res=c[j+1];
		}
		System.out.println(res);
	}
}