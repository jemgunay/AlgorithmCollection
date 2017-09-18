import algorithm.*;

public class AlgorithmCollection {
	
	public static void main(String[] args) {
		// linked list
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("Example");
		String result = linkedList.get(0);
		System.out.println(result);

		// linked list
		DoublyLinkedList<String> dLinkedList = new DoublyLinkedList<String>();
		dLinkedList.add("Example");
		result = dLinkedList.get(0);
		System.out.println(result);
		
		// array list
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("Example");
		result = arrayList.get(0);
		System.out.println(result);
		
		// stack
		Stack<String> stack = new Stack<String>();
		stack.push("Example");
		result = stack.pop();
		System.out.println(result);
		
		
	}
}
