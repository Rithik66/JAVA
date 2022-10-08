
import java.util.Arrays;

public class Merge2Arrays{
    public static void main(String[] args) {
        int ar1[] = {1,3,4,6};
        int ar2[] = {2,5,7,8};
        int ans[] = merge(ar1, ar2);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] merge(int ar1[],int ar2[]) {
        int n = ar1.length,m=ar2.length;
        int ans[] = new int[n+m];
        int i=0,j=0,k=0;
        while(i<n && j<m){
            if(ar1[i]<ar2[j]){
                ans[k++]=ar1[i++];
            }
            else{
                ans[k++]=ar2[j++];
            }
        }
        while(i<n){
            ans[k++]=ar1[i++];
        }
        while(j<n){
            ans[k++]=ar2[j++];
        }
        return ans;
    }
}
