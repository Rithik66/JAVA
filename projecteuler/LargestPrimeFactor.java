package projecteuler;

import java.util.Scanner;  
public class LargestPrimeFactor {  
 public static void main(String[] args) {  
  Scanner input = new Scanner(System.in);  
  long a = input.nextLong();
  for(long i=1;i<=a;i++) {
	  if(a%i==0) {
		  long j=2;
		  boolean isPrime=true;
		  if(i==0||i==1) {
			  isPrime=false;
		  } else {
		  while(j<i){
			  if(i%j==0)
				  isPrime=false;
			  j++;
		  }
		  if(isPrime) System.out.print(i+" ");
	  }
	  }
  }
}  
}