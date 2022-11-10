package list;

/**
 * 
 * A custom built linked list
 * T here is the type the list stores
 */
public class LinkedList<T> implements List<T>{

	/* Dummy head and tail */
	private ListNode<T> head, tail;
	private int size;
	
	public LinkedList() {
		/* TODO: Implement this method */
		head = new ListNode<T>(null);
		tail = new ListNode<T>(null);
		
		head.next = tail;
		head.prev = null;
		tail.prev = head;
		tail.next = null;
		
		size = 0;
	}
	
	public int size() {
		/* TODO: Implement this method */  
		return size;
	}
	
	/**
	 * Clears out the entire list
	 */
	public void clear() {
		/* TODO: Implement this method */
		
		head.next = tail;
		head.prev = null;
		tail.prev = head;
		tail.next = null;
		
		size = 0;
	}
	
	/**
	 * Inserts new data at the end of the list (i.e., just before the dummy tail node)
	 * @param data
	 */
	public void insertAtTail(T data) {
		/* TODO: Implement this method */
		ListNode<T> newNode = new ListNode<T> (data);
		newNode.next = tail;
		newNode.prev = tail.prev;
		ListNode<T> hold = tail.prev;
		hold.next = newNode;
		tail.prev = newNode;
		
		size++;
		
	}
	
	/**
	 * Inserts data at the front of the list (i.e., just after the dummy head node
	 * @param data
	 */
	public void insertAtHead(T data) {
		/* TODO: Implement this method */
		ListNode<T> newNode = new ListNode<T> (data);
		newNode.next = head.next;
		newNode.prev = head;
		ListNode<T> hold = head.next;
		hold.prev = newNode;
		head.next = newNode;
		
		size++;
	}
	
	/**
	 * Inserts node such that index becomes the position of the newly inserted data
	 * @param data
	 * @param index
	 */
	public void insertAt(int index, T data) {
		/* TODO: Implement this method  */ 
		if(index == 0)
			insertAtHead(data);
		
		else if(index == size)
			insertAtTail(data);
		
		else {
			ListNode<T> holdNode = head.next;
			for(int i = 0; i < index - 1; i++) {
					holdNode = holdNode.next;
			}
			
			ListNode <T> newNode = new ListNode<T>(data);
			newNode.next = holdNode.next;
			newNode.prev = holdNode;
			
			holdNode.next.prev = newNode;
			holdNode.next = newNode;
				
			size++;
		}
		
		
	}
	
	/**
	 * Inserts data after the node pointed to by iterator
	 */
	public void insert(ListIterator<T> it, T data) {
		/* TODO: Implement this method */  
		ListNode <T> newNode = new ListNode<T>(data);
		if(it.value() == null) {
			insertAtTail(data);
		}
		else {
			newNode.next = it.curNode.next;
			newNode.prev = it.curNode;
		
			it.curNode.next.prev = newNode;
			it.curNode.next = newNode;
			size++;
		}
	}
	
	
	
	public T removeAtTail(){
		/* TODO: Implement this method */ 
		tail.prev.prev.next = tail;
		T removed = tail.prev.getData();
		tail.prev = tail.prev.prev;
		
		size--;
		
		return removed;
	}
	
	public T removeAtHead(){
		/* TODO: Implement this method */ 
		head.next.next.prev = head;
		T removed = head.next.getData();
		head.next = head.next.next;
		
		size--;
		
		return removed;
	}
	
	/**
	 * Remove based on Iterator position
	 * Sets the iterator to the node AFTER the one removed
	 */
	public T remove(ListIterator<T> it) {
		/* TODO: Implement this method */
		T hold = it.value();
		if(hold == null) {
			removeAtHead();
		}
		else {
			ListNode <T> prevNode = it.curNode.prev;
			prevNode.next = it.curNode.next;
			it.moveForward();
			it.curNode.prev = prevNode;
			size--;
		}
		return hold;
	}
	
	/**
	 * Returns index of first occurrence of the data in the list, or -1 if not present
	 * @param data
	 * @return
	 */
	public int find(T data) {
		/* TODO: Implement this method */  
		ListNode <T> curNode = head.next;
		for(int i = 0; i < size; i++) {
			if(curNode.getData().equals(data)) {
				return i;
			}
			curNode = curNode.next;
		}	
		return -1;
	}
	
	/**
	 * Returns the data at the given index, null if anything goes wrong (index out of bounds, empty list, etc.)
	 * @param index
	 * @return
	 */
	public T get(int index) { 
		/* TODO: Implement this method */
		if( index < 0 || size == 0 || index > size) {
			return null;
		}
		ListNode <T> curNode = head.next;
		for(int i = 0; i < index; i++) {
			curNode = curNode.next;
		}
		return curNode.getData();
		
	}
	
	/**
	 * Returns the list as space separated values
	 */
	public String toString() {
		String toRet = "[";
		
		ListNode<T> curNode = head.next;
		while(curNode != tail) {
			toRet += curNode.getData() + ", ";
			curNode = curNode.next;
		}
		
		return toRet + "]";
	}
	
	/* Return iterators at front and end of list */
	public ListIterator<T> front(){ 
		/* TODO: Implement this method */ 
		ListIterator<T> front = new ListIterator<T> (head.next);
		return front;
	}

	public ListIterator<T> back(){
		/* TODO: Implement this method */ 
		ListIterator<T> back = new ListIterator<T> (tail.prev);
		return back;
	}
	
	
}
