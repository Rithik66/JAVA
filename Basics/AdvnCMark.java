package Javatraining;

import java.util.Scanner;

public class AdvnCMark {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		Mark[] m = new Mark[a];
		for (int i = 0; i < a; i++) {
			m[i]=new Mark(scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
		}
		Mark l = new Mark();
		l.sum(m);
	}
}
class Mark{
	int r,p,c,m;
	Mark(){}
	Mark(int r,int p,int c,int m){
		this.r=r;
		this.p=p;
		this.c=c;
		this.m=m;
	}
	void check(Mark[] m) {
		int maxp=0;
		int maxc=0;
		int maxm=0;
		for(Mark mi:m) {
			if(maxp<mi.p) maxp=mi.p;
			if(maxc<mi.c) maxc=mi.c;
			if(maxm<mi.m) maxm=mi.m;
		}
		maxCheck(m,maxp,maxc,maxm);
	}
	void maxCheck(Mark[] m, int mp,int mc,int mm) {
		int count1=0,count2=0,count3=0;
		for(Mark mi:m) {
			if(mi.p==mp && count1==0) {
				System.out.println(mi.r+" "+mp);
				count1++;
			}
			if(mi.c==mc && count2==0) {
				System.out.println(mi.r+" "+mc);
				count2++;
			}
			if(mi.m==mm && count3==0) {
				System.out.println(mi.r+" "+mm);
				count3++;
			}
		}
	}
	void sum(Mark[] m) {
		int sum=0,max=0,roll=0;;
		for(Mark mi:m) {
			sum=mi.p+mi.c+mi.m;
			System.out.println(sum);
			if(max<sum) {
				max=sum;
				roll=mi.r;
			}
		}
		check(m);
		System.out.println(roll+" "+max);
	}
}
