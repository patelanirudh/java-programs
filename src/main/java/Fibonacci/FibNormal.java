package Fibonacci;

public class FibNormal {
	
	public static void main(String[] args) {
		int fibNumberSeq = 6; // this is after 0 and 1
		
		int f0 = 0, f1 = 1, fib;
		System.out.printf("%d %d ",f0, f1);
		
		for (int i = 0; i < fibNumberSeq; i++) {
			fib = f0 + f1;
			f0 = f1;
			f1 = fib;
			System.out.printf("%d ", fib);
		}
		
		// In this consider 0 and 1 printing inside the loop and loop count should be 2 less than the requested fibSequenceCount
//		for (int i = 0; i < fibNumberSeq - 2; i++) {
//			if (i == 0)
//				System.out.printf("%d ",f0);
//			else if (i == 1)
//				System.out.printf("%d ", f1);
//			
//			fib = f0 + f1;
//			f0 = f1;
//			f1 = fib;
//			System.out.printf("%d ", fib);
//		}
	}

}
