package Sorting;

import java.util.Arrays;

public class InsertionSortPositiveNegative {

	public static void main(String[] args) {
		int[] arr = { 4, 3, -2, 10, -12, -1, 30 };
		int n = arr.length;

		// This is not sorting just separating +ve and -ve elements

		for (int i = 1; i < n; i++) {
			int key = arr[i];

			if (key > 0)
				continue;

			// only for negative key above, shift positive elements towards right
			// like in basic insertion sort we shift greater element one position
			// ahead of their current position
			int j = i - 1;
			while (j >= 0 && arr[j] > 0) {
				// positive no copied one position ahead
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}

		Arrays.stream(arr).forEach(elem -> System.out.printf("%d ", elem));
	}
}
