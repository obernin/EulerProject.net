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
public class AmicableNumbers {
	
	public static List<Long> getProperFactors(long number) {
		
		double sqrt = Math.sqrt(number);
		List<Long> pf = new ArrayList<Long>();
		pf.add(1L);
		
		long p = 2;
		do {
			if (number % p == 0) {
				int size = pf.size();
				pf.add(size / 2, p);
				if (p != sqrt)
					pf.add(size / 2 + 1, number / p);
				//System.out.println(p + " * " + (number / p) + " = " + number);
			}
			p++;
		} while (p <= sqrt);
		
		return pf;
	}
	
	public static List<Long> getAmicableNumbersBelow(long number) {
		
		List<Long> amicableNumbers = new ArrayList<Long>();
		
		for (long i=1 ; i<number ; i++) {
			if (amicableNumbers.contains(i))
				continue;
			
			List<Long> properFactors = getProperFactors(i);
			long sum = 0;
			for (long factor : properFactors)
				sum += factor;
			//System.out.println(i + ": " + sum + " " + properFactors);
			
			properFactors = getProperFactors(sum);
			
			long sum2 = 0;
			for (long factor : properFactors)
				sum2 += factor;
			
			
			if (sum2 == i && sum != sum2) { 
				//System.out.println(i + ": " + sum + " " + sum2 + " " + properFactors);
				
				amicableNumbers.add(i);
				amicableNumbers.add(sum);
			}	
		}
		
		return amicableNumbers;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Long> amicableNumbers = getAmicableNumbersBelow(10000);
		System.out.println(amicableNumbers);
		
		long sum = 0;
		for (long amicableNumber : amicableNumbers)
			sum += amicableNumber;
		
		System.out.println(sum);
	}

}
