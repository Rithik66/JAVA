package Javatraining;
import java.util.*;
public class VMS {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		int[] a1 = new int[a];
		for(int i=1;i<=a;i++) {
			a1[i-1]=i;
		}int[] b1 = new int[b];
		for(int i=0;i<b;i++) {
			b1[i]=scanner.nextInt();
		}int[] c1 = new int[c];
		for(int i=0;i<c;i++) {
			c1[i]=scanner.nextInt();
		}int j=0,flag=0,count=0;
		for (int i = 0; i < b1.length; i++){
			for (j = 0; j < c1.length; j++){
				if(c1[j] == b1[i]) {
					count++;break;
				}
			}if (j==c1.length) flag=1;
		}System.out.print(count+" ");
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> ar = new ArrayList<Integer>();
		for(int i=0;i<b1.length;i++) {
			arr.add(b1[i]);
		}for(int i=0;i<c1.length;i++) {
			arr.add(c1[i]);
		}Collections.sort(arr);
		int index=0;
		for(int i=0;i<arr.size()-1;i++) {
			if(arr.get(i)!=arr.get(i+1)) {
				ar.add(arr.get(i));
			}
		}
		ar.add(arr.get(arr.size()-1));
		System.out.print(a1.length-ar.size());
	}
}
