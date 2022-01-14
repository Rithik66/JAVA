package Javatraining;
import java.util.*;
public class MaxChar{
	public static void main(String[]args){
		Scanner in = new Scanner(System. in);
	      String s = in.nextLine();
	        int[] ar = new int[256];
	        int n = s.length();
	        for (int i = 0; i < n; i++){
	            ar[s.charAt(i)]++;
	        }
	        int max_count = 0;
	        char ans='a';
	        for (int i = 0; i < 256; i++){
	            if (ar[i] > max_count){
	                max_count = ar[i];
	                ans = (char)i;
	            }
	        }
	    System.out.println(+ans);
    }
}