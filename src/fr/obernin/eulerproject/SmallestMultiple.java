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
public class SmallestMultiple {
	
	public static long getSmallestMultiple(int upTo) {
		
		long multiple = 1;
		List<Integer> factors = new ArrayList<Integer>();
		
		for (int i=2 ; i<=upTo ; i++) {
			if (multiple % i != 0) {
				int factor = i;
				for (int j=0 ; j<factors.size() ; j++) { 
					//System.out.println(multiple + " : " + i + " (" + factor + ", " + factors.get(j) + ", " + (factor % factors.get(j)) + ") " + factors) ;
					if (factor % factors.get(j) == 0)
						factor /= factors.get(j);
				}
				
				multiple *= factor;
				factors.add(factor);
				System.out.println(multiple + " : " + i + " (" + factor + ")") ;
			}
		}
		
		return multiple;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long m = getSmallestMultiple(20);
		System.out.println(m + " " + LargestPrimeFactor.getPrimeFactors(m));
	}

}
