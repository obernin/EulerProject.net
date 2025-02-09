/**
 * 
 */
package fr.obernin.eulerproject;

import java.math.BigInteger;

/**
 * @author <a href="mailto:obernin@gmail.com">Olivier Bernin</a>
 *
 */
public class ThousandDigitFibonacciTerm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BigInteger n = new BigInteger("1");
		BigInteger nMinus1 = new BigInteger("1");
		
		int count = 2;
		while (n.toString().length() < 1000) {
			BigInteger currentN = n;
			n = n.add(nMinus1);
			nMinus1 = currentN;
			count++;
		}

		System.out.println(count + ": " + n);
	}

}
