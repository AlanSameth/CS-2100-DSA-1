package tree;


public class BinaryTree<T> {

	protected TreeNode<T> root = null;
	
	/* Traversal methods */
	public String getInOrder() {
		return getInOrder(root);
	}
	private String getInOrder(TreeNode<T> curNode) {
		//TODO: return the in order traversal of this tree, space separated
		String inorder = "";
		
		if(curNode == null) {
			return "";
		}
		
		inorder = inorder + getInOrder(curNode.left);
		
		inorder = inorder + curNode.data + " ";
		
		inorder = inorder + getInOrder(curNode.right);
		
		return inorder;
	}
	
	public String getPreOrder() {
		return getPreOrder(root);
	}
	private String getPreOrder(TreeNode<T> curNode) {
		//TODO: return the pre order traversal of this tree, space separated
		String preorder = "";
		
		if(curNode == null) {
			return "";
		}
		
		preorder = preorder + curNode.data + " ";
		
		preorder = preorder + getPreOrder(curNode.left);
		
		preorder = preorder + getPreOrder(curNode.right);
		
		return preorder;
	}
	
	public String getPostOrder() {
		return getPostOrder(root);
	}
	private String getPostOrder(TreeNode<T> curNode) {
		//TODO: return the post order traversal of this tree, space separated
		String postorder = "";
		
		if(curNode == null) {
			return "";
		}
		
		postorder = postorder + getPostOrder(curNode.left);
		
		postorder = postorder + getPostOrder(curNode.right);
		
		postorder = postorder + curNode.data + " ";
		
		return postorder;
	}

	//------------------------------------------------------------------------
	//EVERYTHING BELOW THIS POINT IS IMPLEMENTED FOR YOU
	//YOU SHOULD STILL LOOK AT THIS CODE
	//------------------------------------------------------------------------
	
	/* A somewhat more pretty print method for debugging */
	public void printTree() {
		printTree(this.root, 0);
		System.out.println("\n\n");
	}
	private void printTree(TreeNode<T> curNode, int indentLev) {
		if(curNode == null) return;
		for(int i=0; i<indentLev; i++) {
			if(i == indentLev - 1) System.out.print("|-----");
			else System.out.print("      ");
		}
		System.out.println(curNode.data);
		printTree(curNode.left, indentLev+1);
		printTree(curNode.right, indentLev+1);
	}
	
	//TODO: Look at these methods and think about how they might be useful for this assignment
	public int height() {
		return height(root);
	}
	
	/* Computes the height of the tree on the fly */
	protected int height(TreeNode<T> node) {
		if(node == null) return 0;
		return node.height;
	}
}
