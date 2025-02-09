/**
 * 
 */
package fr.obernin.eulerproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:obernin@gmail.com">Olivier Bernin</a>
 *
 */
public class NameScores {
	
	public static long getTotalNameScores(String[] list) {
		
		long totalScore = 0;
		
		quickSort(list);
		
		for (int i=0 ; i<list.length ; i++) {
			long nameScore = 0;
			//System.out.println("[" + list[i] + "]");
			for (int j=0 ; j<list[i].length() ; j++)
				nameScore += list[i].charAt(j) - 'A' + 1;
			nameScore *= (i + 1);
			
			totalScore += nameScore;
		}
		return totalScore;
	}
	
	public static void quickSort(String[] list) {
		quickSort(list, 0, list.length);
	}
	
	private static void quickSort(String[] list, int off, int len) {
		
		if (len < 2)
			return;
		
		String pivotValue = list[off];
		
		/*
		 * |P|<|<|<|>|>|?|?|?|
		 *          j   i
		 */
		
		
		int j = off + 1;
		for (int i=off + 1 ; i<off + len ; i++) {
			if (pivotValue.compareTo(list[i]) > 0) {
				String v = list[j];
				list[j++] = list[i];
				list[i] = v;
			}
		}
		
		if (j != off + 1) {
			list[off] = list[j - 1];
			list[j - 1] = pivotValue;
		}
		
		//System.out.println(Arrays.toString(list));
		
		quickSort(list, off, j - 1 - off);
		quickSort(list, j, off + len - j);
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader(args[0]));
		
		String line = null;
		List<String> list = new ArrayList<String>(8192);
		while ((line = in.readLine()) != null) {
			line = line.replace("\"", "");
			String[] names = line.split(",");
			for (String name : names)
				list.add(name);
		}
		
		String[] array = list.toArray(new String[list.size()]);
		
		long start = System.currentTimeMillis();
		long total = getTotalNameScores(array);
		long stop = System.currentTimeMillis();
		System.out.println(total + " [" + (stop - start) + " ms]");
		//System.out.println(Arrays.toString(array));
	}

}
