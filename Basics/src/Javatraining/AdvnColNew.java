package Javatraining;
import java.util.*;
public class AdvnColNew{
	    public static void main(String[]args){
	        Scanner scanner = new Scanner(System.in);
	        int a = scanner.nextInt();
	        ArrayList<Integer> arr = new ArrayList<>();
	        for(int i=0;i<a;i++){
	            arr.add(scanner.nextInt());
	        }
	        for(int i=0;i<a/2;i++){
	        	swap(arr,i);
	        }
	    }
	    public static ArrayList<Integer> swap(ArrayList<Integer> arr,int index){	
	    	int a = arr.get(index);
	    	int b = arr.get((arr.size()-1)-index);
	    	int arl = arr.size();
	    	int temp=a;
	    	a=b;
	    	b=temp;
	    	arr.remove(index);
	    	arr.add(index,a);
	    	arr.remove((arl-1)-index);
	    	arr.add((arl-1)-index,b);
	    	System.out.println(arr);
	    	return arr;
    }
}
