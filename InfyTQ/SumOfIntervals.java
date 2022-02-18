import java.util.*;
public class SumOfIntervals{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String []arr = scanner.nextLine().split(",");
		ArrayList<Integer> liN = new ArrayList<>();
		ArrayList<Integer> liP = new ArrayList<>();
		ArrayList<Integer> liFinal = new ArrayList<>();
		ArrayList<Integer> answer = new ArrayList<>();
		for(int i=0;i<arr.length;i++){
		    int a=Integer.parseInt(arr[i]);
		    if(a<0) liN.add(a);
		    else if(a>=0) liP.add(a);
		}
		liFinal.addAll(liN);
		liFinal.addAll(liP);
		for(int i=0;i<arr.length-1;i++){
		    if((liFinal.get(i+1)-liFinal.get(i))<0) answer.add(0);
		    else{
		        answer.add(sum(liFinal.get(i),liFinal.get(i+1)));
		    }
		}
		System.out.print(answer.get(0));
		for(int i=1;i<answer.size();i++){
		    System.out.print(","+answer.get(i));
		}
	}
	public static int sum(int i,int j){
	    int sum=0;
	    for(int k=i+1;k<j;k++){
	        sum+=k;
	    }
	    return sum;
	}
}