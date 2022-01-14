import java.util.*;
public class countOfNumber {
     public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int [][] ar = new int[n][n];

        int count =0;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                ar[i][j]=sc.nextInt();

                if(ar[i][j]<=10)
                {
                   count++;
                }
            }
        }

      System.out.println(count);
    }
}
