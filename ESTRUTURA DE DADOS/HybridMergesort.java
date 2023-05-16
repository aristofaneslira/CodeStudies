package sorting.divideAndConquer.hybridMergesort;


import java.util.Arrays;

import sorting.SortingImpl;

/**
 * The algorithm is an hybrid of mergesort and insertion sort. Depending on the size of the input, 
 * the algorithm decides between the application of mergesort or insertion 
 * sort. The implementation of the algorithm must be in-place!
 */
public class HybridMergesort<T extends Comparable<T>> extends SortingImpl<T>{
	/**
	 * The limit to choose between applying merge or insertion. For inputs with size 
	 * less or equal to 4, apply insertion sort. 
	 */
	public static final int SIZE_LIMIT = 4;
	
	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;
	
	protected void sort(T[] array,int leftIndex, int rightIndex){
		
		if (leftIndex <= rightIndex && rightIndex < array.length
				&& leftIndex >= 0) {

			T[] subArrayOrdenado = mergeSort(Arrays.copyOfRange(array,
					leftIndex, rightIndex + 1));
			for (int i = 0; i < subArrayOrdenado.length; i++) {
				array[i + leftIndex] = subArrayOrdenado[i];
			}

		}
	}
	
	private T[] insertionSort(T[] array) {

		 for (int i = 1; i < array.length; i++) 
        {
                T key = array[i];
                for (int j = i - 1; j >= 0 && array[j].compareTo(key) > 0; j--)
                {
                        array[j + 1] = array[j];
                        array[j] = key;
                }
        }
		return array;       
	}
	
	private T[] mergeSort(T[] array) {

		if (array.length <= SIZE_LIMIT) {
			INSERTIONSORT_APPLICATIONS++;
			return insertionSort(array);
		}
		
		MERGESORT_APPLICATIONS++;
		
		int meio = array.length / 2;
		T[] listaEsquerda = mergeSort(Arrays.copyOfRange(array, 0, meio));
		T[] listaDireita = mergeSort(Arrays.copyOfRange(array, meio,
				array.length));
		return merge(listaDireita, listaEsquerda);
	}
	
	private T[] merge(T[] left, T[] right) {
		
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Comparable[left.length + right.length];

		int indiceLeft = 0, indiceRight = 0, indiceArray = 0;

		while (indiceLeft < left.length && indiceRight < right.length) {

			if (left[indiceLeft].compareTo(right[indiceRight]) <= 0) {
				result[indiceArray] = left[indiceLeft];
				indiceArray++;
				indiceLeft++;
			} else {
				result[indiceArray] = right[indiceRight];
				indiceArray++;
				indiceRight++;
			}
		}

		while (indiceLeft < left.length || indiceRight < right.length) {
			if (indiceLeft < left.length) {

				result[indiceArray] = left[indiceLeft];
				indiceArray++;
				indiceLeft++;

			}

			if (indiceRight < right.length) {

				result[indiceArray] = right[indiceRight];
				indiceArray++;
				indiceRight++;

			}
		}
		return result;
	}
}
