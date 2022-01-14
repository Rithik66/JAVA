import java.util.Scanner;
public class hari2das {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        sc.close();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1){
                    if(i==0){
                        arr[i][j-1]=0;
                        arr[i][j+1]=0;
                        arr[i+1][j]=0;
                    }
                    else if(j==n-1){
                        arr[i][j-1]=0;
                        arr[i-1][j]=0;
                        arr[i+1][j]=0;
                    }
                    else if(j==0){
                        arr[i][j+1]=0;
                        arr[i+1][j]=0;
                        arr[i-1][j]=0;
                    }
                    else if(i==n-1){
                        arr[i-1][j]=0;
                        arr[i][j-1]=0;
                        arr[i][j+1]=0;
                    }
                    else{
                        arr[i-1][j]=0;
                        arr[i+1][j]=0;
                        arr[i][j-1]=0;
                        arr[i][j+1]=0;
                    }
                }
                else if(arr[i][j]!=20 && arr[i][j]!=1 && i!=n-1){
                    
                    if(j==0){
                        if(arr[i+1][j+1]!=20 && arr[i+1][j+1]!=0){
                            arr[i+1][j]=0;
                            arr[i][j+1]=0;
                        }
                    }

                    else if(j==n-1){
                        if(arr[i+1][j-1]!=20 && arr[i+1][j-1]!=0){
                            arr[i+1][j]=0;
                            arr[i][j-1]=0;
                        }
                    }
                    else if(arr[i+1][j+1]!=20 && arr[i+1][j+1]!=0){
                        arr[i][j+1]=0;
                        arr[i+1][j-1]=0;
                    }
                    else if(arr[i+1][j-1]!=20 && arr[i+1][j-1]!=0){
                        arr[i+1][j]=0;
                        arr[i][j-1]=0;
                    }
                }
                if(arr[i][j]!=20 && arr[i][j]!=1 && arr[i][j]!=0){
                    if(i!=n-1 && i!=n-2){
                        if(j!=0 && j!=1 && j!=n-1 && j!=n-2){
                            if(arr[i][j+2]!=0 && arr[i][j+2]!=20)arr[i][j+1]=0;
                            if(arr[i][j-2]!=0 && arr[i][j-2]!=20)arr[i][j-1]=0;
                            if(arr[i+2][j]!=0 && arr[i+2][j]!=20)arr[i+1][j]=0;
                        }
                        else if(j==0 || j==1){
                            if(arr[i][j+2]!=0 && arr[i][j+2]!=20)arr[i][j+1]=0;
                            if(arr[i+2][j]!=0 && arr[i+2][j]!=20)arr[i+1][j]=0; 
                        }
                        else if(j==n-1 || j==n-2){
                            if(arr[i][j-2]!=0 && arr[i][j-2]!=20)arr[i][j-1]=0;
                            if(arr[i+2][j]!=0 && arr[i+2][j]!=20)arr[i+1][j]=0;
                        }
                    }
                    else if(i==n-1 || i==n-2){
                        if(j!=0 && j!=1 && j!=n-1 && j!=n-2){
                            if(arr[i][j+2]!=20 && arr[i][j+2]!=0)arr[i][j+1]=0;
                            if(arr[i][j-2]!=0 && arr[i][j-2]!=20)arr[i][j-1]=0;
                        }
                        else if(j==0 || j==1){
                            if(arr[i][j+2]!=20 && arr[i][j+2]!=0)arr[i][j+1]=0;
                        }
                        else if(j==n-1 || j==n-2){
                            if(arr[i][j-2]!=0 && arr[i][j-2]!=20)arr[i][j-1]=0;
                        }
                    }
                    
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
    }
}