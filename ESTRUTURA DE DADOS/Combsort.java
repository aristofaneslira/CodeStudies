package sorting.variationsOfBubblesort;

import sorting.SortingImpl;
import sorting.Util;

/**
 * The combsort algoritm. 
 */
public class Combsort<T extends Comparable<T>> extends SortingImpl<T> {
	@Override
	protected void sort(T[] array,int leftIndex, int rightIndex) {
		 	boolean troca = false;
	        int gap;

	        gap = rightIndex;
	        
	        while (troca || (gap > 1)){
	        	gap = (int) ((float) gap / 1.25);
	        	troca = false;

	            for (int i = 0; i < rightIndex + 1 - gap; i++) {
	                int j = i + gap;
	                if (array[i].compareTo(array[j]) > 0) {
	                	Util.swap(array, j, i);	                    
	                    troca = true;
	                }	                
	            }
	        }
	}
}
