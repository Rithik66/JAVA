package Javatraining;

import java.util.*;

public class Permutations {
	static ArrayList<String> ar= new ArrayList<>();
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        permutation(s,"");
        System.out.println(ar);
        scanner.close();
	}
	private static void permutation(String s,String bl) {
		if(s.length()==0){
			ar.add(bl);
			return;
		}
		for(int i = 0;i<s.length();i++){
			char c=s.charAt(i);
			String lftprt = s.substring(0,i);
			String rghtprt = s.substring(i+1);
			String total = lftprt+rghtprt;
			permutation(total,bl+c);	
		}
	}
}
