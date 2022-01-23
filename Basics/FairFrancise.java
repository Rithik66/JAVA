package Javatraining;
import java.util.Arrays;
import java.util.Scanner;
public class FairFrancise{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int sum=0,del,answer=0;
		int ar[] = new int[a];
		for(int i=0;i<a;i++){
			ar[i]=scanner.nextInt();
			sum+=ar[i];
		}
		del = sum%a;
		System.out.print(del+" ");
		sum=sum-del;
		int ans=sum/a;
		int [] temp=new int[a];
		for(int i=0;i<a;i++){
				temp[i]=ans;
		}
		int res=0,finalres=0;
		for(int i=0;i<a;i++){
			res=ar[i]-temp[i];
			if(res>0) finalres+=res;
		}
		answer=finalres-del;
		System.out.print(answer);
	}
}