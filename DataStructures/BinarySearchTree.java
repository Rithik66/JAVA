public class BinarySearchTree {
	TreeNode root;
	private class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int data){
			this.data=data;
		}
	}
	public void insert(int value) {
		root=insert(root,value);
	}
	public TreeNode insert(TreeNode root,int value) {
		if(root==null) {
			root=new TreeNode(value);
			return root;
		}
		if(value<root.data) root.left=insert(root.left,value);
		else root.right=insert(root.right,value);
		
		return root;
	}
	void inOrder() {
		inOrderRec(root);
	}
	void inOrderRec(TreeNode root) {
		if(root==null) return;
		inOrderRec(root.left);
		System.out.print(root.data+" ");
		inOrderRec(root.right);
	}
	TreeNode search(int key) {
		return search(root,key);
	}
	TreeNode search(TreeNode root,int key) {
		if(root==null||root.data==key) return root;
		if(key<root.data) return search(root.left,key);
		else return search(root.right,key);
	}
	public static void main(String[] args) {
		
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(1);
		bst.insert(2);
		bst.insert(3);
		bst.insert(4);
		bst.insert(5);
		bst.inOrder();
		System.out.println();
		if(null!=bst.search(7)) System.out.println("Key Found!");
		else System.out.println("Key Not Found :(");
	}
}
