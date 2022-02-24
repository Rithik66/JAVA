public class extraElement {
    public static void main(String[] args) {
        int[] ar1={2,3,4,6,8,10,12};
        int[] ar2={2,4,6,8,10,12};
        System.out.println(element(ar1, ar2));
    }
    public static int element(int ar1[],int ar2[]) {
        int n = ar2.length;
        int st=0,end=n-1;
        int i=-1;
        while(st<=end){
            int mid=(st+end)/2;
            if(ar1[mid]==ar2[mid]) st=mid+1;
            else{
                i=mid;
                end=mid-1;
            }
        }
        if(i==-1 && ar1.length>ar2.length) return ar1.length-1;
        return i;
    }
}