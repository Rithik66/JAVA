package Javatraining;

import java.util.*;

public class AdjacentSticks {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b=2,sum=0;
		ArrayList<Integer> ar_int = new ArrayList<Integer>();
		int arr[][] = new int[a/2][b];
		for(int i=0;i<a/2;i++) {
		for(int j=0;j<b;j++) {
			arr[i][j]=scanner.nextInt();
		}
		}
		for(int j=0;j<a/2;j++) {
			ar_int.add(Math.min(arr[j][0],arr[j][1]));
		}
		for(int i=0;i<a/2;i++) {
			sum+=ar_int.get(i);
		}
		System.out.println(sum);
	}
}