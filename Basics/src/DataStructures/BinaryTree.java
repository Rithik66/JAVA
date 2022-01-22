package Javatraining;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	TreeNode root;
	private class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int data){
			this.data=data;
		}
	}
	void createBinaryTree() {
		TreeNode first = new TreeNode(1);
		TreeNode second = new TreeNode(2);
		TreeNode third = new TreeNode(3);
		TreeNode fourth = new TreeNode(4);
		TreeNode fifth = new TreeNode(5);
		TreeNode sixth = new TreeNode(6);
		TreeNode seventh = new TreeNode(7);
		
		root=first;
		first.left=second;
		first.right=third;
		
		second.left=fourth;
		second.right=fifth;
		
		third.left=sixth;
		third.right=seventh;
	}
	
	void preOrderRec(TreeNode root) {
		if(root==null) return;
		System.out.print(root.data+" ");
		inOrderRec(root.left);
		inOrderRec(root.right);
	}
	void inOrderRec(TreeNode root) {
		if(root==null) return;
		inOrderRec(root.left);
		System.out.print(root.data+" ");
		inOrderRec(root.right);
	}
	void postOrderRec(TreeNode root) {
		if(root==null) return;
		inOrderRec(root.left);
		inOrderRec(root.right);
		System.out.print(root.data+" ");
	}
	void preOrderIte() {
		if(root==null) return;
		Stack<TreeNode> st = new Stack<TreeNode>();
		st.push(root);
		while(!st.isEmpty()) {
			TreeNode temp=st.pop();
			System.out.print(temp.data+" ");
			if(temp.right!=null) st.push(temp.right);
			if(temp.left!=null) st.push(temp.left);
		}
	}
	void inOrderIte() {
		if(root==null) return;
		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode temp = root;
		while(!st.isEmpty() || temp!=null) {
			if(temp!=null) {
				st.push(temp);
				temp=temp.left;
			} else {
				temp=st.pop();
				System.out.print(temp.data+" ");
				temp=temp.right;
			}
		}
	}
	void postOrderIte() {
		TreeNode current = root;
		Stack<TreeNode> st = new Stack<>();
		while(current!=null || !st.isEmpty()) {
			if(current!=null) {
				st.push(current);
				current=current.left;
			}else {
				TreeNode temp = st.peek().right;
				if(temp==null) {
					temp=st.pop();
					System.out.print(temp.data+" ");
					while(!st.isEmpty() && temp==st.peek().right) {
						temp=st.pop();
						System.out.print(temp.data+" ");
					}
				}else {
					current=temp;
				}
			}
		}
	}
	void levelOrder() {
		if(root==null) return;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			System.out.print(temp.data+" ");
			if(temp.left!=null) queue.offer(temp.left);
			if(temp.right!=null) queue.offer(temp.right); 
		}
	}
	int findMax(TreeNode root) {
		if(root==null)return Integer.MIN_VALUE;
		int result=root.data;
		int left=findMax(root.left);
		int right=findMax(root.right);
		if(left>result) result=left;
		if(right>result) result=right;
		return result;
	}
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.createBinaryTree();
		System.out.println(bt.findMax(bt.root));
		/*
		bt.postOrderIte();
		System.out.println();
		bt.postOrderRec(bt.root); 
		System.out.println();
		bt.inOrderIte();
		System.out.println();
		bt.inOrderRec(bt.root);
		System.out.println();
		bt.preOrderIte();
		System.out.println();
		bt.preOrderRec(bt.root);
		System.out.println();
		bt.levelOrder();
		System.out.println();
		*/
	}
}
