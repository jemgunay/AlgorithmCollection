package algorithm.util;

import algorithm.util.Sorter;
import java.util.Arrays;

public class Searcher {
	
	/*
	 * Use sequential search to find a target String
	 * @param string array
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
	
	/*
	 * Use binary search to find a target String
	 * @param pre-sorted String array
	 * @return array index of target string, or -1 if not found
	 */
	public int binarySearch(String[] list, String target) {
		return performBinarySearch(list, target, 0, list.length - 1);
	}
	
	private int performBinarySearch(String[] list, String target, int leftIndex, int rightIndex) {
		// get index between left and right
		int centreIndex = (int)Math.floor((float)(leftIndex+((rightIndex - leftIndex) / 2.f)));
		
		// element not found
		if ((rightIndex == leftIndex) && (list[centreIndex].compareTo(target) != 0)) {
			return -1;
		}
		// element found
		else if (list[centreIndex].compareTo(target) == 0) {
			return centreIndex;
		}
		// element may be on left side of array
		else if (list[centreIndex].compareTo(target) > 0) {
			return performBinarySearch(list, target, leftIndex, centreIndex);
		}
		// element may be on right side of array
		else {
			return performBinarySearch(list, target, centreIndex+1, rightIndex);
		}
		
	}
	
	
}