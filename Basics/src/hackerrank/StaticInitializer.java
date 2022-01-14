package hackerrank;

import java.util.Scanner;

public class StaticInitializer {
	static int B,H;
	static boolean flag;
	static{System.out.println("hi");
	Scanner scanner = new Scanner(System.in);
	B = scanner.nextInt();
	H = scanner.nextInt();
	scanner.close();
	if(H>0 && B>0){
	    flag = true;
	}
	else if(B<=0 || H<=0){
	    flag=false;
	    System.out.println("java.lang.Exception: Breadth and height must be positive");
	}}
public static void main(String[] args){
		if(flag){
			System.out.println("hi");
			int area=B*H;
			System.out.println("hi");
			System.out.print(area);
			}}}