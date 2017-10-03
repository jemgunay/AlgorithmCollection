package algorithm.util;

import java.util.Arrays;

public class Sorter {
	
	/*
	 * Use selection sort to sort the ArrayList
	 * @return sorted ArrayList
	 */
	public String[] selectionSort(String[] list) {
		// copy array
		String[] listCopy = list.clone();
		
		for (int i = 0; i < listCopy.length - 1; i++) {
			for (int j = i + 1; j < listCopy.length; j++) {
				if (listCopy[i].compareTo(listCopy[j]) > 0) {
					String temp = listCopy[i];
					listCopy[i] = listCopy[j];
					listCopy[j] = temp;
				}
			}
		}
		
		return listCopy;
	}
	
	/*
	 * Use selection sort to sort the ArrayList
	 * @return sorted ArrayList
	 */
	public String[] mergeSort(String[] list) {
		// copy array
		String[] listCopy = list.clone();
		
		if (listCopy.length > 1) {
			return performMergeSort(listCopy, 0, listCopy.length);
		}
		else {
			return listCopy;
		}
	}
	
	private String[] performMergeSort(String[] list, int startIndex, int endIndex) {
		if (list.length == 1) {
			return list;
		}
		else {
			// get subsets of arrays & perform recursive sorting on each side 
			int centreIndex = (int)Math.floor((float)list.length / 2.f);
			// left side
			String[] leftSide = subsetArray(list, 0, centreIndex);
			leftSide = performMergeSort(leftSide, 0, leftSide.length);
			// right side
			String[] rightSide = subsetArray(list, centreIndex, list.length);
			rightSide = performMergeSort(rightSide, 0, rightSide.length);
			
			// merge both sides into single array
			String[] mergedList = new String[leftSide.length + rightSide.length];
			int leftPos = 0, rightPos = 0, mainPos = 0;

			// merge results
			while (mainPos < mergedList.length) {
				// check for remaining centre element in odd length lists
				if (leftPos == leftSide.length && rightPos < rightSide.length) {
					mergedList[mainPos] = rightSide[rightPos];
					rightPos++;
				}
				else if (rightPos == rightSide.length && leftPos < leftSide.length) {
					mergedList[mainPos] = leftSide[leftPos];
					leftPos++;
				}
				// add to original list in order
				else {
					if (leftSide[leftPos].compareTo(rightSide[rightPos]) < 0) {
						mergedList[mainPos] = leftSide[leftPos];						
						leftPos++;
					}
					else {
						mergedList[mainPos] = rightSide[rightPos];						
						rightPos++;
					}
				}
				mainPos++;
			}
			
			return mergedList;
		}
	}

	/*
	 * Use insertion sort to sort the ArrayList
	 * @return sorted ArrayList
	 */
	public String[] insertionSort(String[] list) {
		// copy array
		String[] listCopy = list.clone();
		
		// iterate over all list elements
		for (int i = 1; i < listCopy.length; i++) {
			// iterate over all elements backwards starting with current element
			for (int j = i; j > 0; j--) {
				if (listCopy[j-1].compareTo(listCopy[j]) > 0) {
					String temp = listCopy[j];
					listCopy[j] = listCopy[j-1];
					listCopy[j-1] = temp;
				}
			}
		}
		
		return listCopy;
	}
	
	/*
	 * Get a subset of an array
	 * @param aray to copy from, start and end indexes
	 * @return clipped array
	 */
	private String[] subsetArray(String[] array, int startIndex, int endIndex) {
	    String[] part = new String[endIndex - startIndex];
	    System.arraycopy(array, startIndex, part, 0, endIndex-startIndex);
	    return part;
	}
	
}