package Javatraining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Axcent {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
        long count = 0;
        long[] array = new long[n];
        for (int i = 0; i < n; i++)
            array[i] = scanner.nextLong();
        
        long[] b = new long[n];
        for (int i = 1; i < n; i++) {
            if (array[i] >= array[i - 1]) {
                b[i] = b[i - 1] + 1;
            }
        }
        for (int i = 0; i < n; i++)
            count += b[i];
        System.out.println(count + n);
	}
}