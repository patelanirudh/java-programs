package Fibonacci;

public class FibDynamic {

	public static void main(String[] args) {
		int fibSeqCount = 8;
		FibDynamic object = new FibDynamic();
		
		for (int i = 0; i < fibSeqCount; i++) {
			System.out.printf("%d ", object.fibByDynamic(i));
		}
	}
	
	private int fibByDynamic(int no) {
		// for no == 0 case; 1 extra to handle case, n = 0
		int[] f = new int[no + 2];
		
		/* 0th and 1st number of the series are 0 and 1*/
		f[0] = 0;
		f[1] = 1;
		
		// 0,1 handled above. Start with 2.
		for (int i = 2; i <= no; i++) {
			/* Add the previous 2 numbers in the series
	         and store it */
			f[i] = f[i-1] + f[i-2];
		}
		
		return f[no];
	}
}
