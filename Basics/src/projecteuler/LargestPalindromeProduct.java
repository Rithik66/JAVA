package projecteuler;
import java.util.Scanner; 
public class LargestPalindromeProduct {
	public static void main(String[] args) {  
		  Scanner input = new Scanner(System.in);
		  int maxnum=1;
		  for(int i=101101;i<101110;i++) {
			  for(int j=101101;j<101110;j++) {
				  int result=i*j;
				  int temp1=result,r=0,x=0,p=0;
					while(temp1!=0) {
						r=temp1%10;
						temp1=temp1/10;
						p++;
					}
					int temp=result,l=0;
					String k="";
					  	while(temp!=0){
					  		l=temp%10;
					  		k=k+l;
					  		p--;
					  		temp=temp/10;
					  	}
					  	int newk=Integer.parseInt(k);
					  	if(newk==result) {
							  maxnum=Math.max(maxnum, newk);
						  }
			  } 
		  }
		  System.out.println(maxnum);
		  
	}
}
