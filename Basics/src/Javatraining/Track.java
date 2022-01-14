package Javatraining;

import java.util.ArrayList;
import java.util.Scanner;

public class Track {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		ArrayList<Integer> arrN=new ArrayList<Integer>();
		ArrayList<Integer> arrM=new ArrayList<Integer>();
		ArrayList<Integer> arrK=new ArrayList<Integer>();
		ArrayList<Integer> temp=arrN;
		ArrayList<Integer> temp1=new ArrayList<Integer>();
		for(int i =0;i<a;i++) {
			arrN.add(i+1);
		}
		for(int i =0;i<b;i++) {
			int j=scanner.nextInt();
			arrM.add(j);
		}
		for(int i =0;i<c;i++) {
			int j=scanner.nextInt();
			arrK.add(j);
		}
		scanner.close();
		for(int i=0;i<temp.size();i++) {
			for(int j=0;j<arrM.size();j++) {
				for(int k=0;k<arrK.size();k++) {
					if(temp.get(i)==arrM.get(j) && temp.get(i)==arrK.get(k)) 
						temp1.add(temp.get(i));
				}
			}
		}
		System.out.println(temp1.size());
		arrN.removeAll(arrM);
		arrN.removeAll(arrK);
		System.out.println(arrN.size());
	}
}