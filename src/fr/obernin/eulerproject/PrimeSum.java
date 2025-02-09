/**
 * 
 */
package fr.obernin.eulerproject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:obernin@gmail.com">Olivier Bernin</a>
 *
 */
public class PrimeSum {
	
	public static long getPrimeSum(int max) {
		
		long sum = 2;
		List<Long> primes = new ArrayList<Long>();
		primes.add(2L);
				
		long p = 3;
		do {
			boolean prime = true;
			double sqrt = Math.sqrt(p);
			for (int i=0 ; primes.get(i) <= sqrt ; i++) {
				if (p % primes.get(i) == 0) {
					prime = false;
					break;
				}
			}
			
			if (prime) {
				sum += p;
				primes.add(p);
			}
			p++;
		} while (p < max);
		
		return sum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getPrimeSum(2000000));
	}

}
