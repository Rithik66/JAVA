package DataStructures;
import java.util.Arrays;
public class Selectionsort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(select(new int[]{5,7,3,4,2,6,1})));
    }
    public static int[] select(int arr[]) {
        for (int i=0;i<arr.length;i++) {
            int min=i;
            for (int j=i+1;j<arr.length;j++) {
                if(arr[j]<arr[min]) min=j;
            }
            int temp = arr[min];
            arr[min]=arr[i];
            arr[i]=temp;
        }
        return arr;
    }
}