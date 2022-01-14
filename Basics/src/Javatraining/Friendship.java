package Javatraining;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class Friendship {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int[]ar = new int[a];
		for(int i =0;i<a;i++) {
			ar[i]=scanner.nextInt();
		}
		Arrays.sort(ar);
		int j=0,count=1;
		int[]temp = new int[a];
		for(int i=0;i<a-1;i++) {
			if(ar[i]!=ar[i+1]) {
				temp[j]=ar[i];
				count++;
				j++;
			}
		}
		temp[j]=ar[a-1];
		System.out.println(count);
	}
}