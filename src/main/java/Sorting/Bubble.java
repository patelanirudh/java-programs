package Sorting;

import java.util.Arrays;

public class Bubble {

	/*
	 * Bubble Sort is the simplest sorting algorithm that works by repeatedly
	 * swapping the adjacent elements if they are in the wrong order. This algorithm
	 * is not suitable for large data sets as its average and worst-case time
	 * complexity is quite high
	 *
	 * Run a nested for loop to traverse the input array using two variables i and
	 * j, such that 0 ≤ i < n-1 and 0 ≤ j < n-i-1 If arr[j] is greater than arr[j+1]
	 * then swap these adjacent elements, else move on Print the sorted array
	 * 
	 * Best : If array is already sorted
	 * 
	 */

	public static void main(String[] args) {

		int[] arr = { 64, 9, 12, 22, 10, 3 };
		int n = arr.length;
		
//		Every pass largest element is placed at the end.
//		Right sub-array is sorted. Left sub-array is unsorted

		for (int i = 0; i < n - 1; i++) {
			boolean swapped = false;
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}
			// inner loop did no swapping that means array is now sorted
			if (swapped == false)
				break;
		}

		Arrays.stream(arr).forEach(elem -> System.out.printf("%d ", elem));
	}

}
