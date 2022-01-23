package Javatraining;
import java.util.Scanner;
public class Hijack {
		public static void main(String[] args){
			Scanner scanner = new Scanner(System.in);
			int a = scanner.nextInt();
			int count=0;
			if(a>0) {
			int[]ar = new int[a];
			for(int i =0;i<a;i++) {
				ar[i]=scanner.nextInt();
				if(ar[i]<0) {System.out.println("Invalid Input"); count=1; break;}
			}
			if(count!=1) {
			int young=ar[0];
			int old = ar[0];
			for(int i =1;i<a;i++) {
				if(young>ar[i]) young=ar[i];
				if(old<ar[i]) old=ar[i];
			}
			System.out.println(young+" "+old);
			}
			}
			else System.out.println("Invalid Input");
		}	
}
