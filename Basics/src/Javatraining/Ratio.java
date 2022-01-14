package Javatraining;
import java.util.Scanner;
public class Ratio {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int arr[] = new int[a];
		arr[0]=scanner.nextInt();
		int min=arr[0];
		for (int i = 1; i < a; i++){
			arr[i]=scanner.nextInt();
			if(arr[i]<min) min=arr[i];
		}
		int gcd=0;
		for(int i=1;i<=min;i++){
			int count=0;
			for(int j=0;j<a;j++)
				if(arr[j]%i==0) count++;
			if(count==a) gcd=i;
		}
		for(int i=0;i<a;i++){
			System.out.print(arr[i]/gcd+" ");
		}
	}
}