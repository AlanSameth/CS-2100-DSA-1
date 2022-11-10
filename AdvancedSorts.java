package sorting;

public class AdvancedSorts {

	
	
	public static<T extends Comparable<T>> void mergeSort(T[] list) {
		mergeSort(list, 0, list.length-1);
	}
	
	private static<T extends Comparable<T>> void mergeSort(T[] list, int i, int j) {
		/* TODO: IMPLEMENT THIS METHOD */
		if(i < j) {
			int mid = (j+i)/2;
			mergeSort(list, i, mid);
			mergeSort(list, mid + 1, j);
			merge(list, i, mid, j);
		}
	
	}
	
	private static<T extends Comparable<T>> void merge(T[] list, int i, int mid, int j) {
		/* TODO: IMPLEMENT THIS METHOD */
		int leftArraySize = mid - i + 1;
		int rightArraySize = j - mid;
		
		T[] left = (T[])new Comparable[leftArraySize];
		T[] right = (T[]) new Comparable[rightArraySize];
		
		for(int k = 0; k < leftArraySize; k++) {
			left[k] = list[i + k];
		}
		for(int k = 0; k < rightArraySize; k++) {
			right[k] = list[mid + k + 1];
		}
		
		int r = 0; int l = 0; int index = i;
		
		while(l < leftArraySize && r < rightArraySize) {
			if(left[l].compareTo(right[r]) <= 0) {
				list[index] = left[l];
				l++;
			}
			else {
				list[index] = right[r];
				r++;
			}
			index++;
		}
		
		while(l < leftArraySize) {
			list[index] = left[l];
			l++;
			index++;
		}
		
		while(r < rightArraySize) {
			list[index] = right[r];
			r++;
			index++;
		}
			
	}
	
	
	
	
	
	
	
	public static<T extends Comparable<T>> void quickSort(T[] list) {
		quickSort(list, 0, list.length-1);
	}
	
	private static<T extends Comparable<T>> void quickSort(T[] list, int i, int j) {
		/* TODO: IMPLEMENT THIS METHOD */
		if(i < j) {
			int pivot = partition(list, i ,j);
			quickSort(list, i, pivot - 1);
			quickSort(list, pivot+1, j);
		}
	}
	
	private static<T extends Comparable<T>> int partition(T[] list, int i, int j) {
		/* TODO: IMPLEMENT THIS METHOD */
		 //Get random number for pivot
		T pivot = list[(j+i)/2];
		
		int h = i - 1;
		
		
		T hold;
		for(int k = i; k <= j -1; k++) {
			if(pivot.compareTo(list[k]) > 0) {
				h++;
				hold = list[k];
				list[k] = list[h];
				list[h] = hold;
			}
		}
		
		list[j] = list[h+1];
		list[h+1] = pivot;
		return h+1;
	}
	
	public static<T extends Comparable<T>> void hybridSort(T[] list) {
		hybridSort(list, 0, list.length-1);
	}
	
	private static<T extends Comparable<T>> void hybridSort(T[] list, int i, int j) {
		/* TODO: IMPLEMENT THIS METHOD */
		if(i < j) {
			if(j - 1 < 100) {
				T hold;
				for(int k = i; k < j; k++) {
					hold = list[k];
					int idx = -1;
					for(int l = k-1; l >= 0; l--) {
						if(hold.compareTo(list[l]) < 0) {
							list[l+1] = list[l];
						}
						else {
							idx = l;
							break;
						}		
					}
					list[idx+1] = hold;
				}
			}
			else {
				int pivot = partition(list, i ,j);
				hybridSort(list, i, pivot - 1);
				hybridSort(list, pivot+1, j);
			}
		}
	}
	
	
	
	
	
	

}
