package Javatraining;
import java.util.Scanner;
public class PlaneHijack {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int arr[][] = new int[a][a];
		for(int i=0;i<a;i++) {
			for(int j=0;j<a;j++) {
				arr[i][j]=scanner.nextInt();
			}
		}
		int diagonal=0;
		for(int i=0;i<a;i++) {
			if(arr[i][i]>18 && arr[i][i]<60) diagonal++;
		}
		System.out.println(diagonal);
	}
}