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
public class NthPrime {
	
	public static long getNthPrime(int n) {
		
		List<Long> primes = new ArrayList<Long>();
				
		long p = 2;
		while (primes.size() < n) {
			boolean prime = true;
			for (int i=0 ; i<primes.size() ; i++) {
				if (p % primes.get(i) == 0) {
					prime = false;
					break;
				}
			}
			
			if (prime)
				primes.add(p);
			p++;
		}
		
		return primes.get(primes.size() - 1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getNthPrime(10001));

	}

}
