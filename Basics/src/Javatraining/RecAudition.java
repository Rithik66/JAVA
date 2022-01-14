package Javatraining;

import java.util.*;

public class RecAudition {
	ArrayList<Integer> arr = new ArrayList<Integer>();
	ArrayList<Integer> temp = new ArrayList<Integer>();
	int l=0;
	int findPos(int x) {
		int count=0,ans = 0;
		//System.out.println(arr);
		//System.out.println(l);
		if(l==0) {
		for (int i = 1; i<=x; i++) {
			if(i%2==0) arr.add(i);
		}
		//System.out.println(arr);
		count=arr.size();
		}
		else {
		for (int i = 1; i <=arr.size(); i++) {
			if(i%2==0) { temp.add(arr.get(i-1));
		//	System.out.println(temp);
			}
		}
		count=temp.size();
		arr.clear();
		for (int i = 0; i <temp.size(); i++) {
			arr.add(temp.get(i));
		}
		//System.out.println(temp);
		temp.clear();
		}
		l++;
		//System.out.println(arr.size());
		if(arr.size()>1) {
			findPos(count);
			ans=arr.get(0);
			}
		return ans;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		RecAudition n = new RecAudition();
		System.out.println(n.findPos(a));
	}
}
