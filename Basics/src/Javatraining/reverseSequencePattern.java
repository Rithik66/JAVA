package Javatraining;
import java.util.Scanner;
public class reverseSequencePattern{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
	    int a = scanner.nextInt();
	    for(int i=1;i<=a;i++) {
	    	int odd=2*i-1;
	    	int j;
	    	for(j=0;j<=a-i;j++) {
	    		System.out.print(odd);
	    		odd+=2;
	    	}
	    	int k=-1;
	    	for(j=1;j<i;j++) {
	    		k+=2;
	    		System.out.print(k);
	    	}
	    	System.out.println();
	    }
	}
}
