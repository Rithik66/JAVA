package Javatraining;

import java.util.*;

public class FactorsTimeComplexity{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		factor(n);
	}
	static void factor(int n){
		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans.add(1);
		ans.add(n);
		int flag=0;
		for(int i=2;i<=Math.ceil(Math.sqrt(n));i++){
			if(n%i==0){
				ans.add(i);
				if(i!=n/i) ans.add(n/i);
				flag=1;
			}
		}
		Collections.sort(ans);
		int index=0;
		int arr[] = new int[ans.size()];
		for(int i=0;i<ans.size();i++) {
			if(ans.get(i)!=ans.get(i+1))arr[i]=ans.get(index);
		}
		if(flag==0 && n!=0 && n!=1)System.out.println("Prime");
		else System.out.println("Not a Prime");
		System.out.println(ans);
	}
}