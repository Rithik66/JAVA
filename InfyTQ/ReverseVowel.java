// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Scanner;

// public class Main {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         String s = scanner.nextLine();
//         char c[] = s.toCharArray();
//         ArrayList<Integer> index = new ArrayList<>();//1 4 6 
//         for(int i=0;i<s.length();i++){
//             if(c[i]=='a' || c[i]=='e' || c[i]=='i' || c[i]=='o' || c[i]=='u'){
//                 index.add(i);
//             }
//         }
//         //hollo werld   k=e
//         char k=c[index.get(0)];//e
//         for(int i=0;i<index.size()-1;i++){
//             c[index.get(i)]=c[index.get(i+1)];
//         }
//         c[index.get(index.size()-1)]=k;
//         String str=new String(c);
//         System.out.println(str);
//     }
// }
/*
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int[] arr = new int[a];
        for (int i=0;i<a;i++) {
            arr[i]=scanner.nextInt();
        }
        int flag=0;
        for(int i=0;i<a-1;i++){
            int ans1=avg(0,i,arr);
            int ans2=avg(i+1,a,arr);
            if(ans1==ans2) flag=1;
        }
        if(flag==1) System.out.println("True");
        else System.out.println("False");
    }
    public static int avg(int k,int l,int[] arr){
        int sum1=0;
        int size=0;
        for(int i=k;i<l;i++){
            size++;
            sum1+=arr[i];
        }
        if(size!=0 && sum1/size!=0) return sum1/size;
        return 0;
    }
}

*/