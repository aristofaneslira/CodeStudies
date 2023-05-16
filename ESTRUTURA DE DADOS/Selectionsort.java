package sorting.simpleSorting;

import sorting.SortingImpl;
import sorting.Util;

/**
 * The selection sort algorithm chooses the smallest (greatest) element form the array and 
 * puts it in the first (last) position. Then it repeats the same process to put the second 
 * smallest (greatest) element in the second (second from the end) position, and so on. 
 * The algorithm must sort the elements from leftIndex to rightIndex. 
 */
public class Selectionsort<T extends Comparable<T>> extends SortingImpl<T> {

	@Override
	protected void sort(T[] array, int leftIndex, int rightIndex) {
		for (int i = leftIndex; i < rightIndex; i++) {
			int min = i;
			for (int j = i+1; j <= rightIndex; j++) {
				if (array[j].compareTo(array[min]) < 0) {
					min = j;
				}
			}
			Util.swap(array, i, min);
		}

	}

}
