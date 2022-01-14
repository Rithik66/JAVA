package Javatraining;

import java.util.*;

public class TimeComplexityLoop {
    static boolean isPrime(long n){
        if(n==2)return true;
        if(n==0 || n%2==0 ||n==1)return false;
        for(long i=3;i<=Math.sqrt(n);i+=2){
            if(n%i==0)return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long n = sc.nextLong();
        sc.close();
        List<Long> primes=new ArrayList<>();
        for(long i=1;i<=Math.sqrt(n);i++){
            if(n%i==0 && isPrime(i)){
               primes.add(i);
            }
            if(n%i==0 && isPrime(n/i)){
                primes.add(n/i);
            }
        }
        long ar[] = new long[primes.size()];
        for(int i=0;i<ar.length;i++) {
        	ar[i]=primes.get(i);
        }
        List<Long> finalprime=new ArrayList<>();
        for(int i=0;i<ar.length-1;i++) {
        	if(ar[i]!=ar[i+1]) {
        		finalprime.add(ar[i]);
        	}
        }
        finalprime.add(ar[ar.length-1]);
        System.out.println(finalprime);
    }
}
