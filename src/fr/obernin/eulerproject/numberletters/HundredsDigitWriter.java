/**
 * 
 */
package fr.obernin.eulerproject.numberletters;


/**
 * @author <a href="mailto:obernin@gmail.com">Olivier Bernin</a>
 *
 */
public class HundredsDigitWriter extends UnitDigitWriter {

	/**
	 * @param names
	 * @param defaultNextDigitWriter
	 */
	public HundredsDigitWriter(DigitWriter defaultNextDigitWriter) {
		super(3, defaultNextDigitWriter);
	}
	
	/* (non-Javadoc)
	 * @see fr.obernin.eulerproject.numberletters.AbstractDigitWriter#getDigitName(int)
	 */
	@Override
	public String getDigitName(int digit, int number) {
		if (number != 0)
			return super.getDigitName(digit, number) + " hundred and ";
		else
			return super.getDigitName(digit, number) + " hundred";
	}
}
