import java.util.*;
class Sample{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int [][] ar = new int[n][n];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
               ar[i][j] = sc.nextInt();
            }
        }
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                
                if(ar[i][j]==1)
                {
                    if(i==0 && j==0)
                    {
                     ar[i][j+1]=0;
                     ar[i+1][j]=0;
                     ar[i+1][j+1]=0;
                    }
                    else if(i==0 && j==n-1)
                    {
                        ar[i][j-1]=0;
                        ar[i+1][j]=0;
                        ar[i+1][j-1]=0;
                    }
                    else if(i==n-1 && j==0)
                    {
                      ar[i][j+1]=0;
                      ar[i-1][j]=0;
                      ar[i-1][j+1]=0;
                    }
                    else if(i==n-1 && j==n-1)
                    {
                        ar[i][j-1]=0;
                        ar[i-1][j]=0;
                        ar[i-1][j-1]=0;
                    }
                    else if(i==0 && (j>0 && j<n-1))
                    {
                        ar[i][j-1]=0;
                        ar[i][j+1]=0;
                        ar[i+1][j]=0;
                    }
                    else if(j==0 && (i>0 && i<n-1))
                    {
                        ar[i][j+1]=0;
                        ar[i-1][j]=0;
                        ar[i+1][j]=0;
                    }
                    else if(j==n-1 && (i>0 && i<n-1))
                    {
                        ar[i][j-1]=0;
                        ar[i-1][j]=0;
                        ar[i+1][j]=0;
                    }
                    else if(i==n-1 && (j>0 && j<n-1))
                    {
                        ar[i][j-1]=0;
                        ar[i][j+1]=0;
                        ar[i-1][j]=0;
                    }
                    else 
                    {
                        ar[i][j-1]=0;
                        ar[i][j+1]=0;
                        ar[i+1][j]=0;
                    }

                }
                }
            }
        
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(ar[i][j]+" ");
            }
            System.out.println();
        }
    }
}
