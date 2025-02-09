/**
 * 
 */
package fr.obernin.eulerproject;

/**
 * @author <a href="mailto:obernin@gmail.com">Olivier Bernin</a>
 *
 */
public class EvenFinbonacci {
	
	public static long getEvenFibonacciNumberSum(int max, int u0, int u1) {
		
		int next = 0;
		int prev = u1;
		int prevprev = u0;
		
		long sum = 0;
		if (prevprev % 2 == 0)
			sum += prevprev;
		if (prev % 2 == 0)
			sum += prev;
		
		while ((next = prevprev + prev) < max) {
			if (next % 2 == 0)
				sum += next;

			System.out.println(next + ": " + sum);

			prevprev = prev;
			prev = next;
		}
		
		return sum;
	}
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getEvenFibonacciNumberSum(4000000, 1, 2));
	}

}
