package Javatraining;

import java.util.Arrays;

public class RecTiles { 
	    static int minTiles(int n, int m){
	    if (n == 0 || m == 0)return 0;
	    else if (n % 2  == 0 && m % 2 == 0)return minTiles(n / 2, m / 2);
	    else if (n % 2 == 0 && m % 2 == 1) return (n + minTiles(n / 2, m / 2));
	    else if (n % 2 == 1 && m % 2 == 0)return (m + minTiles(n / 2, m / 2));
	    else return (n + m - 1 + minTiles(n / 2, m / 2));
	    }
	   
	    public static void main (String[] args) {
	        System.out.println(minTiles(5,6));    
	    }
}