package hackerrank;

public class Loop2 {
	public static void loop2(int a,int b,int n) {
		int k=0,l=0;
		while(l<n){
			if(l==0) 
				k=k+(int)(a+(Math.pow(2,l)*b));
			else
				k=k+(int)(Math.pow(2,l)*b);
			l++;
			System.out.print(k+" ");
		}
	}
}
