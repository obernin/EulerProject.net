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
public class LargestPrimeFactor {
	
	public static List<Long> getPrimeFactors(long number) {
		
		List<Long> pf = new ArrayList<Long>();
		
		long p = 2;
		while (number > 1) {
			while (number % p == 0) {
				pf.add(p);
				number /= p;
//				System.out.println(p + ": " + factor + " (" + number + ")");
			}
			p++;
		}
		
		return pf;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Long> pf = getPrimeFactors(600851475143L);
		System.out.println(pf.get(pf.size() - 1));

	}

}
