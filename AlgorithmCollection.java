import java.util.Arrays;

import algorithm.container.*;
import algorithm.util.*;

public class AlgorithmCollection {
	
	public static void main(String[] args) {
		// container types
		// linked list
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("Example 1");
		System.out.println(linkedList.get(0));

		// linked list
		DoublyLinkedList<String> dLinkedList = new DoublyLinkedList<String>();
		dLinkedList.add("Example 2");
		System.out.println(dLinkedList.get(0));
		
		// array list
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("Example 3");
		System.out.println(arrayList.get(0));
		
		// stack
		Stack<String> stack = new Stack<String>();
		stack.push("Example 4");
		System.out.println(stack.pop());
		
		// queue
		Queue<String> queue = new Queue<String>();
		queue.enQueue("Example 5");
		System.out.println(queue.serve());
		
		// sorting examples
		String[] wordList = {"Fries", "Carrot", "Apple", "Bagel", "Egg", "Doughnut"};
		System.out.println("Unsorted: " + Arrays.toString(wordList));
		Sorter sorter = new Sorter();
		// selection sort
		System.out.println("Selection: " + Arrays.toString(sorter.selectionSort(wordList)));
		// merge sort
		System.out.println("Merge: " + Arrays.toString(sorter.mergeSort(wordList)));
		// insertion sort
		System.out.println("Insertion: " + Arrays.toString(sorter.insertionSort(wordList)));
		
		// searching examples
		Searcher searcher = new Searcher();
		// sequential search
		System.out.println("Sequential: " + searcher.sequentialSearch(wordList, "Egg"));
		// sequential search
		System.out.println("Binary: " + searcher.binarySearch(sorter.mergeSort(wordList), "Egg"));
	}
}
