import java.util.*;
public class  sort012{
    public static void main(String[] args) {
        int arr[] = {1,0,2,1,0,1,2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr) {
        int z=0,o=0,t=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0) z++;
            else if(arr[i]==1) o++;
            else t++;
        }
        //System.out.println(z+" "+o+" "+t);
        for(int i=0;i<z;i++){
            arr[i]=0;
        }
        for(int i=z;i<z+o;i++){
            arr[i]=1;
        }
        for(int i=z+o;i<arr.length;i++){
            arr[i]=2;
        }
    }
}
