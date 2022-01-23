package DataStructures;

import java.util.Arrays;

public class Insertionsort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(insert(new int[]{5,7,3,4,2,6,1})));
    }
    public static int[] insert(int arr[]) {
        for (int i=1;i<arr.length;i++) {
            int temp=arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>temp){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;
        }
        return arr;
    }
}