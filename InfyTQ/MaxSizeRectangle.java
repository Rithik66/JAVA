import java.util.*;
public class MaxSizeRectangle{
	public static void main(String[]a){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int arr[][] = new int[n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				arr[i][j]=scanner.nextInt();
			}
		}
		print(arr);
	}
	public static int print(int[][] arr){
	int n=arr.length,m=arr[0].length;
    	int res=0,max=Integer.MIN_VALUE;
        for(int j=0;j<m;j++){
            int temp[]=new int[n];
            for(int k=j;k<m;k++){
                for(int i=0;i<n;i++){
                    temp[i]+=arr[i][k];
                }
                res=kadane(temp);
                max=Math.max(max,res);
            }
         }
        System.out.println(max);
    }
    public static int kadane(int[] arr) {
        int n=arr.length;
        int sum=0,max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            sum=sum+arr[i];
            max=Math.max(max,sum);
            if(sum<0) sum=0;
        }
        return max;
	}
}