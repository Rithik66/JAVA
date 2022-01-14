package projecteuler;

public class Below2Million {
	public static void main(String[] args) {
		long i,sum=0;
		for(i=0;i<10;i++) {
			long j=2;
			boolean isPrime=true;
			if(i==0||i==1) {isPrime=false;}
			else {
			while(j<i) {
				if(i%j==0) { isPrime=false;}
				j++;
			}
			if(isPrime) {
				sum+=i;
			}
			}
		}
		System.out.println(sum);
	}
}
