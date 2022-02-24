public class TransitionPoint {
    public static void main(String[] args) {
        int[] arr = {0,0,0,0,1,1,1};
        System.out.println(transition(arr));
    }
    public static int transition(int[] arr) {
        int n = arr.length;
        if(n==1 && arr[0]==0) return -1;
        if(arr[0]==1) return 0;
        int st=0,end=n-1;
        while(st<=end){
            int mid=(st+end)/2;
            if(arr[mid]==1 && arr[mid-1]==0) return mid;
            else if(arr[mid]==1) end=mid-1;
            else st=mid+1;
        }
        return -1;
    }
}
