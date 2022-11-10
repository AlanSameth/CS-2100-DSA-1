package priorityqueue;

public class HeapSort {
	
	/*
	 * Accepts a list of type T and updates that list to be in sorted order.
	 * */
	public static <T extends Comparable<T>> void heapSort(T[] list) {
		/* TODO: IMPLEMENT THIS METHOD */
		MinHeap <T> sort = (MinHeap<T>)new MinHeap();
		for(int i = 0; i < list.length; i++) {
			sort.push(list[i]);
		}
		int i = 0;
		while(sort.size() != 0) {
			list[i] = sort.poll();
			i++;
		}
	}

}
