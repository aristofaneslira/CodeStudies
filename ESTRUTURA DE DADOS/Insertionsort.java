package sorting.simpleSorting;

import sorting.SortingImpl;

/**
 * The insertion sort algorithm consumes the array (element by element) and inserts the elements 
 * into an ordered list. The algorithm must sort the elements from 
 * leftIndex to rightIndex (inclusive). 
 */
public class Insertionsort<T extends Comparable<T>> extends SortingImpl<T> {

	@Override
	protected void sort(T[] array, int leftIndex, int rightIndex) {
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			T key = array[i];
			int j = i-1;
			while (j > 0 && array[j].compareTo(key) > 0){
				array[j+1] = array[j];
			}
			array[j+1] = key;
		}
	}
}
