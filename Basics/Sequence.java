package Javatraining;

import java.util.Scanner;

public class Sequence {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		boolean isTrue=false;
		int a = scanner.nextInt();
		int[]ar1 = new int[a];
		for(int i =0;i<a;i++) {
			ar1[i]=scanner.nextInt();
		}
		int b = scanner.nextInt();
		int[]ar2 = new int[b];
		for(int i=0;i<b;i++) {
			ar2[i]=scanner.nextInt();
		}
		int count=0,j=0,i=0;
		while(j<b) {
			while(i<a) {
			if(ar2[j]==ar1[i]) {
				count+=1;
				j++;i++;
				if(count==b) {
					isTrue=true;
					break;
				}
			}
			else {
				count=0;
				i++;
				}
			}
			break;
		}
		if(isTrue) System.out.println("Yes");
		else System.out.println("No");
	}
}