/**
 * 
 */
package fr.obernin.eulerproject.tools;

import java.util.Iterator;

/**
 * @author <a href="mailto:obernin@gmail.com">Olivier Bernin</a>
 *
 */
public abstract class Sequence<T> implements Iterable<T> {
	
	private T U0;


	/**
	 * 
	 */
	public Sequence() {
		U0 = null;
	}

	/**
	 * 
	 */
	public Sequence(T U0) {
		this.U0 = U0;
	}

	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<T> iterator() {
		return new SequenceIterator<T>(this);
	}
	
	public boolean hasInitialElement() {
		return U0 != null;
	}
	
	public T getInitialElement() {
		return U0;
	}
	
	public abstract T Un(int n, T Uprevious);
}
