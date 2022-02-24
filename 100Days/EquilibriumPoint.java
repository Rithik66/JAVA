public class EquilibriumPoint {
    public static void main(String[] args) {
        int[] arr = {4,3,6,2,2,7,4};
        System.out.println(equilibrium(arr));
    }
    public static int equilibrium(int[] arr) {
        int n=arr.length;
        int sum1=0,sum2=0;
        for(int i=0;i<n;i++){
            sum1+=arr[i];
        }
        for(int i=0;i<n;i++){
            sum1-=arr[i];
            if(sum1==sum2) return i+1;
            sum2+=arr[i];
        }
        return 0;
    }
}
