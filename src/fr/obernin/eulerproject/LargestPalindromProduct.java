/**
 * 
 */
package fr.obernin.eulerproject;

import java.util.List;

/**
 * @author <a href="mailto:obernin@gmail.com">Olivier Bernin</a>
 *
 */
public class LargestPalindromProduct {
	
	public static long getLargestPalindromeNDigits(int n) {
		
		long min = Math.round(Math.pow(10.0, n - 1));
		long max = Math.round(Math.pow(10.0, n));
		
		for (long i=min ; i<max ; i++) {
			long palindrome = i * max;
			for (int j=0 ; j<n ; j++) {
				palindrome += ((i / Math.round(Math.pow(10.0, j))) % 10) * Math.round(Math.pow(10.0, n - j - 1));
			}
			
			List<Long> pf = LargestPrimeFactor.getPrimeFactors(palindrome);
			
			long a = 1;
			int sum = 0;
			for (int k=pf.size() - 1 ; k>=0 ; k --) {
				long factor = pf.get(k); 
				sum += factor;
				
				if (a * factor >= max)
					continue;
				else
					a *= factor;
			}
			
			//System.out.println(palindrome + " = " + a + " * " + (palindrome / a) + " " + pf + " " + sum);
			
			if (palindrome / a < max) {
				System.out.println(palindrome + " = " + a + " * " + (palindrome / a) + " " + pf + " " + sum);
				//return palindrome;
			}
		}
		
		return 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		getLargestPalindromeNDigits(3);
	}

}
