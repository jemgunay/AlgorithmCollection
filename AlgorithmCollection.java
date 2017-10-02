import java.util.Arrays;

import algorithm.container.*;
import algorithm.util.*;

public class AlgorithmCollection {
	
	public static void main(String[] args) {
		// container types
		// linked list
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("Example 1");
		String result = linkedList.get(0);
		System.out.println(result);

		// linked list
		DoublyLinkedList<String> dLinkedList = new DoublyLinkedList<String>();
		dLinkedList.add("Example 2");
		result = dLinkedList.get(0);
		System.out.println(result);
		
		// array list
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("Example 3");
		result = arrayList.get(0);
		System.out.println(result);
		
		// stack
		Stack<String> stack = new Stack<String>();
		stack.push("Example 4");
		result = stack.pop();
		System.out.println(result);
		
		// queue
		Queue<String> queue = new Queue<String>();
		queue.enQueue("Example 5");
		result = queue.serve();
		System.out.println(result);
		
		// sorting examples
		String[] sortList = {"Fries", "Carrot", "Apple", "Bagel", "Egg", "Doughnut"}; 
		Sorter sorter = new Sorter();
		
		// selection sort
		System.out.println(Arrays.toString(sorter.selectionSort(sortList)));
		System.out.println(Arrays.toString(sortList));
		System.out.println(Arrays.toString(sorter.mergeSort(sortList)));
		
	}
}
