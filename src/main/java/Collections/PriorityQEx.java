package Collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQEx {
	
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(10);

		pq.addAll(Arrays.asList(45, 2, 3, 77, 99, 1));

		Iterator<Integer> it = pq.iterator();
		System.out.println("PQ in iterator mode (unordered)");
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		Integer[] arr = new Integer[pq.size()];
		Arrays.sort(pq.toArray(arr)); // , Comparator.reverseOrder()

		System.out.println("PQ after Arrays.sort(pq.toArray) mode (ordered)" + arr);
		for (int i = 0; i < arr.length; ++i) {
			System.out.println(arr[i]);
		}

		// pq.poll() will return and remove element based on priority == Wrapper or
		// UserDefined comparable/comparators
	}
}
