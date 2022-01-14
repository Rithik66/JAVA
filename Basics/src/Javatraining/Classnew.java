package Javatraining;

import java.util.Scanner;

public class Classnew {
	String s,l;
	Classnew(String s){
		this.s=s;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		scanner.nextLine();
		Classnew[] c = new Classnew[a];
		for(int i=0;i<a;i++) {
			c[i]=new Classnew(scanner.nextLine());
		}
		String name=scanner.nextLine();
		Main45 m = new Main45();
		m.deleteAll(name,c);
	}
}
class Main45{
	void deleteAll(String name,Classnew[] cie){
		for(Classnew ci:cie) {
			if(ci.s.equals(name)) System.out.println("yes");
		}
	}
}
