package Factorial;

public class FactorialOne {

	public static void main(String[] args) {
		int factorialNo = 5;
		FactorialOne factObject = new FactorialOne();
		factObject.doFactorial(factorialNo);
		System.out.println("Recursion Fact " + factObject.doFactorialRecursion(5));
	}
	
	public void doFactorial(int no) {
		int i = 1;
		int temp = no;
		while (no > 0) {
			i = no * i;
			--no;
		}
		System.out.println("Factorial of " + temp + " is " + i);
	}
	
	public int doFactorialRecursion(int no) {
		if (no == 1)
			return no;
		
		return no * doFactorialRecursion(no-1);
	}
	
}
