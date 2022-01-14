package Javatraining;

import java.util.Scanner;
import java.util.Stack;

public class StackParantesis {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String a = scanner.nextLine();
		boolean check=checkParenthesis(a);
		if(check) System.out.println("Blanaced");
		else System.out.println("Not Balanced");
	}
	static boolean checkParenthesis(String a) {
		int l = a.length();
		Stack<Character> st = new Stack<Character>();
		for(int i=0;i<l;i++) {
			char c=a.charAt(i);
			if(c=='{' || c=='(' || c=='[') {
				st.push(c);
			}
			else if(c=='}' || c==')' || c==']') {
				if(st.isEmpty()) {
					return false;
				}
				else {
					if(st.peek()=='{' && c=='}') {
						st.pop();
					}
					else if(st.peek()=='[' && c==']') {
						st.pop();
					}
					else if(st.peek()=='(' && c==')') {
						st.pop();
					}
				}
			}
		}
		return st.empty();
	}
}