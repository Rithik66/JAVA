package Javatraining;
import java.util.Scanner;

public class Paint {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int ar[] = new int[a];
		for(int i=0;i<a;i++) {
			ar[i]=scanner.nextInt();
		}
		int temp[] = new int[50];
		for (int i = 0; i < a; i++) {
				temp[ar[i]]+=1;
		}
		int maxnum=temp[ar[0]];
		for (int i = 0; i < a; i++) {
			maxnum=Math.max(temp[ar[i]], maxnum);
		}
		for (int i = 0; i < a; i++) {
			if(maxnum==temp[i]) {break;}
		}
		System.out.println(a-maxnum);
	}
}