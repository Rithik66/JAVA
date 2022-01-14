package Javatraining;

import java.util.Scanner;

public class dailyday1_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int two=2,ans=0,four=4,pow=2,two1=2;
		for(int i=1;i<=a;i++){
			if(i%2!=0){
				ans=two;
				two+=four;
				four+=2;
			}
			else {
				ans=(int)Math.pow(two1,pow);
				two1++;
			}
		}
		System.out.println(ans);	
	}
}