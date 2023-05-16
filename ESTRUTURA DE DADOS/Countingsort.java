package sorting.linearSorting;



import sorting.SortingImpl;

public class Countingsort extends SortingImpl<Integer> {

	@Override
	protected void sort(Integer[] array,int leftIndex, int rightIndex) {
		if (rightIndex >= 2) { 
			  
            int k = 100; 
  
            Integer[] aux = new Integer[k + 1]; 
            Integer[] resposta = new Integer[rightIndex - leftIndex + 1]; 
            for (int i = 0; i <= k; i++) { 
                aux[i] = 0; 
            } 
            for (int j = 0; j < array.length; j++) { 
                aux[array[j]] += 1; 
            } 
            for (int i = 1; i <= k; i++) { 
                aux[i] += aux[i - 1]; 
            } 
            for (int j = rightIndex; j >= leftIndex; j--) { 
                resposta[aux[array[j]] - 1] = array[j]; 
                aux[array[j]]--; 
            } 
  
            for (int i = leftIndex; i <= rightIndex; i++) { 
                array[i] = resposta[i]; 
            }
		}
	}
	
}
