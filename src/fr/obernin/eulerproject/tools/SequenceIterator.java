/**
 * 
 */
package fr.obernin.eulerproject.tools;

import java.util.Iterator;

/**
 * @author <a href="mailto:obernin@gmail.com">Olivier Bernin</a>
 *
 */
public class SequenceIterator<T> implements Iterator<T> {
	
	private Sequence<T> parent;

	private T Un;
	private int n;
	private boolean nextComputed;
	


	/**
	 * 
	 */
	SequenceIterator(Sequence<T> parent) {
		this.parent = parent;
		this.nextComputed = true;
		
		n = 0;
		if (parent.hasInitialElement())
			Un = parent.getInitialElement();
		else
			Un = parent.Un(0, null);
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		if (! nextComputed) {
			Un = parent.Un(n++, Un);
			nextComputed = true;
		}
		
		return Un != null;
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#next()
	 */
	@Override
	public T next() {
		if (! nextComputed) {
			Un = parent.Un(n++, Un);
		}
		
		nextComputed = false;
		return Un;
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#remove()
	 */
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
