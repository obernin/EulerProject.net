/**
 *
 */
package fr.obernin.eulerproject.iterable;

/**
 * @author obernin
 *
 */
public class Tools {

	public static <T extends Comparable<T>> T max(Iterable<T> items) {

		T max = null;

		for (T item : items) {
			if (max == null || max.compareTo(item) < 0)
				max = item;
		}

		return max;
	}

	public static <T extends Comparable<T>> T min(Iterable<T> items) {

		T min = null;

		for (T item : items) {
			if (min == null || min.compareTo(item) > 0)
				min = item;
		}

		return min;
	}
}
