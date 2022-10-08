
import java.util.Arrays;

public class Bubblesort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubble(new int[]{5,7,3,4,2,6,1})));
    }
    public static int[] bubble(int arr[]) {
        for (int i=0;i<arr.length;i++) {
            for (int j=0;j<arr.length-1;j++) {
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return arr;
    }
}
