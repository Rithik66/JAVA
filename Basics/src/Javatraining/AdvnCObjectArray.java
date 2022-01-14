package Javatraining;

import java.util.Arrays;
import java.util.Scanner;

public class AdvnCObjectArray {
	static int count=0,count1=0;
	static int check=0,a=0;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		a = scanner.nextInt();
		ItemType[] itemtype = new ItemType[a];
		ItemTypeBO k = new ItemTypeBO();
		for(int i=0;i<a;i++) {
			scanner.nextLine();
			itemtype[i]=new ItemType(scanner.nextLine(),scanner.nextDouble(),scanner.nextDouble());
		}
		scanner.nextLine();
		String search = scanner.nextLine();
		k.search(search, itemtype);
		k.display(itemtype);
	}
}
class ItemType{
	String s;
	double d1,d2;
	ItemType(String s,double d1,double d2){
		this.s=s;
		this.d1=d1;
		this.d2=d2;
	}
}
class ItemTypeBO{
	public void search(String search,ItemType[] itemtype) {
		for(ItemType it:itemtype) {
			if(it.s.equals(search)) {
				System.out.println(it.s+" "+it.d1+" "+it.d2);
				break;
			}
		}
	}
	public void display(ItemType[] itemtype) {
		for(ItemType it:itemtype) {
			System.out.println(it.s+" "+it.d1+" "+it.d2);
		}
	}
}
