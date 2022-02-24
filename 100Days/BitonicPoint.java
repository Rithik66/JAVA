public class BitonicPoint {
    public static void main(String[] args) {
        int[] arr = {1,15,25,45,42,21,17,12,11};
        System.out.println(bitonic(arr));
    }
    public static int bitonic(int[] arr) {
        int n = arr.length;
        int st=0,end=n-1;
        while(st<=end){
            int mid=(st+end)/2;
            if(arr[mid-1]<arr[mid] && arr[mid+1]<arr[mid]) return arr[mid];
            else if(arr[mid-1]>arr[mid] && arr[mid+1]<arr[mid]) end=mid-1;
            else st=mid+1;
        }
        return -1;
    }
}
