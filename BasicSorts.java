package sorting;

public class BasicSorts {
	
	/*
	 * Swaps the elements and indices i and j in list
	 * */
	private static<T> void swap(T[] list, int i, int j) {
		/*OPTIONAL TODO: IMPLEMENT THIS METHOD*/
		T hold = list[i];
		list[i] = list[j];
		list[j] = hold;
	}
	
	/*
	 * Updates the elements of list to be in sorted order. Uses "bubble sort"
	 * */
	public static<T extends Comparable<T>> void bubbleSort(T[] list) {
		/* TODO: IMPLEMENT THIS METHOD */
		for(int i = 0; i < list.length - 1; i++) {
			for(int j = 0; j < list.length-i-1; j++) {
				if(list[j].compareTo(list[j + 1]) > 0) {
					swap(list, j, j+1);
				}
			}
		}
	}
	
	/*
	 * Updates the elements of list to be in sorted order. Uses "insertion sort"
	 * */
	public static<T extends Comparable<T>> void insertionSort(T[] list) {
		/* TODO: IMPLEMENT THIS METHOD */
		T hold;
		for(int i = 1; i < list.length; i++) {
			hold = list[i];
			int idx = -1;
			for(int j = i-1; j >= 0; j--) {
				if(hold.compareTo(list[j]) < 0) {
					list[j+1] = list[j];
				}
				else {
					idx = j;
					break;
				}		
			}
			list[idx+1] = hold;
		}
	}
	
}
