package Sorting;

import java.util.Arrays;

public class Selection {

	/*
	 * The algorithm maintains two subarrays in a given array.
	 * 
	 * The subarray which already sorted. The remaining subarray was unsorted. In
	 * every iteration of the selection sort, the minimum element (considering
	 * ascending order) from the unsorted subarray is picked and moved to the
	 * beginning of the sorted subarray.
	 * 
	 * After every iteration sorted sub-array size increase by one and the unsorted
	 * sub-array size decrease by one
	 * Right sub-array becomes sorted. Left sub-array becomes unsorted 
	 */

	public static void main(String[] args) {

		int[] arr = { 64, 25, 12, 22, 11, 3 };
		int n = arr.length;
		int min;

		for (int i = 0; i < n - 1; i++) {
			// Find the minimum element in unsorted array
			min = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[min])
					min = j;
			}
			// Swap the found minimum element with the first element
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}

		Arrays.stream(arr).forEach(elem -> System.out.printf("%d ", elem));
	}

}
