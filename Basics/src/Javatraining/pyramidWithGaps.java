package Javatraining;

import java.util.Scanner;
public class pyramidWithGaps{
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int t=a-1;
        for(int i=0;i<a;i++){
            for(int j=(a-i)+t-1;j>0;j--){
                System.out.print(" ");
            }
            System.out.print("*");
            for(int j=0;j<i;j++){
                System.out.print("   ");
                System.out.print("*");
            }
            for(int j=(a-i)+t-1;j>0;j--){
                System.out.print(" ");
            }
            System.out.println();
            t--;
        }
    }
}
