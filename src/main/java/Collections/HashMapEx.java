package Collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class HashMapEx {

	private static Random random = new Random();

	public static void main(String[] args) {
		Map<Integer, Integer> hm = new HashMap<>();
		
		System.out.println("HashMap Integers Key Value Frequency Count !!!");
		for (int i = 0; i < 10; i++) {
			int key = random.nextInt(10);
			if (hm.containsKey(key)) {
				// get the value for the key (which is 1 in else case) and add + 1 to increase
				// the frequency count
				// this is updation of value for same key and not insertion of new elements
				hm.put(key, hm.get(key) + 1);
			} else {
				// insert 1 as frequency count of key
				hm.put(key, 1);
			}
		}
		hm.forEach((k, v) -> System.out.println("Key : " + k + ", Value : " + v));

		System.out.println("LinkedHashMap Characters Key Value Frequency Count !!!");
		Map<Character, Integer> hm2 = new LinkedHashMap<>();
		String name = "aanniruddh";

		for (int i = 0; i < name.length(); ++i) {
			// get the value for the key (which is 1 in else case) and add + 1 to increase
			// the frequency count
			// this is updating the value for same key and not insertion of new elements
			// Each Character (of the input string) becomes the key
			if (hm2.containsKey(name.charAt(i))) {
				hm2.put(name.charAt(i), hm2.get(name.charAt(i)) + 1);
			} else {
				// insert 1 as frequency count of key
				hm2.put(name.charAt(i), 1);
			}
		}
						
		for (Map.Entry<Character, Integer> entry : hm2.entrySet()) {
			System.out.println("Key : " + entry.getKey() + ", Value : " + entry.getValue());
		}	
	}

}
