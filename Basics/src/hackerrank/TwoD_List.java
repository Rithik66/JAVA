package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;

public class TwoD_List{
	public static void main(String[] args) {
		List<List<Integer>> ar = new ArrayList<>();
		List<Integer> a = new ArrayList<>();
		a.add(0);
		a.add(1);
		a.add(2);
		List<Integer> b = new ArrayList<>();
		b.add(3);
		b.add(4);
		b.add(5);
		List<Integer> c = new ArrayList<>();
		c.add(6);
		c.add(7);
		c.add(5);
		ar.add(a);
		ar.add(b);
		ar.add(c);
		int leftsum=0,i=0,j=ar.size()-1;
		while(i>=0 && j>=0) {
			leftsum+=ar.get(i).get(j);
			i++;j--;
		}
		System.out.println(leftsum);
		int rightsum=0;
		i=0;j=0;
		while(i<ar.size() && j<ar.size()) {
			rightsum+=ar.get(i).get(j);
			i++;j++;
		}
		System.out.println(rightsum);
	}
}