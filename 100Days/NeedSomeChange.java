import java.util.Arrays;
public class NeedSomeChange {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        change(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void change(int[] arr) {
        for(int i=0;i<arr.length-2;i++){
            int temp=arr[i];
            arr[i]=arr[i+2];
            arr[i+2]=temp;
        }
    }
}
