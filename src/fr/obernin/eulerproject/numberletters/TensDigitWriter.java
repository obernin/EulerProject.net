/**
 * 
 */
package fr.obernin.eulerproject.numberletters;

/**
 * @author <a href="mailto:obernin@gmail.com">Olivier Bernin</a>
 *
 */
public class TensDigitWriter extends DigitWriter {

	/**
	 * @param names
	 */
	public TensDigitWriter(DigitWriter defaultNextDigitWriter) {
		super(2, new String[] { "", "ten ", "twenty ", "thirty ", "forty ", "fifty ", "sixty ", "seventy ", "eighty ", "ninety " }, defaultNextDigitWriter);
	}
	
	/* (non-Javadoc)
	 * @see fr.obernin.eulerproject.numberletters.AbstractDigitWriter#getDigitName(int)
	 */
	@Override
	protected String getDigitName(int digit, int number) {
		
		if (digit != 1)
			return super.getDigitName(digit, number);
		else
			return "";
	}
	
	public DigitWriter getNextDigitWriter(int digit, int number) {
		
		if (digit == 1) {
			return new TeensUnitDigitWriter(null);
		} else {
			return super.getNextDigitWriter(digit, number);
		}		
	}
}
