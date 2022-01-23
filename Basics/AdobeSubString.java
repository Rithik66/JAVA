package Javatraining;
import java.util.*;
public class AdobeSubString {
	static ArrayList<String> ar = new ArrayList<String>();
	static ArrayList<String> ar1 = new ArrayList<String>();
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		printSubSeq(s,"");
		String max="";
		int size=0,k=0,index=0;
		for(int i=0;i<ar.size();i++) {
			String check = reverse(ar.get(i));
			if(ar.get(i).equals(check)) {
				ar1.add(check);
			}
		}
		String temp="";
		int res=0,size1=0,count=0;
		for(int i=0;i<ar1.size();i++) {
			size1=ar1.get(i).length();
			if(size1>=res) {
				res=size1;
				count=i;
			}
		}
		System.out.println(ar1.get(count));
	}
	public static void printSubSeq(String s,String ans) {
		if(s.length()==0){
			ar.add(ans);
			return;
		}
		char c = s.charAt(0);
		String ss = s.substring(1);
		printSubSeq(ss,ans+c);
		printSubSeq(ss,ans+"");
	}
	public static String reverse(String s) {
		String res="";
		if(s.length()!=0) {
		for(int i=s.length()-1;i>=0;i--) {
			char c=s.charAt(i);
			res += c;
		}
		}
		return res;
		
	}
}
