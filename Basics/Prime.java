package Javatraining;
import java.util.*;
public class Prime {
public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int j=scanner.nextInt();
		int count=1;
		int odd=0,even=0;
		for(int n=2;n<=j;n++) {
			boolean isPrime=true;
			int i=2; 
			while(i<n){      
				if(n%i==0) {
					isPrime=false; 
					break;
				}
				i++;			   
			}
			if(isPrime==true) {
				if(count%2==0) even+=n;
				else odd+=n;
				count++;
			}
		}
		System.out.println(Math.abs(odd-even));
	}
}