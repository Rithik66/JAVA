package Javatraining;
import java.util.*;
public class Bob {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int ar[] = new int[a];
		ArrayList<Integer> k = new ArrayList<Integer>();
		for(int i=0;i<a;i++) {
			ar[i]=scanner.nextInt();
		}
		Arrays.sort(ar);
		int count=0,j=0;
		for(int i=0;i<a-1;i++) {
			if(ar[i]==ar[i+1] && count==0) {
			k.add(ar[i]);
			j++;
			count++;
			}
			else if(ar[i]!=ar[i+1])count=0;
		}
		ArrayList<Integer> pro = new ArrayList<Integer>();
		int max=0;
		for (int i=0;i<k.size()-1;i++) {
			pro.add(k.get(i)*k.get(i+1));
			if(pro.get(i)>max)max=pro.get(i);
		}
		if(pro.isEmpty()) System.out.println(-1);
		else System.out.println(max);
	}
}