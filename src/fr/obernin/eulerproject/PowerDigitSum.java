/**
 * 
 */
package fr.obernin.eulerproject;

import java.math.BigInteger;

/**
 * @author <a href="mailto:obernin@gmail.com">Olivier Bernin</a>
 *
 */
public class PowerDigitSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BigInteger n = new BigInteger("2");
		n = n.pow(1000);

		int count = 0;
		String str = n.toString();
		for (int i=0 ; i<str.length() ; i++)
			count += Integer.parseInt(str.substring(i, i + 1));
		System.out.println(count);
	}

}
