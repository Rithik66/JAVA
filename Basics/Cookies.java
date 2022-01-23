package Javatraining;

import java.util.*;

public class Cookies {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		scanner.nextLine();
		String[] s=scanner.nextLine().split(" ");
		int flag=0;
		if(s[s.length-1].equals("cookies")) System.out.println("NO");
		else {
			for(int i=0;i<a-1;i++) {
				if(s[i].equals("cookies"))
					if(s[i+1].equals("juice")) flag=1;
			}
			if(flag==1)System.out.println("YES");
			else System.out.println("NO");
		}
	}
}