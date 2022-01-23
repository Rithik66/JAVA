package Javatraining;

import java.util.*;

public class AdvnColAdd {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0;i<a;i++) {
			arr.add(scanner.nextInt());
		}
		int b = scanner.nextInt();
		Collections.sort(arr);
		int c=Collections.binarySearch(arr,b);
		int d=0;
		if(c<0) {
			arr.add(b);
			Collections.sort(arr);
			d=Collections.binarySearch(arr,b);
			System.out.println("Not found, added at position: "+(d+1));
		}
		else {
			d=Collections.binarySearch(arr,b);
			System.out.println("found, found at position: "+(d+1));
		}
		System.out.println(arr);
	}
}
