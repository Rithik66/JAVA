package Javatraining;

import java.util.Scanner;

public class InfytqPROB1{
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        scanner.nextLine();
        String s1 = scanner.nextLine();
        char[] c = s1.toCharArray();
        String s2 = scanner.nextLine();
        String s3="";
        int count=0;
        char temp=0;
        for(int i=0;i<a;i++){
          temp=c[0];
          s3="";
          int j=0;
          for(j=1;j<a;j++){
            s3+=c[j];
          }
          s3+=temp;
          count++;
          c = s3.toCharArray();
          if(s3.equals(s2)) break;
        }
        System.out.println(count);
    }
}