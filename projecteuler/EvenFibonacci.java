package projecteuler;

import java.util.Scanner;

public class EvenFibonacci{
public static void main(String[]args) {
	long a=0,b=1;
	long res=0;
	long temp=0,sum=0;
	while(a<100){
		if(a%2==0) {
			sum+=a;
		}
		res=b+a;
		a=b;
		b=res;
	}
	System.out.println(sum);
	}
}
