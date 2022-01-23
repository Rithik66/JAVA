package codechef;
import java.util.*;
public class EnormousInputTest {
	public static void main(String[] args){
	    Scanner scanner = new Scanner (System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
			int count=0;
			for(int i=0;i<a;i++){
			  int c = scanner.nextInt();
			  if(c%b==0 && c<1000000000 && c>0) count++;
			}
			System.out.println(count);
		}
}