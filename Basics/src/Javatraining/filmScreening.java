import java.util.*;
class filmScreening
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int m = sc.nextInt();
        
        int [][] ar = new int[n][m];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                ar[i][j]=sc.nextInt();
            }
        }
        
        int count=0;
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n-1;j++)
            {
                for(int k=j+1;k<n;k++)
                {
                    if(ar[j][i]== 1 && ar[k][i]==1)
                    {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}


