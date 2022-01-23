package Javatraining;

public class MaxPQ {
	Integer[] heap;
	int n;
	
	MaxPQ(int capacity){
		heap=new Integer[capacity+1];
		n=0;
	}
	boolean isEmpty() {
		return n==0;
	}
	int size() {
		return n;
	}
	int deleteMax() {
		int max = heap[1];
		swap(1,n);
		n--;
		sink(1);
		heap[n+1]=null;
		if(n>0 && (n==(heap.length-1)/4)) resize(heap.length/2);
		return max;
	}
	void sink(int k) {
		while(2*k <= n) {
			int j=2*k;
			if(j<n && heap[j]<heap[j+1]) j++;
			if(heap[k]>=heap[j]) break;
			swap(k,j);
			k=j;
		}
	}
	void swap(int a,int b) {
		int temp=heap[a];
		heap[a]=heap[b];
		heap[b]=heap[a];
	}
	void insert(int x) {
		if(n==heap.length-1) {
			resize(2*heap.length);
		}
		n++;
		heap[n]=x;
		swim(n);
	}
	void swim(int k) {
		while(k>1 && heap[k/2]<heap[k]) {
			int temp=heap[k];
			heap[k]=heap[k/2];
			heap[k/2]=temp;
			k=k/2;
		}
	}
	void resize(int n) {
		Integer[] temp = new Integer[n];
		for(int i=0;i<heap.length;i++) {
			temp[i]=heap[i];
		}
		heap=temp;
	}
	void printMaxHeap() {
		for (int i =1; i <=n; i++) {
			System.out.print(heap[i]+" ");
		}
	}
	public static void main(String[] args) {
		MaxPQ pq = new MaxPQ(3);
		pq.insert(6);
		pq.insert(3);
		pq.insert(2);
		pq.insert(7);
		pq.insert(5);
		pq.insert(4);
		pq.insert(8);
		pq.printMaxHeap();
	}
}
