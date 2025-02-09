/**
 * 
 */
package fr.obernin.eulerproject;

import fr.obernin.eulerproject.prime.PrimeFactorWalker;
import fr.obernin.eulerproject.prime.ReversePrimeSequence;

/**
 * @author <a href="mailto:obernin@gmail.com">Olivier Bernin</a>
 *
 */
public class QuadraticPrime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int maxseq = 0;
		ReversePrimeSequence rps = new ReversePrimeSequence(997);

		for (int b : rps) {
			for (int a = -999 ; a < 1000 ; a++) {
				int n = 0;
				
				do n++; 
				while (PrimeFactorWalker.isPrime(n * n + a * n + b));
				
				if (n > maxseq) {
					maxseq = n;
					System.out.println("(" + a + ", " + b + "): " + (n+1) + " - " + (a*b));
				}
			}
			
			if (b < maxseq)
				break;
		}
	}

}
