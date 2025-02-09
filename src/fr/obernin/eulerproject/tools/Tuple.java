/**
 *
 */
package fr.obernin.eulerproject.tools;

import java.util.AbstractList;

/**
 * @author obernin
 *
 */
public class Tuple<E> extends AbstractList<E> {

	private Object[] items;


	public Tuple(E[] items) {
		this.items = items;
	}

	public Tuple(int size) {
		items = new Object[size];
	}

	@Override
	public E get(int index) {
		return (E) items[index];
	}

	@Override
	public E set(int index, E element) {
		E previous = (E) items[index];
		items[index] = element;
		return previous;
	}

		@Override
	public int size() {
		return items.length;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer("(");
		for (Object item : items) {
			sb.append(item).append(", ");
		}
		sb.append(")");

		return sb.toString();
	}
}
