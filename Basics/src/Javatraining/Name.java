package Javatraining;
import java.util.Scanner;
public class Name {
	public static void main(String args[]) {
    	Scanner scanner = new Scanner(System.in);
    	int a = scanner.nextInt();
    	switch(a%8) {
    	case 1: 
    		System.out.println(a+3+"LB");
    		break;
    	case 2: 
    		System.out.println(a+3+"MB");
    		break;
    	case 3:
    		System.out.println(a+3+"UB");
    		break;
    	case 4:
    		System.out.println(a-3+"LB");
    		break;
    	case 5:
    		System.out.println(a-3+"MB");
    		break;
    	case 6:
    		System.out.println(a-3+"UB");
    		break;
    	case 7:
    		System.out.println(a+1+"SU");
    		break;
    	case 0:
    		System.out.println(a-1+"SL");
    		break;
    	default:
    		System.out.println("");
    		break;
    	}
    }
}





