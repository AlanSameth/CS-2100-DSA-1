package priorityqueue;

import java.util.ArrayList;
import java.util.LinkedList;

public class PriorityQueueImplementation <T extends Comparable<T>>{
	
	LinkedList <T> queue;
	
	public PriorityQueueImplementation() {
		/* TODO: IMPLEMENT THIS METHOD */
		queue = new LinkedList<T>();
	}
	
	
	public void push(T data) {
		/* TODO: IMPLEMENT THIS METHOD */
		queue.add(data);
		
	}
	public T poll() {
		/* TODO: IMPLEMENT THIS METHOD */
		int i = 0;
		T remove = queue.get(0);
		for(int j = 1; j<queue.size(); j++) {
			if(queue.get(j).compareTo(remove) < 0) {
				remove = queue.get(j);
				i=j;
			}
		}
		queue.remove(i);
		return remove;
	}


	public T peek() {
		/* TODO: IMPLEMENT THIS METHOD */
		T hold = queue.get(0);
		for(int j = 1; j<queue.size(); j++) {
			if(queue.get(j).compareTo(hold) < 0) {
				hold = queue.get(j);
	
			}
		}
		return hold;
		
	}
}
