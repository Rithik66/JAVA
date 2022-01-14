package Javatraining;

import java.util.Scanner;;
public class plane{
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        if(a>0){
            int ar[] = new int[a];
            int sum=0,count=0;
            for(int i=0;i<a;i++){
                ar[i]=scanner.nextInt();
            }
            label:for(int i=0;i<a;i++){
                if(ar[i]<0){
                    System.out.println("Invalid Input");
                    count=1;
                    break label;
                }else sum=sum+ar[i];
            }
            for(int i=0;i<a;i++){
                    if(count!=1) System.out.print(ar[i]+" ");
            }
            System.out.println();
            if(count!=1)
            System.out.println(sum);
        }
        else System.out.println("Invalid Input");
    }
}
