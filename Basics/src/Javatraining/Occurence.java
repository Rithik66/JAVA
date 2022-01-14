package Javatraining;

import java.util.*;;

public class Occurence {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		char c=0;
		ArrayList arr = new ArrayList();
		ArrayList ar = new ArrayList();
		for (int i = 0; i < s.length(); i++) {
			arr.add(s.charAt(i));
		}
		int count=1;
		label:for (int i = 0; i < s.length(); i++) {
			c=s.charAt(i);
			ar.add(c);
			for (int j = 0; j < arr.size(); j++) {
				if(c==s.charAt(j)) {
					arr.removeAll(ar);
					break label;
				}
			}
		}
		int dif=Math.abs(arr.size()-s.length());
		if(dif==arr.size()) System.out.println("Yes");
		else System.out.println("No");
	}
}
