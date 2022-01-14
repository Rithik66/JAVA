package Javatraining;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class DateExample {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] d1 = scanner.nextLine().split("/");
		String[] d2 = scanner.nextLine().split("/");
		LocalDate l1 = LocalDate.of(Integer.parseInt(d1[2]), Integer.parseInt(d1[1]), Integer.parseInt(d1[0]));
		LocalDate l2 = LocalDate.of(Integer.parseInt(d2[2]), Integer.parseInt(d2[1]), Integer.parseInt(d2[0]));
		SimpleDateFormat dates = new SimpleDateFormat("dd-MM-yyyy");
		try {
			DateTimeFormatter f = DateTimeFormatter.ofPattern("dd MM yyyy");
			Date start = dates.parse(l1.format(f).toString());
			Date end = dates.parse(l2.format(f).toString());
			long days = end.getTime()-start.getTime();
			int diffDays = (int) (days / (24 * 60 * 60 * 1000));
			System.out.println(diffDays);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
