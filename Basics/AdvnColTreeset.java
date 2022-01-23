package Javatraining;
//import java.util.*;
//public class AdvnColTreeset {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		TreeSet<Card> set = new TreeSet<Card>();
//		ArrayList<Character> ca = new ArrayList<>();
//		int count=0;
//		int i=0;
//		while(count<4){
//			char c=sc.next().charAt(0);
//			int a=sc.nextInt();
//			if(!ca.contains(c)) {
//				count++;
//				
//			}
//			set.add(new Card(c,a));
//			sc.nextLine();
//			ca.add(c);
//			i++;
//		}
//		
//		System.out.println("Four symbols gathered in "+i+" cards.");
//		System.out.println("Cards in Set are:");
//		for (Card card:set){
//			System.out.println(card.c+" "+card.a);
//		}
//	}
//}
//class Card implements Comparable<Card>{
//	char c;
//	int a;
//	Card(char c,int a){
//		this.c=c;
//		this.a=a;
//	}
//	@Override
//	public int compareTo(Card cr) {
//		return String.valueOf(c).compareTo(String.valueOf(cr.c));
//	}
//}
//
//import java.util.*;
//public class AdvnColTreeset {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int a = sc.nextInt();
//		TreeSet<Empl> set1 = new TreeSet<>();
//		TreeSet<Empl1> set2 = new TreeSet<>();
//		for(int i=0;i<a;i++) {
//			String s = sc.next();
//			int b = sc.nextInt();
//			set1.add(new Empl(s,b));
//			set2.add(new Empl1(s,b));
//		}
//		System.out.println("After sorting the employee names:");
//		Iterator<Empl1> it2 = set2.iterator();
//		while(it2.hasNext()) {
//			Empl1 e = it2.next();
//			System.out.println(e.s+"-"+e.a);
//		}
//		System.out.println("After sorting the salary:");
//		Iterator<Empl> it1 = set1.iterator();
//		while(it1.hasNext()) {
//			Empl e = it1.next();
//			System.out.println(e.s+"-"+e.a);
//		}
//	}
//}
//class Empl implements Comparable<Empl>{
//	String s;
//	int a;
//	Empl(String s,int a){
//		this.s=s;
//		this.a=a;
//	}
//	@Override
//	public int compareTo(Empl cr) {
//		int cmp=((Empl)cr).a;
//		return this.a-cmp;
//	}
//	public String toString() {
//		return s+"-"+a;
//	}
//}
//class Empl1 implements Comparable<Empl1>{
//	String s;
//	int a;
//	Empl1(String s,int a){
//		this.s=s;
//		this.a=a;
//	}
//	@Override
//	public int compareTo(Empl1 cr) {
//		String cmp=((Empl1)cr).s;
//		return this.s.compareTo(cmp);
//	}
//	public String toString() {
//		return s+"-"+a;
//	}
//}
import java.util.*;
public class AdvnColTreeset{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		HashMap<String,Integer> h = new HashMap<>();
		TreeSet<Card> set1 = new TreeSet<>();
		ArrayList<String> ar= new ArrayList<>();
		for(int i=0;i<a;i++) {
			String s = sc.next();
			int b = sc.nextInt();
			h.put(s,b);
			set1.add(new Card(s,b));
			ar.add(s+" "+b);
		}
		Collections.sort(ar);
		System.out.println("Distinct Symbols are:");
		String st = "Comparator<Card>";
		Iterator<Card> it1 = set1.iterator();
		while(it1.hasNext()) {
			Card e = it1.next();
			System.out.print(e.s+" ");
		}
		System.out.println();
		for(int i=0;i<ar.size();i++) {
			System.out.println("Cards in "+ar.get(i).substring(0,1)+" Symbols:");
			System.out.println(ar.get(i));
			int count=1,in=i,sum=Integer.parseInt(ar.get(i).substring(2));
			for(int j=i+1;j<ar.size();j++) {
				if(ar.get(i).substring(0,1).equals(ar.get(j).substring(0,1))) {
					System.out.println(ar.get(j));
					count++;
					i++;
					sum+=Integer.parseInt(ar.get(j).substring(2));
				}
			}
			System.out.println("Number of Cards: "+count);
			System.out.println("Sum of Numbers: "+sum);
		}
	}
}
class Card implements Comparable<Card>{
	String s;
	int a;
	Card(String s,int a){
		this.s=s;
		this.a=a;
	}
	@Override
	public int compareTo(Card cr) {
		String cmp=((Card)cr).s;
		return this.s.compareTo(cmp);
	}
	public String toString() {
		return s;
	}
}

