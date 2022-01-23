package Javatraining;

import java.util.Map.*;
import java.util.*;

public class SimplePrime {
	 public static void main(String[]args){
	        Scanner scanner = new Scanner(System.in);
	        int a = scanner.nextInt();
	        HashMap<String,Integer> map = new HashMap<>();
	        for(int i=0;i<a;i++){
	            map.put(scanner.next(),scanner.nextInt());
	        }
	        String s = scanner.next();
	        System.out.println(map);
	        if(map.containsKey(s)){
	            for(Entry<String,Integer> e:map.entrySet()){
	                if(e.getKey().equals(s)){
	                    System.out.print(e.getValue());
	                    break;
	                }
	            }
	        }
	    }
}
