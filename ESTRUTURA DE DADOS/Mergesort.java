package sorting.divideAndConquer;

import java.util.Arrays;

import sorting.SortingImpl;

public class Mergesort<T extends Comparable<T>> extends SortingImpl<T> {

	@Override
	protected void sort(T[] array, int leftIndex, int rightIndex) {

		if (leftIndex <= rightIndex && rightIndex < array.length
				&& leftIndex >= 0) {

			T[] subArrayOrdenado = mergeSort(Arrays.copyOfRange(array,
					leftIndex, rightIndex + 1));
			for (int i = 0; i < subArrayOrdenado.length; i++) {
				array[i + leftIndex] = subArrayOrdenado[i];
			}
		}
	}

	private T[] mergeSort(T[] array) {

		if (array.length == 1) {
			return array;
		}
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
