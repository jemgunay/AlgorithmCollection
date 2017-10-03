package algorithm.util;

import java.util.Arrays;

public class Searcher {
	
	/*
	 * Use sequential search to find a target String
	 * @return array index of target string, or -1 if not found
	 */
	public int sequentialSearch(String[] list, String target) {
		for (int i = 0; i < list.length; i++) {
			// compare target against current element
			if (list[i].compareTo(target) == 0) {
				return i;
			}
		}
		
		// not found
		return -1;
	}
	
	
}