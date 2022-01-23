package Javatraining;
import java.util.Scanner;
public class Film {
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int[]aArr = new int[a];								//first array
		for (int i = 0; i < a; i++) {
			aArr[i]=scanner.nextInt();
		}
		int[]bArr = new int[a];								//second array
		for (int i = 0; i < a; i++) {
			bArr[i]=scanner.nextInt();
		}
		scanner.close();
		int[]newArr = new int[a];							//LiRi array
		for (int i = 0; i < a; i++) {
			newArr[i]=aArr[i]*bArr[i];
		}
		int[] com=new int[a];								//duplicate elements array
		for (int i = 0; i < a; i++) {
			for (int j = i+1; i < a; i++) {
				if(newArr[i]==newArr[j]) {
					com[i]=newArr[i];
				}
			}
		}
		int k=newArr[0];int index=0;						//LiRi_Max
		for (int i = 1; i < a; i++) {
			if(newArr[i]>k) {k=newArr[i];index=i;}
		}
		int l=bArr[0];										//second array Max
		for (int i = 1; i < a; i++) {
			if(bArr[i]>l) {l=bArr[i];}
		}
		int maxnum=0;
		for (int i = 0; i < a; i++) {
			if(k==com[i]) {
				maxnum=Math.max(maxnum, bArr[i]);
			}else {
				System.out.println(index+1);
				break;
			}
		}
		for (int i = 0; i < a; i++) {
			if(k==com[i]) {
				if(maxnum==bArr[i]) {System.out.println(i+1);
				break;
				}
			}
		}
	}
}
