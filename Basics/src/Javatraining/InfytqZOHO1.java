package Javatraining;
import java.util.*;

public class InfytqZOHO1{
	static InfytqZOHO1 iz = new InfytqZOHO1();
	int gen(int n){
		if(n==0) return 0;
		else if(n==1) return 1;
		else return (4*gen(n/2))+(n%2);
	}
	void moser(int n){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int flag=0,index=0;
		for (int i = 0; i < n; i++) {
			if(n==iz.gen(i)) {
				flag=1;
				index=i;
			}
			arr.add(iz.gen(i));
		}
		if(flag==1)System.out.println("Found at "+index);
		else System.out.println("NotFound");
	}
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		iz.moser(n);
	}
}
