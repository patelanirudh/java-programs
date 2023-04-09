package Search;

public class Linear {

//	private int[] arr = new int[]{20, 39, 10, 5, 7, 22}; // OR as below
	private int[] arr = {20, 39, 10, 5, 7, 22};
	
	public Linear() {
	}
	
	private void printArray() {
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Element arr[" + i + "] " + arr[i]);
		}
	}
	
	public static void main(String[] args) {
		int key = 22;
		Linear object = new Linear();
		object.printArray();
		
		int idx = object.linearSearch(key);
		if (idx >= 0)
			System.out.println("Key : " + key + " is present in array at index " + idx);
		else
			System.out.println("Key : " + key + " is not present in array");
	}
	
	private int linearSearch(int key) {
		int idx = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				idx = i;
				break;
			}
		}
		return idx;
	}
}
