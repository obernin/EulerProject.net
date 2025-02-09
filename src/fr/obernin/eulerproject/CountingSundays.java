/**
 * 
 */
package fr.obernin.eulerproject;

/**
 * @author <a href="mailto:obernin@gmail.com">Olivier Bernin</a>
 *
 */
public class CountingSundays {
	
	// Monday is 0, Sunday 6
	
	public void count(int startYear, int startMonth, int dayOfWeek, int endYear, int endMonth, Counter counter) {
		
		int year = startYear;
		int month = startMonth;
		int firstOfMonth = dayOfWeek;
		
		do {
			firstOfMonth = (firstOfMonth + getMonthDays(year, month)) % 7;
			counter.count(year, month, firstOfMonth);
			
			month++;
			if (month > 11) {
				year++;
				month = 0;
			}
		} while (year < endYear || month < endMonth);
	}
	
	protected int getMonthDays(int year, int month) {
		
		switch (month) {
			case 0:
			case 2:
			case 4:
			case 6:
			case 7:
			case 9:
			case 11:
				return 31;
				
			case 3:
			case 5:
			case 8:
			case 10:
				return 30;
				
			case 1:
				if (year % 4 == 0) {
					if (year % 100 == 0) {
						if (year % 400 == 0)
							return 29;
						else 
							return 28;
					} else {
						return 29;
					}
				} else {
					return 28;
				}
				
			default:
				throw new IllegalArgumentException();
		}
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		CountingSundays cs = new CountingSundays();
		cs.count(1900, 0, 0, 2001, 0, new Counter() {
			
			private int count = 0;

			@Override
			public void count(int year, int month, int dayOfWeek) {
				
				//System.out.println(month + 1 + "/" + year + ": " + dayOfWeek);
				
				if (dayOfWeek == 6) {
					if (year > 1900) {
						count++;
					}
					
					System.out.println(month + 1 + "/" + year + ": " + dayOfWeek + " " + count);
				}
			}
		});
	}
	
	private static interface Counter {
		
		public void count(int year, int month, int dayOfWeek);
	}

}
