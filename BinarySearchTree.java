package tree;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> implements Tree<T>{
	
	@Override
	public void insert(T data) {
		this.root = insert(data, root);
	}
	
	/**
	 * Helper method for inserting recursively
	 * @param data
	 * @param curNode
	 * @return a reference to the new root of the subtree
	 */
	protected TreeNode<T> insert(T data, TreeNode<T> curNode) {
		//TODO: Implement this method
		if(curNode == null) {
			return new TreeNode<T>(data);
		}
		if (data.compareTo(curNode.data) < 0) {
			curNode.left = insert(data, curNode.left);;
		}
		else if (data.compareTo(curNode.data) > 0) {
			curNode.right = insert(data, curNode.right);
		}
		curNode.height = Math.max(height(curNode.right), height(curNode.left)) + 1;
		return curNode;
	}

	@Override
	public boolean find(T data) {
		return find(data, root);
	}
	
	private boolean find(T data, TreeNode<T> curNode) {
		//TODO: Implement this method
		if(curNode == null) {
			return false;
		}
		else if (data.compareTo(curNode.data) < 0)
			return find(data, curNode.left);
		else if (data.compareTo(curNode.data) > 0)
			return find(data, curNode.right);
		else {
			return true;
		}
	}

	@Override
	public void remove(T data) {
		this.root = remove(data, root);
	}
	
	protected TreeNode<T> remove(T data, TreeNode<T> curNode) {
		//TODO: Implement this method
		if(curNode == null) {
			return curNode;
		}
		int compare = data.compareTo(curNode.data);
		if(compare < 0) {
			curNode.left = remove(data, curNode.left);
		}
		else if(compare > 0) {
			curNode.right = remove(data, curNode.right);
		}
		else {
			//no children
			if(curNode.left == null && curNode.right == null) {
				return null;
			}
			//one children
			else if(curNode.right == null && curNode.left !=null) {
				return curNode.left;
			}
			else if(curNode.left == null && curNode.right != null) {
				return curNode.right;
			}
			//two children
			else {
				T max = findMax(curNode.left);
				curNode.data = max;
				curNode.left = remove(max, curNode.left);
				return curNode;
			}
			//if(curNode.left.right == null) {
				//curNode.left = remove(curNode.data, curNode.left);
			//}
			//else {
				//curNode.right = remove(curNode.data, curNode.right);
			//}
		}
		return curNode;
	}
	
	/**
	 * Returns the max item in the given subtree
	 */
	public T findMax() {
		return findMax(this.root);
	}
	private T findMax(TreeNode<T> curNode) {
		//TODO: Implement this method
		if(curNode.right == null) {
			return curNode.data;
		}
		else {
			return (T) findMax(curNode.right);
		}
	}
}
