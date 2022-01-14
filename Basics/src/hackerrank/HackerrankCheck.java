package hackerrank;

import java.util.*;

public class HackerrankCheck {
	public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(hackerrankInString(s));
	}
	public static String hackerrankInString(String s) {
	    // Write your code here
	        ArrayList<Character> ch = new ArrayList<Character>();
	        for(int i=0;i<s.length();i++){
	            ch.add(s.charAt(i));
	        }
	        ArrayList<Character> hc = new ArrayList<Character>();
	        hc.add('h');
	        hc.add('a');
	        hc.add('c');
	        hc.add('k');
	        hc.add('e');
	        hc.add('r');
	        hc.add('r');
	        hc.add('a');
	        hc.add('n');
	        hc.add('k');
	        if(ch.containsAll(hc))return "YES";
	        else return "NO"; 
	}
}