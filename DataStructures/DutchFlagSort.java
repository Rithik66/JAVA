package DataStructures;
import java.util.Arrays;

//0s,1s,2s sort
public class DutchFlagSort {
    public static void main(String[] args) {
        int arr[] = {2,0,1,2,0,2,1,0,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int arr[]){
        int i=0,j=0,k=arr.length-1;
        while(i<=k){
            if(arr[i]==0) swap(arr,i++,j++);
            else if(arr[i]==1) i++;
            else if(arr[i]==2) swap(arr,i,k--);
        }
    }
    public static void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
