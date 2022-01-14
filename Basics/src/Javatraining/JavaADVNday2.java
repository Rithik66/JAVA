package Javatraining;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaADVNday2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		stairCase(n);
		scanner.close();
	}
	static void stairCase(int n) {
		String[] arr = new String[n+1];
		for(int i=0;i<=n;i++) {
			arr[i]=i+"";
		}
		binary(arr);
	}
	static List<String> binary(String[] arr) {
		ArrayList<String> res = new ArrayList<String>();
		ArrayList<String> ans = new ArrayList<String>();
		int r=0,l=(int)Math.pow(2,arr.length);
		String set="";
		for(int i=0;i<l;i++){
			set="";
			int temp=i;
			for(int j=0;j<arr.length;j++){
				r=temp%2;
				temp/=2;
				if(r==0){
					set+="0";
				}
				else set+="1";
			}
			int flag=0;
			String str="";
			if(set.charAt(0)=='0' && set.charAt(set.length()-1)=='0'){
				str=set.substring(1,set.length()-1);
				for (int k = 0; k<str.length()-1; k++){
					if(str.charAt(k)=='1' && str.charAt(k+1)=='1'){
						flag=1;
						break;
					}
				}
				if(flag!=1) res.add(set);
			}
		}
		int count=0;
		for(int i=0;i<res.size();i++){
			for(int p=0;p<res.get(i).length();p++){
				if(res.get(i).charAt(p)=='0') ans.add(String.valueOf(arr[p]));
			}
			System.out.println(ans);
			ans.clear();
			count++;
		}
		System.out.println(count);
		return ans;
	}
}
