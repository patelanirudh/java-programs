package Search;

import java.util.Arrays;

public class Binary {

	public static int[] arr = { 50, 20, 10, 40, 30, 60, 70 };

	public Binary() {
	}

	private void printArray() {
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Element arr[" + i + "] " + arr[i]);
		}
	}

	public static void main(String[] args) {
		int key = 10;
		Binary object = new Binary();
		// Sort before Binary Search
		Arrays.sort(Binary.arr); 
		object.printArray();

		int found = object.binarySerach(key);
		if (found >= 0)
			System.out.println("Key : " + key + " is present in array at index " + found);
		else
			System.out.println("Key : " + key + " is not present in array");

		int left = 0;
		int right = arr.length - 1;
		key = 40;
		found = object.binaryRecursion(left, right, key);
		if (found >= 0)
			System.out.println("Binary Recursive Search Key : " + key + " is present in array at index " + found);
		else
			System.out.println("Binary Recursive Search Key : " + key + " is not present in array");
	}

	private int binarySerach(int key) {
		int left = 0;
		int right = arr.length - 1;
		int mid;
		while (left <= right) {
			mid = left + (right - left) / 2;

			if (arr[mid] == key)
				return mid;
			else if (arr[mid] < key)
				left = mid + 1;
			else if (arr[mid] > key)
				right = mid - 1;
		}
		return -1;
	}

	private int binaryRecursion(int left, int right, int key) {
		if (left <= right) {
			int mid = left + (right - left) / 2;

			if (arr[mid] == key)
				return mid;
			else if (arr[mid] < key)
				return binaryRecursion(mid + 1, right, key);
			else if (arr[mid] > key)
				return binaryRecursion(left, mid - 1, key);
		}
		return -1;
	}
}
