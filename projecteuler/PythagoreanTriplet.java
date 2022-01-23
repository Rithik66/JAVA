package projecteuler;

public class PythagoreanTriplet {
	public static void main(String[] args) {
		int a,b,c,asq=0,bsq=0,csq=0;
		first:
		for(a=1;a<1000;a++) {
			for(b=1;b<1000;b++) {
				for(c=1;c<1000;c++) {
					if(a+b+c==1000) {
						asq=a*a;
						bsq=b*b;
						csq=c*c;
						if(asq+bsq==csq) {
							System.out.println(a*b*c);
							break first;
						}
					}
				}
			}
		}
	}
}
