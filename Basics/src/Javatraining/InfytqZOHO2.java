package Javatraining;

import java.util.*;

public class InfytqZOHO2 {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 1; i <= n; i++) {
			arr.add(i);
		}
		loop(arr,0);
	}
	static void loop(ArrayList<Integer> arr,int count) {
		ArrayList<Integer> zeros = new ArrayList<Integer>();
		zeros.add(0);
		arr.removeAll(zeros);
		if(arr.size()==1) {
			System.out.println(arr.get(0));
			return;
		}
		for (int i = 0; i < arr.size(); i++) {
			if(count==0) {
				count+=1;/*
				System.out.println(arr);
				System.out.println(count);
				System.out.println(i);*/
				}
			else if(count==1) {
				arr.set(i,0);
				//System.out.println(arr);				
				count-=1;
				/*System.out.println(count);
				System.out.println(i);*/
			}
		}
		loop(arr,count);
	}
}
