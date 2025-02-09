/**
 * 
 */
package fr.obernin.eulerproject;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author <a href="mailto:obernin@gmail.com">Olivier Bernin</a>
 *
 */
public class NonAbundantSums {
	
	public static void getFactors(long number, FactorActor actor) {
		
		actor.act(1);
		double sqrt = Math.sqrt(number);
		for (long i=2 ; i<=sqrt ; i++)
			if (number % i == 0) {
				actor.act(i);
				if (i * i != number)
					actor.act(number / i);
			}
	}
	
	public static boolean isNumberAbundant(long number) {
		
		SumActor sumActor = new SumActor();
		getFactors(number, sumActor);
		if (sumActor.sum > number) {
			//System.out.println(number + ": " + sumActor.sum + " = " + sumActor.factors);
			return true;
		} else {
			return false;
		}
	}
	
	private static class SumActor implements FactorActor {
		
		public long sum = 0;
		public List<Long> factors = new ArrayList<Long>();

		@Override
		public void act(long factor) {
			sum += factor;			
			factors.add(factor);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long sumAbundant = 0;
		SortedSet<Long> abundantNumbers = new TreeSet<Long>();
		
		for (long number=1 ; number<28124 ; number++) {
			long mid = number;

			if (isNumberAbundant(number)) {
				//System.out.print(number + " is abundant; ");
				abundantNumbers.add(number);
			}
			
			boolean isSum = false;
			for (Long abundantNumber : abundantNumbers) {
				if (abundantNumber > mid)
					break;
				
				long complementary = number - abundantNumber;
				if (abundantNumbers.contains(complementary)) {
					isSum = true;
					//System.out.println(number + " is sum of " + abundantNumber + " & "  + complementary + " (" + sumAbundant + ")");
					break;
				}
			}
			
			if (! isSum) {
				sumAbundant += number;
				//System.out.println(number + " is not sum of 2 abundant numbers (" + sumAbundant + ") ");
			}
		}
		
		System.out.println(sumAbundant);

	}

}
