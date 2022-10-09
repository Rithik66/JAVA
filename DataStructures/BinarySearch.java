public class BinarySearch {
    public static void main(String[] args) {
        int first[] = {1,2,3,4,5,6,7,8,9};
        int second[] = {9,8,7,6,5,4,3,2,1};
        searchInt1(first, 5);
        searchInt2(first, 6);
        searchOrderAgnostic(second,5);
    }
    public static void searchOrderAgnostic(int[] arr, int token) {
        int start = 0;
        int end = arr.length-1;
        
        while(start<=end){
            int mid = start+((end-start)/2);
            if(token<arr[mid])
                end=mid-1;
            else if(token>arr[mid])
                start=mid+1;
            else{
                System.out.println(mid);
                return;
            }
        }
        System.out.println("No Match Found!!!");
        return;
    }
    public static void searchInt2(int[] arr, int token){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start+((end-start)/2);
            if(token<arr[mid])
                end=mid-1;
            else if(token>arr[mid])
                start=mid+1;
            else{
                System.out.println(mid);
                return;
            }
        }
        System.out.println("No Match Found!!!");
        return;
    }
    public static void searchInt1(int[] arr,int token){
        int start = 0;
        int end = arr.length-1;
        int mid = start+((end-start)/2);
        binaryInt1(start,mid,end,arr,token);
    }
    public static void binaryInt1(int start,int mid,int end,int[] arr,int token) {
        if(token<arr[start] || token>arr[end]){
            System.out.println("No Match Found!!!");
            return;
        }
        else if(token==arr[mid]){
            System.out.println("Value("+token+") found at the index : "+mid);
            return;
        }
        else if(arr[mid]<token){
            start=mid+1;
            mid=start+((end-start)/2);
            binaryInt1(start, mid, end, arr, token);
        }
        else if(arr[mid]>token){
            end=mid-1;
            mid=start+((end-start)/2);
            binaryInt1(start, mid, end, arr, token);
        }
        else{
            System.out.println("No Match Found!!!");
            return;
        }
    }
}
