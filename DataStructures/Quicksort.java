import java.util.*;
public class Quicksort {
    public static void main(String[] args) {
        int []arr = {5,7,3,4,2,6,1};
        quick(arr,0,6);
        System.out.println(Arrays.toString(arr));
    }
    public static void quick(int arr[],int low,int high) {
        if(low<high){
            int p= partition(arr,low,high);
            quick(arr,low,p-1);
            quick(arr,p+1,high);
        }
    }
    public static int partition(int arr[],int low,int high) {
        int pivot = arr[high],i=low,j=low;
        while(i<=high){
            if(arr[i]<=pivot){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
            i++;
        }
        return j-1;
    }
}
