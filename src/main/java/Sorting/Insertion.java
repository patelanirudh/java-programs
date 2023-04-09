package Sorting;

import java.util.Arrays;

public class Insertion {
	
	/*
	 *  The array is virtually split into a sorted and an unsorted part.
	 *  Values from the unsorted part are picked and placed at the correct position in the sorted part.
	 *  
	 * 	Basically, Insertion sort is efficient for small data values
	 * 	Insertion sort is adaptive in nature, i.e. it is appropriate for data sets which are already partially sorted.
	 * 
	 */
	
	public static void main(String[] args) {
		int[] arr = {4,3,2,10,12,1};
		int n = arr.length;
		
		for(int i = 1; i < n; i++ )
		{
			int key = arr[i];
			int j = i - 1;
			// back-traversing j and comparing it with key in inner loop
			// shift elements greater than key one position ahead of their
			// current position
			while(j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j = j -1;
			}
			arr[j+1] = key;
		}
		
		Arrays.stream(arr).forEach(elem -> System.out.printf("%d ", elem));
	}

}
