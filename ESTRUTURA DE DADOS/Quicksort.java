/**
 * 
 */
package sorting.divideAndConquer;

import sorting.SortingImpl;
import sorting.Util;

public class Quicksort<T extends Comparable<T>> extends SortingImpl<T> {

	@Override
	protected void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= rightIndex)
			return;
		int m = partition(array, leftIndex, rightIndex);
		sort(array, leftIndex, m - 1);
		sort(array, m + 1, rightIndex);

	}

	private int partition(T[] array, int leftIndex, int rightIndex) {
		
		int indiceEsquerda = leftIndex+1; 
		int indiceDireita = rightIndex;
		T p = array[leftIndex]; 
		while (indiceEsquerda<=indiceDireita) {
			if (array[indiceEsquerda].compareTo(p) <= 0) indiceEsquerda++;
			else if (array[indiceDireita].compareTo(p) > 0)
				indiceDireita--;
			else
				Util.swap(array, indiceEsquerda, indiceDireita);
			} 
		Util.swap(array, leftIndex, indiceDireita);
		return indiceDireita; 
	}
}
