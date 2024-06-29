//	TAKE 2 NUMBER
//	12, 24 

// 	LOGIC:
//	1.  Find the small number (12)
//	2.  should divide both numbers from 1 to small number (12)
//		so divide 12 and 24 with (1,2,3,4,5,6,7,8,9,10,11,12)
//		if both are divisible store and find the largest divisible number.



package Javatraining;
import java.util.Scanner;

public class FuncGcd {
	static int findValue(int x,int y) {
		int small=0,ans=0;
		if(x<y) small=x;
		else small=y;
		for(int i=1;i<=small;i++) {
			if(x%i==0 && y%i==0) ans=i;
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int ans=findValue(a, b);
		System.out.println(ans);
	}
}
