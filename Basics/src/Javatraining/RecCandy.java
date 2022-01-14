package Javatraining;
import java.util.Scanner;
public class RecCandy{
	static int fact[]={1, 1, 2, 6, 4, 2, 2, 4, 2, 8};
	static int print(int x){
		int a,b=0,ans=0;
		if(x>9){
		a=(int)Math.pow(2, x/5);
		for (int i=10;i<1000*1000;i*=10){
			if(a%i!=0) {a=a%i;break;}
		}
		if(x%2==0) b=print(x/5);
		else if(x%2!=0) b=print(x/5)*print(x%5);
		ans=a*b;
		return ans%10;
		}else if(x<9 && x>1) {
			ans=fact[x];
			return ans;
		}else return 1;
	}
	public static void main (String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	int n = scanner.nextInt();
        System.out.println(print(n));
    }
}
