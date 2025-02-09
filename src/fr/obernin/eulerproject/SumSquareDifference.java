/**
 * 
 */
package fr.obernin.eulerproject;

/**
 * @author <a href="mailto:obernin@gmail.com">Olivier Bernin</a>
 *
 */
public class SumSquareDifference {
	
	public static long getSumSquareDifference(long n) {
		
		long sumSqDiff = 0;
		long sum = n * (n + 1) / 2;
		for (int i=1 ; i<=n ; i++) {
			sumSqDiff += i * (sum - i);
		}
		 
		return sumSqDiff;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getSumSquareDifference(100));
	}

}
