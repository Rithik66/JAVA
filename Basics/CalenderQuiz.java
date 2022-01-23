package Javatraining;

import java.time.*;
import java.util.*;

public class CalenderQuiz {
	public static void main (String[] args){
		Scanner scanner=new Scanner(System.in);
		    int b=scanner.nextInt();
		    LocalDate d=LocalDate.of(b,1,1);
		    DayOfWeek d1=DayOfWeek.from(d);
		    String s = d1.name();
		    String sub1 = s.substring(0,1);
		    String sub2 = s.substring(1).toLowerCase();
		    s=sub1+sub2;
		    System.out.println(s);
	}
}