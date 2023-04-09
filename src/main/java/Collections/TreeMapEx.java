package Collections;

import java.util.Comparator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class TreeMapEx { // implements Comparable<TreeMapEx> {

	private String name;
	private static Random random = new Random();

	public TreeMapEx(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}

	// needed when we implement Comparable interface
//	@Override 
//	public int compareTo(TreeMapEx o1) {
//		return name.compareTo(o1.getName());
//	}

	public static void main(String[] args) {
		String[] names = { "Patel", "Anirudh", "Shilpi", "Shweta", "Papa", "Mummy" };
		// We can also add lastNames to our Object inside map below and make comparator
		// more complex : i.e consider both firstName and lastNames for sorting
		// String[] lastName = { "Patel", "Anirudh", "Shilpi", "Shweta", "Papa", "Mummy"
		// };

		// If we remove "new MyCustomeComparator()", we get error = cannot be cast to
		// class java.lang.Comparable
		// Since this is our user defined class and we should either implement
		// Comparable/Comparator or provide separate comparator
		// such as : MyCustomeComparator
		TreeMap<TreeMapEx, Integer> treeMap = new TreeMap<>(new MyCustomeComparator()); // remove this if we implement
																						// Comparable interface
		for (int i = 0; i < 6; i++) {
			treeMap.put(new TreeMapEx(names[i]), random.nextInt(50));
		}

		for (Map.Entry<TreeMapEx, Integer> entry : treeMap.entrySet()) {
			System.out.println("Key{TreeMapEx} : " + entry.getKey() + ", Age : " + entry.getValue());
		}

//		Works
//		treeMap.forEach((k, v) -> {
//			System.out.println("Key{TreeMapEx} : " + k + ", Age : " + v);
//		});

//		To make it synchronized
//		SortedMap<TreeMapEx, Integer> m = Collections.synchronizedSortedMap(treeMap);
	}

}

class MyCustomeComparator implements Comparator<TreeMapEx> {

	@Override
	public int compare(TreeMapEx o1, TreeMapEx o2) {
		// For descending order
		// return o2.getName().compareTo(o1.getName());

		return o1.getName().compareTo(o2.getName());
	};
}
