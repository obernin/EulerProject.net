/**
 * 
 */
package fr.obernin.eulerproject.numberletters;

/**
 * @author <a href="mailto:obernin@gmail.com">Olivier Bernin</a>
 *
 */
public class DigitWriter extends AbstractDigitWriter {
	
	private int digitrow;
	private String[] names;
	private DigitWriter defaultNextDigitWriter;

	/**
	 * 
	 */
	public DigitWriter(int digitrow, String[] names, DigitWriter defaultNextDigitWriter) {
		this.names = names;
		this.digitrow = digitrow;
		this.defaultNextDigitWriter = defaultNextDigitWriter;
	}

	/* (non-Javadoc)
	 * @see fr.obernin.eulerproject.numberletters.AbstractDigitWriter#getDigitName(int)
	 */
	@Override
	protected String getDigitName(int digit, int number) {
		return names[digit];
	}
	
	public String getNumberName(int number) {
		
		int pow = (int) Math.round(Math.pow(10, digitrow - 1));
		int digit = number / pow % 10;
		
		String name = "";
		if (number > pow -1)
			name = getDigitName(digit, number % pow);	
		
		DigitWriter next = this.getNextDigitWriter(digit, number % pow);
		if (next != null)
			name += next.getNumberName(number);
		
		return name;
	}
	
	public DigitWriter getNextDigitWriter(int digit, int number) {
		return getDefaultNextDigitWriter();
	}
	
	protected DigitWriter getDefaultNextDigitWriter() {
		return defaultNextDigitWriter;
	}

}
