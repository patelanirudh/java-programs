public class OuterClass {

	private static int i = 10;
	private static int j = 20;

	public static void display() {
		System.out.println("OuterClass static method display() accessing its static member " + j);
	}

	public OuterClass() {
		System.out.println("OuterClass Ctor");
	}

	static class InnerStaticClass {
		public InnerStaticClass() {
			System.out.println("InnerStaticClass Ctor accessing outer class private static member " + i);
		}
		
		private String name="Anirudh";
		
		public void print() {
			System.out.println("InnerStaticClass non-static member function print() " + name);
			OuterClass.display();
		}
		
		public static void staticPrint() {
			System.out.println("InnerStaticClass static member function staticPrint() accessing outer class private static member " + j);
		}
	}

	public static void main(String[] args) {
		// static inner class object which is as follows:
		// OuterClass.InnerStaticClass variable = new
		// OuterClass.InnerStaticClass();
		// Only static class Ctor is invoked, not OuterClass
//		OuterClass.InnerStaticClass object = new OuterClass.InnerStaticClass();
//		OuterClass.InnerStaticClass.staticPrint();
//		object.print();
		
//		Map<String, Integer> map1 = new HashMap<>();
//		String str1 = "Hello";
//		map1.put(str1, 1);
//		String str2 = new String("Hello");
//		map1.put(str2, 2);
//		String str3 = new String("Hello");
//		map1.put(str3, 3);
//		System.out.println(map1.size());
//		System.out.println(map1.get("Hello"));
//		System.out.println(map1.get(new String("Hello")));
//		System.out.println(str1.equals(str2));
//		System.out.println(str2.equals(str3));
//		System.out.println(str1.equals(str3));
//		System.out.println(str1.hashCode());
//		System.out.println(str2.hashCode());
//		System.out.println(str1.hashCode());
		
		
		String str1 = "HashMap";
		String str2 = "Hash" + "Map";
		String str3 = "Hash".concat("Map");

		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		System.out.println(str3.hashCode());

		System.out.println(str1 == str2);
		System.out.println(str1 == str3);
		System.out.println(str2 == str3);
		System.out.println(str2.equals(str3));
		System.out.println(str2.equals(str1));
		
	}

}
