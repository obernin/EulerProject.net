/**
 * 
 */
package fr.obernin.eulerproject.prime;

import fr.obernin.eulerproject.tools.Sequence;

/**
 * @author <a href="mailto:obernin@gmail.com">Olivier Bernin</a>
 *
 */
public class PrimeSequence extends Sequence<Integer> {
	
	public PrimeSequence() {
		super(3);
	}

	@Override
	public Integer Un(int n, Integer Uprevious) {
		
		int p = Uprevious;
		
		do {
			p++;
		} while (! PrimeFactorWalker.isPrime(p));
		
		return p;
	}
	
	
	public static void main(String[] args) {
		for (Integer p : new PrimeSequence())
			System.out.println(" " + p);
	}
}
