/**
 * 
 */
package fr.obernin.eulerproject;

import java.util.Arrays;

/**
 * @author <a href="mailto:obernin@gmail.com">Olivier Bernin</a>
 *
 */
public class SpecialPythagoreanTriplet {
	
	public static long[] getPythagoreanTripletWithSum(long sum) {
		
		for (long a=1 ; a<sum ; a++) {
			for (long b=a ; b<sum ; b++) {
				long c = sum - (a + b);
				
				if (a * a + b * b - c * c == 0)
					return new long[] { a, b, c };
			}
		}
		
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long[] triplet = getPythagoreanTripletWithSum(1000);
		System.out.println(Arrays.toString(triplet) + ": " + triplet[0] * triplet[1] * triplet[2]);
	}

}
