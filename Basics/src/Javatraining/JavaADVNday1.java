package Javatraining;

import java.util.*;

public class JavaADVNday1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int arr[] =new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=scanner.nextInt();
		}
		subSet(sort(arr));
		scanner.close();
	}
	public static int[] sort(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					arr[i]=arr[i]+arr[j];
					arr[j]=arr[i]-arr[j];
					arr[i]=arr[i]-arr[j];
				}
			}
		}
		return arr;
	}
	/*public static void reverseAt(String s,int st,int en){
		char[] c = s.toCharArray();
		char[] temp=new char[en-st+1];
		int ind=0;
		for(int i=en;i>=st;i--) {
			temp[ind]=c[i];
			ind++;
		}
		ind=0;
		for(int i=st;i<=en;i++) {
			c[i]=temp[ind];
			ind++;
		}
		System.out.println(Arrays.toString(c));
	}
	public static void replaceString(String s,String rep,int start) {//*****
		List<Character> res = new ArrayList<Character>();
		char[] c = s.toCharArray();
		for(int i=0;i<s.length();i++) {
			res.add(c[i]);
		}
		System.out.println(res);
	}*/
	public static int sum(ArrayList<String> ans) {
		List<List<String>> res = new ArrayList<List<String>>();
		int sum=0;
		for(int i=0;i<ans.size();i++) {
			sum+=Integer.parseInt(ans.get(i));
		}
		if(sum<=10) {
			res.add(ans);
		}
		int max=0;
		for(int i=0;i<res.size();i++) {
			System.out.println(res.get(i));
			if(max<res.get(i).size()) max=res.get(i).size();
		}
		return max;
	}
	static void subSet(int[]arr) {
		ArrayList<String> ans = new ArrayList<String>();
		int r=0,l=(int)Math.pow(2,arr.length);
		String set="";
		int max=0,kl=0;
		for(int i=0;i<l;i++) {
			set="";
			int temp=i;
			for(int j=0;j<arr.length;j++){
				r=temp%2;
				temp/=2;
				if(r==0) {
					set="";
					if(!set.equals(""))
					ans.add(set);
				}
				else {
					set=arr[j]+"";
					ans.add(set);
				}
			}
			kl=sum(ans);
			if(max<kl)max=kl;
			ans.clear();
		}
		System.out.println(max);
	}
}
