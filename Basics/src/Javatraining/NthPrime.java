package Javatraining;
import java.util.Arrays;
import java.util.Scanner;
public class NthPrime {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int[] arr = new int[a];
		int[] arr1 = new int[a/2];
		int count=0,index=0;
		for(int j=0;j<a*10;j++){
			int i=2;
			boolean isPrime=true;
				if(j==0 || j==1) isPrime=false;
				else{
					while(i<=Math.sqrt(j)){
						if(j%i==0) isPrime=false;
						i++;
					}
				}
				if(isPrime) {
					count++;
					if(count<=a) {
						arr[index]=j;
						index++;
					}
					if(count>a) break;
				}
			}
		System.out.println(Arrays.toString(arr));
		index=0;
		for(int i=0;i<arr.length-1;i++) {
			if(i%2==0) {
				arr1[index]=arr[i];
				index++;
			}
		}
		System.out.println(Arrays.toString(arr1));
		index=a/2-1;
		for(int i=0;i<arr.length-1;i++) {
			if(i%2==0) {
				arr1[index]=arr[i];
				index--;
			}
		}
		System.out.println(Arrays.toString(arr1));
	}
	public static boolean isPrime(int i){
		return false;
	}
}