package priorityqueue;

import java.util.ArrayList;

public class MinHeap<T extends Comparable<T>> implements PriorityQueue<T> {

	/* The actual heap of data */
	private ArrayList<T> heap;
	
	public MinHeap() {
		/* TODO: IMPLEMENT THIS METHOD */
		heap = new ArrayList <T>();
		heap.add(null);
	}
	
	public MinHeap(ArrayList<T> data) {
		/* TODO: IMPLEMENT THIS METHOD */
		heap = data;
		heapify();
		
	}
	
	private void heapify() {
		/* TODO: IMPLEMENT THIS METHOD */
		ArrayList<T> newHeap = heap;
		heap = new ArrayList<T>();
		heap.add(0, null);
		for(int i = 0; i < newHeap.size(); i++) {
			push(newHeap.get(i));
		}
	}
	
	private void percolateUp(int index) {
		/* TODO: IMPLEMENT THIS METHOD */
		if(index <= 1) return;
	
		int pIndex = (int) Math.floor(index/2);
		
		
		if(heap.get(index).compareTo(heap.get(pIndex)) < 0) {
		
			swap(index, pIndex);
			percolateUp(pIndex);
		}
	}
	
	private void percolateDown(int index) {
		/* TODO: IMPLEMENT THIS METHOD */
		int min = 0;
		
		if(2*index > size()) {
			return;
		}
		T left = heap.get(2*index);
		if(2*index+1 > size()) {
			min = 2*index;
			if(heap.get(min).compareTo(heap.get(index)) < 0) {
				swap(min, index);
				percolateDown(min);
			}
		}
		else {
			T right = heap.get(2*index+1);
			if(left.compareTo(right) < 0) { 
				min = 2*index;
			}
			else {
				min = 2*index + 1;
			}
				
			if(heap.get(min).compareTo(heap.get(index)) < 0) {
				swap(min, index);
				percolateDown(min);
			}
		}
		/*if(leftIndex > size()) {
			return;
		}
		else if(rightIndex > size()) {
			T left = heap.get(leftIndex);
			if(left.compareTo(heap.get(index)) < 0) {
				swap(leftIndex, index);
			}
		}*/

			
	}
	
	@Override
	public void push(T data) {
		/* TODO: IMPLEMENT THIS METHOD */
		heap.add(data);
		
		percolateUp(size());
	}

	@Override
	public T poll() {
		/* TODO: IMPLEMENT THIS METHOD */
		if(heap.size() == 0) {
			return null;
		}
		T retain = heap.get(1);
		heap.set(1, heap.get(size()));
		heap.remove(size());
		percolateDown(1);
		return retain;
	}

	@Override
	public T peek() {
		/* TODO: IMPLEMENT THIS METHOD */
		return heap.get(1);
	}
	
	@Override
	public int size() {
		/* TODO: IMPLEMENT THIS METHOD */
		return heap.size() - 1;
	}
	
	public void swap(int child, int parent) {
		T hold = heap.get(parent);
		heap.set(parent, heap.get(child));
		heap.set(child, hold);
	}
	
}
