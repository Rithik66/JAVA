/*
-----------------------------------------------------------------------------------------------------------
Problem Statement
-----------------------------------------------------------------------------------------------------------
Consider two non-empty positive integer arrays inarr1 and inarr2 as inputs. Identify and print 
a 2 x m matrix outmatrix based on the logic given below:
    • Search common integers between inarr1 and inarr2.
    • Select the smallest integer, m, among the common integers. If the smallest integer is 
    not a single digit number, then consecutively add its digits until a single digit, m, is 
    obtained.
    • Based on the single digit, m, obtained from above, pick those many largest elements 
    each from inarr1 and inarr2.
    • Form outmatrix, in which first row will contain m largest elements selected from inarr1 
    and second row will contain m largest elements selected from inarr2. Each row must 
    contain elements in ascending order.
    • If no common integer exists or smallest common integer value is zero or larger than 
    any of the input array size print output as -1
-----------------------------------------------------------------------------------------------------------
Input Format
-----------------------------------------------------------------------------------------------------------
Read the inarr1 from line 1 with array elements separated by (,) comma.
Read the inarr2 from line 2 with array elements separated by (.) comma.
Read the input from the standard input stream
-----------------------------------------------------------------------------------------------------------
Output format:
-----------------------------------------------------------------------------------------------------------
Print outmatrix, with each row in newline and row elements are separated by (,) comma, or -1 accordingly.
Print the output to the standard output stream.
-----------------------------------------------------------------------------------------------------------
Sample Input 1:
0,17,61,65,90
5,0,1,4,100

Sample Output 1:
-1

Explanation 1:
For the given inputs inarr1 is [0,17,61,65,90] and inarr2 is [5,0,1,4,100].
    • Smallest common integer is zero.
    Output is "-1".
-----------------------------------------------------------------------------------------------------------
Sample Input 2:
101,101,610,447,389
610,4,101,4,101

Sample Output 2:
447,610
101,610

Explanation 2:
For the given inputs inar1 is [101,101,610,4 47,389] and inarr2 is [610,4,101,4,101] • Common integers between inarr1 and inam2 are 101, 610.
    • Smallest common integer is 101 which is not in single digit Sum of all the digits of 101 
    is 1+0+1=2 i.e. m=2
    • Select two largest elements from inarr1 as "447,610" and from inarr2 "101,610" in 
    ascending order.
    • Adding the selected largest elements of inarr1 as first row and the selected largest 
    elements of inarr2 as second row, 
    • outmatrix is 
    447,610
    101,610
*/

import java.util.*;
public class MLargestNumber{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int[] ar1 = new int[a];
        for(int i=0;i<a;i++){
            ar1[i]=scanner.nextInt();
        }
        int b = scanner.nextInt();
        int[] ar2 = new int[b];
        for(int i=0;i<b;i++){
            ar2[i]=scanner.nextInt();
        }
        ArrayList<Integer> com = new ArrayList<>();
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                if(ar1[i]==ar2[j] && ar2[j]>=0){
                    if(!com.contains(ar1[i]))com.add(ar1[i]);
                    break;
                }
            }
        }
        Collections.sort(com);
        //System.out.println(com);
        int m=com.get(0);
        //System.out.println(m);
        if(String.valueOf(m).length()>1)
        m=check(m);
        //System.out.println(m);
        //ArrayList<ArrayList<Integer>> fin = new ArrayList<>();
        int temp=m;
        Arrays.sort(ar1);
        Arrays.sort(ar2);
        ArrayList<Integer> row1 = new ArrayList<>();
        for(int i=a-1;i>=0 && m>0;i--){
            if(!row1.contains(ar1[i]))row1.add(ar1[i]);
            if(row1.size()==m) break;
        }
        ArrayList<Integer> row2 = new ArrayList<>();
        for(int i=b-1;i>=0 && m>0;i--){
            if(!row2.contains(ar2[i]))row2.add(ar2[i]);
            if(row2.size()==m) break;
        }
        Collections.sort(row1);
        Collections.sort(row2);
        if(row1.size()==0 && row2.size()==0) System.out.println(-1);
        System.out.println(row1+"\n"+row2);
    }
    public static int check(int m){
        int temp=m;
        int len=String.valueOf(m).length();
        if(len==1) return m;
        int sum=0;
        while(m>0){
            sum+=m%10;
            m/=10;
        }
        m=sum;
        if(String.valueOf(m).length()>1) check(m);
        return m;
    }
}