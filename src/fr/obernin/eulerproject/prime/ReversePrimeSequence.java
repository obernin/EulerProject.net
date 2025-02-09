/**
 * 
 */
package fr.obernin.eulerproject.prime;

import fr.obernin.eulerproject.tools.Sequence;

/**
 * @author <a href="mailto:obernin@gmail.com">Olivier Bernin</a>
 *
 */
public class ReversePrimeSequence extends Sequence<Integer> {
	
	public ReversePrimeSequence(int max) {
		super(max);
	}

	@Override
	public Integer Un(int n, Integer Uprevious) {
		
		int p = Uprevious;
		
		do {
			p--;
			
			if (p == 2)
				return null;
			
		} while (! PrimeFactorWalker.isPrime(p));
		
		return p;
	}
	
	public static void main(String[] args) {
		for (Integer p : new ReversePrimeSequence(100))
			System.out.println(" " + p);
	}
}
