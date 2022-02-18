/*
-----------------------------------------------------------------------------------------------------------
Problem Statement
-----------------------------------------------------------------------------------------------------------
Consider a positive number innum. Identify and print the number outnum based on the below
logic
    • Find all the possible sub sequences without leading 0’s of the innum which form prime
    numbers
        (Subsequence: A subsequence of a number num is the possible set of digits
        formed from num starting from left to right)
    • Assign the highest identified subsequence to outnum
    • If there exists no such subsequence print -1.

Note: 0 and 1 are not prime numbers
-----------------------------------------------------------------------------------------------------------
Input format
Read the innum from the standard input stream.
-----------------------------------------------------------------------------------------------------------
Output format
Print the outnum to the standard output stream.
-----------------------------------------------------------------------------------------------------------
Sample Input 1:
50678

Sample Output 1:
67

Explanation 1:
For the given innum i.e. 50678 the sub sequences without leading 0’s formed are 5, 
50, 506,5067, 50678, 5068, 507, 5078, 508, 56, 567, 5678, 568, 57,578, 58, 6, 67, 678, 
68, 7, 78 and 8. Among these 5, 7 and 67 are prime numbers. Hence 67 is the highest 
prime number. Hence the output.
-----------------------------------------------------------------------------------------------------------
Sample Input 2:
140

Sample Output 2:
-1

Explanation 2:
For the given innum, i.e. 140 the subsequence formed are 1, 14, 140, 10, 4, 40 and 0. 
None of the sub sequences are prime numbers. Hence the output is -1
-----------------------------------------------------------------------------------------------------------
*/

import java.util.*;
class PrimeSubstring{
    static List<String> li = new ArrayList<>(); 
    static List<Integer> ans = new ArrayList<>();
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        subsequence(s);
        Collections.sort(ans);
        if(ans.size()==0) System.out.println(-1);
        else System.out.println(ans.get(ans.size()-1));
    }
    public static void subsequence(String s){
        int n=s.length();
        int limit=(int)Math.pow(2,n);
        for(int i=1;i<limit;i++){
            int temp=i;
            String str="";
            for(int j=0;j<n;j++){
                int res=temp%2;
                temp/=2;
                if(res==1) str+=s.charAt(j);
            }
            int k=Integer.parseInt(str);
            if(checkPrime(k)) ans.add(k);
        }
    }
    public static boolean checkPrime(int a){
            if(a==0 || a==1) return false;
			int i=2;
			while(i<a){      
				if(a%i==0) {
					return false;
				}
				i++;			   
			}
			return true;
		}
}