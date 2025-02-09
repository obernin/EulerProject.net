/**
 * 
 */
package fr.obernin.eulerproject;

/**
 * @author <a href="mailto:obernin@gmail.com">Olivier Bernin</a>
 *
 */
public class NumberSpiralDiagonals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		long S = 0;
		for (int n=3 ; n<=1001 ; n = n + 2) {
			S += 2 * (2 * n * n - 3 * n + 3);
			System.out.println(n + ": " + (S + 1));
		}

	}

}
