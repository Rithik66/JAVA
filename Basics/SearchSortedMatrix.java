package Javatraining;

import java.util.Scanner;

public class SearchSortedMatrix {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] matrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j]=scanner.nextInt();
			}
		}
		int data = scanner.nextInt();
		SearchSortedMatrix ssm = new SearchSortedMatrix();
		ssm.searchMatrix(matrix, n, data);
	}
	void searchMatrix(int[][]matrix,int n,int data) {
		int i=0;
		int j=n-1;
		while(j>=0 && i<n) {
			if(matrix[i][j]==data) {
				System.out.println("data "+data+" found at ("+i+","+j+")");
				return;
			}
			if(matrix[i][j]>data) j--;
			else i++;
		}
	}
}
