import java.util.NoSuchElementException;

public class DoublyLinkedList {
	ListNode head;
	ListNode tail;
	int length;
	static class ListNode{
		int data;
		ListNode previous;
		ListNode next;
		ListNode(int data) {
			this.data=data;
		}
	}
	DoublyLinkedList(){
		this.head=null;
		this.tail=null;
		length=0;
	}
	boolean isEmpty() {
		return length==0;
	}
	void displayForward() {
		if(head==null) return;
		ListNode temp=head;
		while(temp!=null){
			System.out.print(temp.data+"-->");
			temp=temp.next;
		}
		System.out.println("null");
	}
	void displayBackward() {
		if(head==null) return;
		ListNode temp=tail;
		while(temp!=null){
			System.out.print(temp.data+"-->");
			temp=temp.previous;
		}
		System.out.println("null");
	}
	void insertFirst(int data) {
		ListNode newNode = new ListNode(data);
		if(isEmpty()) tail=newNode;
		else head.previous=newNode;
		newNode.next=head;
		head=newNode;
		length++;
	}
	void insertLast(int data) {
		ListNode newNode = new ListNode(data);
		if(isEmpty()) head=newNode;
		else {
			tail.next=newNode;
			newNode.previous=tail;
		}
		tail=newNode;
		length++;
	}
	ListNode deleteFirst() {
		if(isEmpty()) throw new NoSuchElementException();
		ListNode temp=head;
		if(head==tail) tail=null;
		else head.next.previous=null;
		head=head.next;
		temp.next=null;
		length--;
		return temp;
	}
	ListNode deleteLast() {
		if(isEmpty()) throw new NoSuchElementException();
		ListNode temp=tail;
		if(head==tail) head=null;
		else tail.previous.next=null;
		tail=tail.previous;
		temp.previous=null;
		length--;
		return temp;
	}
	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.insertFirst(2);
		dll.insertFirst(1);
		dll.insertLast(3);
		dll.insertLast(4);
		dll.deleteFirst();
		dll.displayForward();
		dll.displayBackward();
	}
}
