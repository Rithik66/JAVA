
/*
1111111
1222221
1233321
1234321
1233321
1222221
1111111



1   11111   1
12   222   21
123	  3   321

1234      321

123	  3   321
12   222   21
1   11111   1


*/
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        //a=a%2==0?a:a-1;
        int t=a%2==0?a:a-1,k=1;
        t=t+(t-1);
        for(int i=0;i<a-1;i++){
            for(int j=0;j<=i;j++){
                System.out.print(j+1);
            }
            for(int j=0;j<t;j++){
                System.out.print(k);
            }
            k++;
            t-=2;
            int l=i+1,g=a;
            for(int j=0;j<=i;j++){
                System.out.print(l);
                l--;
            }
            System.out.println();
        }
        for(int i=0;i<a;i++){
            System.out.print(i+1);
        }
        for(int i=a-1;i>0;i--){
            System.out.print(i);
        }
        System.out.println();
        t=1;k=a-1;
        for(int i=0;i<a-1;i++){
            for(int j=0;j<=a-2-i;j++){
                System.out.print(j+1);
            }
            for(int j=0;j<t;j++){
                System.out.print(k);
            }
            k--;
            t+=2;
            int l=a-1-i,g=a;
            for(int j=0;j<a-1-i;j++){
                System.out.print(l);
                l--;
            }
            System.out.println();
        }
    }
}