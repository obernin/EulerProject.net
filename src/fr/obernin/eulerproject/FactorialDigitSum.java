/**
 * 
 */
package fr.obernin.eulerproject;

import java.math.BigInteger;

/**
 * @author <a href="mailto:obernin@gmail.com">Olivier Bernin</a>
 *
 */
public class FactorialDigitSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BigInteger n = new BigInteger("1");
		int base = 0;
		
		do {
			for (int i=1 ; i<11 ; i++) {
				switch (i) {
					/*case 2:
						n = n.multiply(BigInteger.valueOf((base + i) / 2));
						break;
						
					case 5:
						n = n.multiply(BigInteger.valueOf((base + i) / 5));
						break;*/

					default:
						n = n.multiply(BigInteger.valueOf(base + i));
				}
			}
			
			base += 10;
		} while (base < 100);
		
		System.out.println(n);
		
		int s = 0;
		String str = n.toString();
		for (int i=0 ; i<str.length() ; i++)
			s += Integer.parseInt(str.substring(i, i + 1));
		
		System.out.println(s);

	}

}
