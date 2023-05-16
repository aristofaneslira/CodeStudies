package sorting.linearSorting;



import sorting.SortingImpl;

public class Countingsort extends SortingImpl<Integer> {

	@Override
	protected void sort(Integer[] array,int leftIndex, int rightIndex) {
		Integer[] resultado = new Integer[rightIndex];
		
		int maior = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] >= maior) {
				maior = array[i];
			}
		}
		Integer[] aux = new Integer[maior];
		for (int i = 0; i < aux.length; i++) {
			aux[i] = 0;
		}
		for (int i = 0; i < rightIndex; i++) {
			aux[array[i]] += 1;
		}
	}

}
