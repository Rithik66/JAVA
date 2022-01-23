package Javatraining;

import java.util.Scanner;

public class Sudoku {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int arr[][] = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				arr[i][j]=scanner.nextInt();
			}
		}
		displaySudoku(arr);
	}
	public static void displaySudoku(int arr[][]) {
		int k=0,l=0;
		
	}
}
