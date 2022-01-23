package Javatraining;
import java.util.Scanner;
public class JavaADVNday3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Cricket[] st = new Cricket[n];
		for (int i = 0; i < n; i++){
			st[i]=new Cricket(scanner.next(),scanner.nextInt(),scanner.next());
		}
		Cricket temp = new Cricket();
		for (int i = 0; i < n-1; i++) {
			for(int j=i+1;j<n;j++) {
				if(st[i].score>st[j].score){
					temp=st[j];
					st[j]=st[i];
					st[i]=temp;
				}
				else if(st[i].score==st[j].score && st[i].name.compareTo(st[j].name)>0){
					temp=st[j];
					st[j]=st[i];
					st[i]=temp;
				}
				else if(st[i].name.equals(st[j].name) && st[i].opp.compareTo(st[j].opp)>0){
					temp=st[j];
					st[j]=st[i];
					st[i]=temp;
				}
			}
		}
		for (int i = 0; i < n; i++){
			st[i].get();
		}
	}
}
class Cricket{
	String name,opp;
	int score;
	Cricket(){}
	Cricket(String name,int score,String opp){
		this.name=name;
		this.score=score;
		this.opp=opp;
	}
	void get(){
		System.out.println(name+" "+score+" "+opp);
	}
}
