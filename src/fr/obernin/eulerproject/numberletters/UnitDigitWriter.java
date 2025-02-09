/**
 * 
 */
package fr.obernin.eulerproject.numberletters;


/**
 * @author <a href="mailto:obernin@gmail.com">Olivier Bernin</a>
 *
 */
public class UnitDigitWriter extends DigitWriter {

	public UnitDigitWriter() {
		this(1, null);
	}

	/**
	 * @param names
	 */
	protected UnitDigitWriter(int digitrow, DigitWriter defaultNextDigitWriter) {
		super(digitrow, new String[] { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" }, defaultNextDigitWriter);
	}
}
