package tree;

public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T>{
	
	@Override
	public void insert(T data) {
		this.root = insert(data, this.root);
	}
	protected TreeNode<T> insert(T data, TreeNode<T> curNode) {
		//TODO: Implement this method
		
		curNode = super.insert(data, curNode);
		if(curNode == null) {
			return curNode;
		}
		else {
			curNode.height = changeHeight(curNode);
		}
		curNode = balance(curNode);
		return curNode;
	}

	@Override
	public void remove(T data) {
		this.root = remove(data, this.root);
	}
	protected TreeNode<T> remove(T data, TreeNode<T> curNode) {
		//TODO: Implement this method 
		curNode = super.remove(data, curNode);
		if(curNode == null){
			return null;
		}
		curNode.height = changeHeight(curNode);
		curNode = balance(curNode);
		return curNode;
	}
	
	/**
	 * Balances the given node. Assumes it is the lowest unbalanced node if unbalanced
	 * @param node
	 * @return
	 */
	private TreeNode<T> balance(TreeNode<T> curNode) {
		//TODO: Implement this method
		if(curNode == null) {
			return curNode;
		}
		int factor= balanceFactor(curNode);
		//Right Cases
		if(factor > 1) {
			if(balanceFactor(curNode.right) >= 0) {
				curNode = rotateLeft(curNode);
			}
			else {
				curNode.right = rotateRight(curNode.right);
				curNode = rotateLeft(curNode);
			}
		}
		//Left Cases
		if(factor < -1) {
			if(balanceFactor(curNode.left) <= 0) {
				curNode = rotateRight(curNode);
			}
			else {
				curNode.left = rotateLeft(curNode.left);
				curNode = rotateRight(curNode);
			}
		}
		return curNode;
	}
	
	private TreeNode<T> rotateRight(TreeNode<T> curNode) {
		//TODO: Implement this method
		TreeNode<T> lNew = curNode.left;
		TreeNode<T> LR = curNode.left.right;
		lNew.right = curNode;
		curNode.left = LR;
		
		//height recalculation
		curNode.height = changeHeight(curNode);
		lNew.height = changeHeight(lNew);
		
		return lNew;
	}
	
	private TreeNode<T> rotateLeft(TreeNode<T> curNode){
		//TODO: Implement this method
		TreeNode<T> rNew = curNode.right;
		TreeNode<T> RL = curNode.right.left;
		rNew.left = curNode;
		curNode.right = RL;
		
		//height recalculation
		curNode.height = changeHeight(curNode);
		rNew.height = changeHeight(rNew);
		
		return rNew;
	}
	
	private int changeHeight(TreeNode <T> curNode) {
		//if(curNode.right == null && curNode.left != null) {
			//return height(curNode.left) + 1;
		//}
		//else if(curNode.right != null && curNode.left == null) {
			//return height(curNode.right) + 1;
		//}
		if(curNode == null) {
			return 0;
		}
		return Math.max(height(curNode.right), height(curNode.left)) + 1;
	}
	
	private int balanceFactor(TreeNode<T> node) {
		//TODO: Implement this method
		if(node == null) {
			return 0;
		}
		return height(node.right) - height(node.left);
	}
	
	
}
