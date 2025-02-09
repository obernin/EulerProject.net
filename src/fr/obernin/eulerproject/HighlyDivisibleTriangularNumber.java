/**
 * 
 */
package fr.obernin.eulerproject;

/**
 * @author <a href="mailto:obernin@gmail.com">Olivier Bernin</a>
 *
 */
public class HighlyDivisibleTriangularNumber {
	
	public static long getHighlyDivisibleTriangularNumber(int factors) {
		
		int n=1;
		long t = 0;
		int count = 0;
		
		do {
			n++;
			count = 0;
			t = n * (n + 1) / 2;
			
			//System.out.print(t + " (" + n + "): ");
			
			double sqrt = Math.sqrt(t);
			for (int i=1 ; i<sqrt ; i++) {
				if (t % i == 0) {
					//System.out.print(i + ", " + (t / i) + ", ");
					count++;
				}
			}
			//System.out.println();
		} while(count * 2 < factors);
		
		return t;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		long n = getHighlyDivisibleTriangularNumber(500);
		System.out.println(n + " - " + (System.currentTimeMillis() - start) + " ms");
	}

}
