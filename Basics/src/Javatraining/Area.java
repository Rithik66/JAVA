package Javatraining;

import java.util.Scanner;

public class Area {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int arr[] = new int[a];
		int area=1;
		boolean lorR=false;
		boolean torB=false;
		for(int i=0;i<a;i++) {
			arr[i]=scanner.nextInt();
		}
		int k[] = new int[50];
		for(int i=0;i<a;i++) {
			k[arr[i]]+=1;
		}
		for(int i=k.length-1;i>=0;i--) {
			if(!lorR) {
				if(k[i]>=2) {
					area*=i;
					lorR=true;
					k[i]-=2;
				}
			}
			if(lorR) {
				if(k[i]>=2) {
					area*=i;
					torB=true;
					break;
				}
			}
		}
		if(torB) System.out.println(area);
		else System.out.println(-1);
	}
}
