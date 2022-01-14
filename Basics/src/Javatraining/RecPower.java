package Javatraining;
public class RecPower {
    static int res = 0,k=0;
    static int check(int x,int n){
    	int num=x;
        if (x == 0) res++;
        int r = (int)Math.floor(Math.pow(num, 1.0 / n));
        for (int i=k+1;i<=r;i++) {
            int a = x - (int)Math.pow(i, n);
            if (a >= 0) {
            	k=i;
            	check(x-(int)Math.pow(i, n),n);
            }
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(check(101,2));
    }
}