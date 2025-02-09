/**
 * 
 */
package fr.obernin.eulerproject.numberletters;

/**
 * @author <a href="mailto:obernin@gmail.com">Olivier Bernin</a>
 *
 */
public class TeensUnitDigitWriter extends DigitWriter {

	/**
	 * @param digitrow
	 * @param names
	 * @param defaultNextDigitWriter
	 */
	public TeensUnitDigitWriter(DigitWriter defaultNextDigitWriter) {
		super(1, new String[] { "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" }, defaultNextDigitWriter);
	}
}
