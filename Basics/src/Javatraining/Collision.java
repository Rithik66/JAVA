package Javatraining;

import java.util.ArrayList;
import java.util.Scanner;

public class Collision {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a =scanner.nextInt();
		int b = scanner.nextInt();
		int arr[][] = new int[a][b];
		for(int i=0;i<a;i++) {
			for(int j=0;j<b;j++) {
				arr[i][j]=scanner.nextInt();
			}
		}
		ArrayList<Integer> newar = new ArrayList<Integer>();
		int totalans=0,ans=0;
		for(int i=0;i<b;i++) {
			for (int j=0;j<a;j++) {
				int sum=0;
				if(arr[j][i]==1) newar.add(arr[j][i]);
					for(int k=0;k<newar.size();k++) {
						sum+=k;
					}
					totalans=sum;
			}
			ans+=totalans;
			newar.clear();
		}
		System.out.println(ans);
	}
}