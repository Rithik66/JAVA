package projecteuler;
public class TenThousandAndOneTH {
	public static void main(String[] args) {
		int digit=0;
		for(int i=1;i<10001*10001;i++) {
			boolean isPrime=true;
			int j=2;
			if(i==0 || i==1) {
				isPrime=false;
			} 
			else {
			while(j<i) {
					if(i%j==0)
						isPrime=false;
					j++;
			}
			if(isPrime) {
				digit+=1;
				if(digit==10001) {
					System.out.println(i);
					break;
				}
			}
			}
		}
	}
}