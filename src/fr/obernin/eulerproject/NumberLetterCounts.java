/**
 * 
 */
package fr.obernin.eulerproject;

import fr.obernin.eulerproject.numberletters.DigitWriter;
import fr.obernin.eulerproject.numberletters.HundredsDigitWriter;
import fr.obernin.eulerproject.numberletters.TensDigitWriter;
import fr.obernin.eulerproject.numberletters.UnitDigitWriter;

/**
 * @author <a href="mailto:obernin@gmail.com">Olivier Bernin</a>
 *
 */
public class NumberLetterCounts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		DigitWriter dw = new HundredsDigitWriter(new TensDigitWriter(new UnitDigitWriter()));
		
		int count = 0;
		for (int i=1 ; i<1000 ; i++) {
			System.out.println(dw.getNumberName(i));
			count += dw.getNumberName(i).replace(" ", "").length();
		}
		
		System.out.println(count);

	}
}
