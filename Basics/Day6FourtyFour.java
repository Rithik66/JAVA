package Javatraining;

import java.util.*;

public class Day6FourtyFour {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		String a = "",newS="";
		ArrayList<String> al = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				
			}
		}
		System.out.println(al);
		String max="";
		for(String ans:al) {
			if(ans.length()>max.length()) max=ans;
		}
		System.out.println(max);
	}
}
