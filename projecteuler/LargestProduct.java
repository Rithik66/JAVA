package projecteuler;
import java.util.Arrays;
import java.util.Scanner;
public class LargestProduct {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		String s=sc.nextLine();
		long k=0,l=13,ans=1,n1,n2,n3,n4,n5,n6,n7,n8,n9,n10,n11,n12,n13;
		long Max_Num=0;
		String[] result=new String[1000];
		result=s.split("");
		for(int i=0;i<=987;i++) {
			n1=Integer.parseInt(result[i]);
			n2=Integer.parseInt(result[i+1]);
			n3=Integer.parseInt(result[i+2]);
			n4=Integer.parseInt(result[i+3]);
			n5=Integer.parseInt(result[i+4]);
			n6=Integer.parseInt(result[i+5]);
			n7=Integer.parseInt(result[i+6]);
			n8=Integer.parseInt(result[i+7]);
			n9=Integer.parseInt(result[i+8]);
			n10=Integer.parseInt(result[i+9]);
			n11=Integer.parseInt(result[i+10]);
			n12=Integer.parseInt(result[i+11]);
			n13=Integer.parseInt(result[i+12]);
			ans=n1*n2*n3*n4*n5*n6*n7*n8*n9*n10*n11*n12*n13;
			Max_Num=Math.max(Max_Num, ans);
			}
		System.out.println(Max_Num);
	}
}