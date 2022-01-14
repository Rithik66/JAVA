package Javatraining;
import java.util.Scanner;
public class Dragon{
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int arr[] = new int[a];
        for (int i = 0; i < a; i++) {
			arr[i]=scanner.nextInt();
		}
        int min=0;
        for(int i=1;i<a;i++) {
        	if(arr[i]<min) min=arr[i];
        }
        System.out.println(min);
    }
}