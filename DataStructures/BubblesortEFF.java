
import java.util.Arrays;

public class BubblesortEFF {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubble(new int[]{5,7,3,4,2,6,1})));
    }
    public static int[] bubble(int arr[]) {
        int flag;
        for (int i=0;i<arr.length-1;i++) {
            flag = 0;
            for (int j=0;j<arr.length-1-i;j++) {
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=1;
                }
            }
            if(flag==0) return arr;
        }
        return arr;
    }
}