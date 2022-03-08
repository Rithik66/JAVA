import java.util.*;
public class IndexDifference {
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    String s = scanner.nextLine();
	    ArrayList<Character> alpha = new ArrayList<>();
	    ArrayList<Character> digit = new ArrayList<>();
	    for(int i=0;i<s.length();i++){
	        char c = s.charAt(i);
	        if(c>=48 && c<=57) digit.add(c);
	        else if(c>=97 && c<=122) alpha.add(c);
	    }
	    if(digit.size()==0 || alpha.size()==0){
	        System.out.println(-1);
	        return;
	    }
	    ArrayList<Character> alphas = new ArrayList<>(alpha);
	    ArrayList<Character> digits = new ArrayList<>(digit);
	    Collections.sort(alphas);
	    Collections.sort(digits);
	    int x=s.indexOf(alphas.get(0));
	    int y=s.indexOf(alphas.get(alphas.size()-1));
	    String ans = "";
	    for(int i=0;i<alphas.size();i++){
	        ans+=alphas.get(i);
	    }
	    ans+=(Math.abs(x-y))+":";
	    int sum=0;
	    for(int i=0;i<digits.size();i++){
	        sum+=(digits.get(i)-48);
	    }
	    ans+=sum;
	    x=s.indexOf(digits.get(0));
	    y=s.indexOf(digits.get(digits.size()-1));
	    ans+=(Math.abs(x-y));
	    System.out.println(ans);
	}
}