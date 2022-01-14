package Javatraining;
import java.util.Scanner;
public class FishPattern{
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int count=0;
        for(int i=0;i<a;i++){
            for(int j=0;j<a;j++){
            	if(j<=i) System.out.print("* ");
            	else System.out.print("  ");
            }
            System.out.print("  ");
            for(int j=0;j<a;j++) {
            	if(j>=a-i-1)System.out.print("* ");
            	else System.out.print("  ");
            }
            for(int j=1;j<a;j++){
            	if(j<=i) System.out.print("* ");
            	else System.out.print("  ");
           }
           System.out.print("  ");
           System.out.println();
        }
        for(int j=0;j<(3*a)+1;j++){
        	System.out.print("* ");
        }
        System.out.println();
        for(int i=0;i<a;i++){
            for(int j=a;j>=0;j--){
            	if(j<=i) System.out.print("  ");
            	else System.out.print("* ");
            }
            for(int j=0;j<a;j++){
            	if(j<i) System.out.print("  ");
            	else System.out.print("* ");
            }
            for(int j=0;j<a;j++) {
            	if(j>=a-i-1)System.out.print("  ");
            	else System.out.print("* ");
            }
           System.out.println();
        }
        int st1=1,st2=1,t=a,k=a;;
        for(int i=0;i<a;i++) {
        	for(int j=0;j<st1;j++){
        		System.out.print("* ");
        	}
        	st1++;
        	for(int j=0;j<(2*t)-1;j++){
        		System.out.print("  ");
        	}
        	t--;
        	for(int j=0;j<st2;j++){
        		System.out.print("* ");
        	}
        	st2+=2;

            for(int j=0;j<k;j++) {
        		System.out.print("  ");
        	}
        	k--;
        	System.out.println();
        }
        for(int j=0;j<(3*a)+1;j++){
        	System.out.print("* ");
        }
        System.out.println();
        t=2;st2=2*a-1;k=a-1;
        for(int i=0;i<a;i++) {
        	for(int j=0;j<a-i;j++){
        		System.out.print("* ");
        	}
        	for(int j=t;j>0;j--){
        		System.out.print(" ");
        	}
        	t+=4;
        	for(int j=st2;j>0;j--){
        		System.out.print("* ");
        	}
        	st2-=2;
        	for(int j=0;j<k;j++) {
        		System.out.print(" ");
        	}
        	k+=2;
        	System.out.println();
        }
        
    }
}