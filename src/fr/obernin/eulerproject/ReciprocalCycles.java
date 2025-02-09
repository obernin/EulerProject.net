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
public class ReciprocalCycles {
	
	public static long getDecimalRepresentationPeriod(long inverse) {
		
		long r = 1;
		long period = 0;
		List<Long> remainders = new ArrayList<Long>();
		
		do {
			r = (10 * r) % inverse;
			
			for (int i=0 ; i<remainders.size() ; i++) {
				long remainder = remainders.get(i);
				if (remainder == r) {
					period = remainders.size() - i;
					break;
				}
			}
			remainders.add(r);
		} while (r != 0 && period == 0);
		
		
		return period;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int number = 0;
		long maxPeriod = 0;
		
		long start = System.currentTimeMillis();
		for (number=999 ; number>maxPeriod; number--) {
			long period = getDecimalRepresentationPeriod(number);
			
			if (period > maxPeriod) {
				maxPeriod = period;
				//System.out.println(i + ": " + period);
			}
		}
		long stop = System.currentTimeMillis();
		
		System.out.println(number + " [" + (stop - start) + " ms]");
	}

}
