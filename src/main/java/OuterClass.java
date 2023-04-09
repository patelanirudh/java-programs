
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
		OuterClass.InnerStaticClass object = new OuterClass.InnerStaticClass();
		OuterClass.InnerStaticClass.staticPrint();
		object.print();
	}

}
