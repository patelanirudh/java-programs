package Sorting;

public class StringSelectionSort {

	// Java program to perform the sorting
	// operation on a string array

	public static void main(String[] args) {
		String[] arr = { "Apple", "Cat", "Ball", "Cartoon", "Banana", "Avocado" };

		// selection sorting the String array
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j].compareTo(arr[min]) < 0) {
					min = j;
				}
			} // second for
			String temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
		
		for (String i : arr) {
			System.out.print(i + " ");
		}
		
		// Via Collections Sort
//		Collections.sort(Arrays.asList(arr));
//		for (String i : arr) {
//			System.out.print(i + " ");
//		}
		
	}
	
}
