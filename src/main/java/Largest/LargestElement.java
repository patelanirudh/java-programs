package Largest;

import java.util.Arrays;

public class LargestElement {

	public static void main(String[] args) {
		int[] arr = {12, 40, 30, 100, 50, 90};
		
		Arrays.stream(arr).forEach(elem -> System.out.printf("%d ", elem));
		
		// set/assume largest
		int larg = arr[0];
		int idx = 0;
		
		for(int i = 1; i < arr.length; i++) {
			if (arr[i] > larg) {
				larg = arr[i];
				idx = i;
			}
		}
		System.out.println("\nLargest Element is " + larg + " @index " + idx);
	}
	
	/*	2nd Method:
	 *  	Arrays.sort(arr);
     *     	System.out.println("Largest number from given array: "+arr[arr.length-1]);
	 *  3rd Method:
	 *  	int arr[] = {10, 324, 45, 90, 9808};
     * 		int max = Arrays.stream(arr).max().getAsInt();
	 */
}
