package DataStructures;

public class SinglyLinkedList {
	private ListNode head;
	private static class ListNode{
		private int data;
		private ListNode next;
		ListNode(int data) {
			this.data=data;
			this.next=null;
		}
	}
	public void display(ListNode head) {
		ListNode temp=head;
		//int count=0;                                                      	for finding length
		while(temp!=null) {
			System.out.print(temp.data+"--> ");
			//count++;															for finding length
			temp=temp.next;
		}
		System.out.println("null");
		//System.out.println("Length of SinglyLinkedList is : "+count);        	for finding length
	}
	void insertFirst(int data) {
		ListNode newNode = new ListNode(data);
		newNode.next=head;
		head=newNode;
	}
	void insertLast(int data) {
		ListNode newNode = new ListNode(data);
		if(head==null) {
			head=newNode;
			return;
		}
		ListNode temp = head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=newNode;
	}
	void insertAt(int data,int position) {
		ListNode newNode = new ListNode(data);
		if(position==1) {
			newNode.next=head;
			head=newNode;
		} else {
			ListNode prev = head;
			int count=1;
			while(count<position-1){
				count++;
				prev=prev.next;
			}
			ListNode current = prev.next;
			newNode.next=current;
			prev.next=newNode;
		}
	}
	ListNode deleteFirst() {
		if(head==null) return null;
		ListNode temp = head;
		head=head.next;
		temp.next=null;
		return temp;
	}
	ListNode deleteLast() {
		if(head==null||head.next==null) return head;
		 ListNode current = head;
		 ListNode prev = null;
		 while(current.next!=null) {
			 prev=current;
			 current=current.next;
		 }
		 prev.next=null;
		return current;
	}
	void deleteAt(int position) {
		if(position==1) {
			head=head.next;
		}else {
		ListNode prev=head;
		int count=1;
		while(count<position-1) {
			count++;
			prev=prev.next;
		}
		ListNode current=prev.next;
		prev.next=current.next;
		}
	}
	boolean search(int data) {
		ListNode current =head;
		if(head==null) return false;
		while(current!=null) {
			if(data==current.data) return true;
			current=current.next;
		}
		return false;
	}
	ListNode reverse() {
		if(head==null) {
			return head;
		}
		ListNode current=head;
		ListNode prev=null;
		ListNode next=null;
		while(current!=null) {
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		return prev;
	}
	ListNode middleNode(ListNode head) {
		if(head==null) return head;
		ListNode slow = head;
		ListNode fast = head;
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
	int nthNode(ListNode head,int n) {
		ListNode main=head,ref=head;
		int count=0;
		while(count<n) {
			ref=ref.next;
			count++;
		}
		while(ref!=null) {
			main=main.next;
			ref=ref.next;
		}
		return main.data;
	}
	public ListNode mergeSort(ListNode node) {
	    if(node == null || node.next == null) {
	    	return node;
	    }
	    ListNode middle = middleNode(node);
	    ListNode second = middle.next;
	    middle.next = null;
	    ListNode left=mergeSort(node);
	    ListNode right = mergeSort(second);
	    return merge(left,right);
	}
	public ListNode merge(ListNode a, ListNode b) {
		ListNode temp = null;
		if(a==null)return b;
		if(b==null)return a;
		if(a.data < b.data) {
			temp= a;
			temp.next=merge(a.next,b);
		}else{
			temp = b;
			temp.next=merge(a,b.next);
	    }
		return temp;
	}
	void bubbleSort(ListNode head) {
		int temp=0;
		ListNode t1=head,t2=null;
		while(t1.next!=null) {
			t2=t1.next;
			while(t2.next!=null){
				if(t2.data>t2.next.data){
					temp=t2.data;
					t2.data=t2.next.data;
					t2.next.data=temp;
				}
				t2=t2.next;
			}
			t1=t1.next;
		}
		display(t2);
	}
	ListNode removeDuplicateFromSort(ListNode head) {
		ListNode current = head;
		while(current!=null && current.next!=null) {
			if(current.data==current.next.data) {
				current.next=current.next.next;
			}else {
				current = current.next;
			}
		}
		return head;
	}
	ListNode insertSort(int value) {
		ListNode newNode = new ListNode(value);
		if(head == null) {
			return newNode;
		}
		ListNode current = head;
		ListNode temp = null;
		while (current != null && current.data < newNode.data) {
			temp = current;
			current = current.next;
		}
		newNode.next = current;
		temp.next = newNode;
		return head;
	}
	void delete(int data) {
		ListNode current = head;
		ListNode temp = null;
		while(current!=null && current.data!=data) {
			temp = current;
			current=current.next;
		}
		if(current==null) return;
		temp.next=current.next;
	}
	boolean checkLoop() {
		ListNode slow = head;
		ListNode fast = head;
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast=fast.next.next;
			if(slow==fast) return true;
		}
		return false;
	}
	ListNode getStartNode(ListNode slow) {
		ListNode temp=head;
		while(slow!=temp) {
			temp=temp.next;
			slow=slow.next;
		}
		return temp;
	}
	ListNode findLoop1() {
		ListNode slow = head;
		ListNode fast = head;
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast=fast.next.next;
			if(slow==fast) return getStartNode(slow);
		}
		return null;
	}
	void findLoop2() {
		ListNode slow = head;
		ListNode fast = head;
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast=fast.next.next;
			if(slow==fast) removeLoop(slow);
			return;
		}
	}
	void removeLoop(ListNode slow) {
		ListNode temp=head;
		while(slow.next!=temp.next) {
			temp=temp.next;
			slow=slow.next;
		}
		slow.next=null;
	}
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.head = new ListNode(1);
		ListNode second = new ListNode(5);
		ListNode third = new ListNode(4);
		ListNode fourth = new ListNode(3);
		ListNode fifth = new ListNode(6);
		ListNode sixth = new ListNode(2);
		sll.head.next=second;
		second.next=third;
		third.next=fourth;
		fourth.next=fifth;
		fifth.next=sixth;
		sixth.next=third;
	}
}