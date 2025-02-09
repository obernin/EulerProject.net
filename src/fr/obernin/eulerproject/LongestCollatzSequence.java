/**
 * 
 */
package fr.obernin.eulerproject;

/**
 * @author <a href="mailto:obernin@gmail.com">Olivier Bernin</a>
 *
 */
public class LongestCollatzSequence {
	
	public static int getCollatzSequenceLength(int startingPoint) {
		
		int count = 1;
		long n = startingPoint;
		
		while (n != 1) {
			if (n % 2 == 0) // n even
				n /= 2;
			else
				n = 3 * n + 1;
			
			count++;
		}
		
		return count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int nmax = 0;
		int longest = 0;
		for (int i=1 ; i<1000000 ; i++) {
			int l = getCollatzSequenceLength(i); 
			if (l > longest) {
				nmax = i;
				longest = l; 
			}
		}
		
		System.out.println(nmax + ": " + longest);
	}

}
