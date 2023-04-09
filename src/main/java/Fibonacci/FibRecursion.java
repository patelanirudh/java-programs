package Fibonacci;

public class FibRecursion {
	
	public static void main(String[] args) {
		int fibSeqCount = 6;
		FibRecursion object = new FibRecursion();
		
		for (int i = 0; i < fibSeqCount; i++) {
			System.out.printf("%d ", object.fibByRecursio(i));
		}
	}
	
	int fibByRecursio(int no) {
		if (no < 2)
			return no;
		
		return fibByRecursio(no - 1) + fibByRecursio(no - 2);
	}
}

//						fib(5)   
//					/                \
//				fib(4)                	fib(3)   
//			/        	\              	/       \ 
//		fib(3)      	fib(2)         fib(2)   fib(1)
//		/    \       	/    \        /      \
//	fib(2)   fib(1)  fib(1) fib(0) fib(1) fib(0)
//	/     \
//fib(1) fib(0)
