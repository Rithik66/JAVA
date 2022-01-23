package projecteuler;
public class SumSquareDifference {
	public static void main(String[] args) {
		int sumOfSquare=0,sum=0,squareOfSum,result;
		for(int i=1;i<=100;i++) {
			sumOfSquare+=Math.pow(i, 2);
			sum+=i;
		}
		squareOfSum=(int) Math.pow(sum,2);
		result=sumOfSquare-squareOfSum;
		System.out.println(Math.abs(result));
	}
}
