/**
 *
 */
package fr.obernin.eulerproject.prime;

import java.util.ArrayList;
import java.util.List;

import fr.obernin.eulerproject.iterable.Tools;
import fr.obernin.eulerproject.tools.Tuple;

/**
 * @author <a href="mailto:obernin@gmail.com">Olivier Bernin</a>
 *
 */
public class PrimeFactorWalker {

	private int n, f;
	private long max;
	private boolean done;
	private PrimeFactorNotifier notifier;


	public interface PrimeFactorNotifier {

		public boolean foundPrimeFactor(int p);
	}

	public static class PrimeIdentifier implements PrimeFactorNotifier {

		private int count = 0;

		public boolean foundPrimeFactor(int p) {
			count++;
			return true;
		}

		public boolean isPrime() {
			return count == 1;
		}
	}

	public static class PrimeFactorLister implements PrimeFactorNotifier {

		List<Integer> factors = new ArrayList<Integer>();

		public boolean foundPrimeFactor(int p) {

			for (int i=factors.size() ; i <= p ; i++)
				factors.add(0);

			factors.set(p, factors.get(p) + 1);
			return true;
		}

		public List<Integer> getPrimeFactors() {
			return factors;
		}
	}

	public static class PrimeFactorAndExponentLister implements PrimeFactorNotifier {

		Tuple<Integer> currentPrimeFactor = new Tuple<Integer>(new Integer[] { 0, 0 });
		List<Tuple<Integer>> factors = new ArrayList<Tuple<Integer>>();

		public boolean foundPrimeFactor(int p) {
			if (p == currentPrimeFactor.get(0))
				currentPrimeFactor.set(1, currentPrimeFactor.get(1) + 1);

			else {
				currentPrimeFactor = new Tuple<Integer>(new Integer[] { p, 1 });
				factors.add(currentPrimeFactor);
			}

			return true;
		}

		public List<Tuple<Integer>> getPrimeFactorsAndExponent() {
			return factors;
		}
	}


	public static void walkAllPrimeFactors(int n, PrimeFactorNotifier notifier) {

		PrimeFactorWalker pfw = new PrimeFactorWalker(n, notifier);

		while (! pfw.walkNextPrimeFactor());
	}

	public static boolean isPrime(int n) {

		PrimeIdentifier pi = new PrimeIdentifier();

		walkAllPrimeFactors(n, pi);

		return pi.isPrime();
	}

	public static List<Integer> getPrimeFactors(int n) {

		PrimeFactorLister pfl = new PrimeFactorLister();
		walkAllPrimeFactors(n, pfl);

		return pfl.getPrimeFactors();
	}

	public static List<Tuple<Integer>> getPrimeFactorsAndExponent(int n) {

		PrimeFactorAndExponentLister pfl = new PrimeFactorAndExponentLister();
		walkAllPrimeFactors(n, pfl);

		return pfl.getPrimeFactorsAndExponent();
	}

	public static int pgcd(int a, int b) {

		if (b > a)
			return pgcd(b, a);

		if (b == 0)
			return a;
		else
			return pgcd(b, a % b);
	}

	public static int pgcd(List<Integer> list) {

		if (list.size() == 1) {
			return list.get(0);

	    } else if (list.size() == 2) {
			return pgcd(list.get(0), list.get(1));

	    } else {
	    	return pgcd(pgcd(list.subList(0, list.size() - 2)), list.get(list.size() - 1));
		}
	}

	public static int ppcd(List<Integer> list) {

		// Finding the smallest possible integer that divide them all (but is not 1)

		int min = Tools.min(list);
		for (int divisor=2 ; divisor<=min ; divisor++) {
			boolean divideAll = true;
			for (int number : list) {
				if (number % divisor != 0) {
					divideAll = false;
					break;
				}
			}

			if (divideAll)
				return divisor;
		}

		return 1;
	}


	public PrimeFactorWalker(int n, PrimeFactorNotifier notifier) {
		this.n = n;

		if (n > 0) {
			this.done = false;
			this.max = Math.round(Math.ceil(Math.sqrt(n)));
		} else {
			done = true;
		}

		this.f = 2;
		this.notifier = notifier;
	}

	public boolean walkNextPrimeFactor() {

		if (! done) {

			while (n % f == 0) {
				notifier.foundPrimeFactor(f);
				n /= f;
			}

			f++;
			if (f > max) {
				if (n != 1)
					notifier.foundPrimeFactor(n);
				done = true;
			}
		}

		return done;
	}


	public static void main(String[] args) {



		for (int i=2 ; i<100 ; i++) {

			System.out.print(i + ": ");
			System.out.println(PrimeFactorWalker.getPrimeFactors(i));
			System.out.print(i + ": ");
			System.out.println(PrimeFactorWalker.getPrimeFactorsAndExponent(i));
		}
	}

}
