package sorting.variationsOfBubblesort;

import sorting.SortingImpl;
import sorting.Util;

/**
 * The implementation of the algorithm must be in-place! 
 */
public class Gnomesort<T extends Comparable<T>> extends SortingImpl<T>{
	protected void sort(T[] array,int leftIndex, int rightIndex){
		int pos = 1;
		while (pos <= rightIndex){
			if (array[pos].compareTo(array[pos-1]) >= 0){ 
				 pos += 1; 
			} else{
				Util.swap(array, pos, pos -1);
				if (pos > 1){  
					pos -= 1; 
				} else{ 
				 pos += 1;
				}
			}
		}		
	}
}
