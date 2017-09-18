package algorithm;

public class LinkedList<T> implements List<T> {
	private int size = 0;
	private LinkedNode<T> head = null;
	
	/*
	 * Return object at index
	 * @param index
	 * @return the data at the node index
	 */
	public T get(int index) {
		LinkedNode<T> targetNode = getNodeAtIndex(index);
		return targetNode.data;
	}
	
	/*
	 * Append node to end of list
	 * @param object to be appended at the end of the list
	 */
	public void add(T data) {
		// no nodes exist
		if (head == null) {
			head = new LinkedNode<T>(data);
		}
		else {
			// iterate over nodes to find leaf node
			LinkedNode<T> currentNode = head;
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			// point leaf node to new node
			currentNode.next = new LinkedNode<T>(data);
		}
		size++;
	}

	/*
	 * Insert at the index position, shifting index and above nodes upwards
	 * @param object to be inserted into the list and index position
	 */
	public void insert(T data, int index) {
		checkBounds(index);
		
		LinkedNode<T> newNode = new LinkedNode<T>(data);
		if (index == 0) {
			newNode.next = head;
			head = newNode;
		}
		else {
			LinkedNode<T> targetNode = getNodeAtIndex(index-1);
			newNode.next = targetNode.next; 
			targetNode.next = newNode;
		}
		size++;
	}

	/*
	 * Remove node at index
	 * @param target node index
	 */
	public void remove(int index) {
		checkBounds(index);
		
		// when removing first node of list
		if (index == 0) {
			if (size == 1) {
				clear();
				return;
			}
			else {
				head = head.next;
			}
		}
		else {
			LinkedNode<T> targetNode = getNodeAtIndex(index-1);
			targetNode.next = targetNode.next.next; 
		}
		
		size--;
	}

	/*
	 * Remove all nodes from list and reset size
	 */
	public void clear() {
		head = null;
		size = 0;
	}

	/*
	 * Return boolean representing whether list contains a target object
	 * @param target object
	 * @return true if target exists, false if target is not found in list
	 */
	public boolean contains(T data) {
		// iterate over nodes to find target node
		LinkedNode<T> currentNode = head;
		while (currentNode != null) {
			if (currentNode.data == data)
				return true;
			currentNode = currentNode.next;
		}
		return false;
	}

	/*
	 * Return list empty or full boolean state
	 * @return true if empty, false if not empty
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/*
	 * Get list size
	 * @return list size
	 */
	public int size() {
		return size;
	}
	
	/*
	 * Return a target node given the list index
	 * @param target node index
	 * @return target node
	 */
	private LinkedNode<T> getNodeAtIndex(int index) {
		checkBounds(index);
		
		// iterate over nodes to find target node
		LinkedNode<T> currentNode = head;
		while (index > 0) {
			currentNode = currentNode.next;
			index--;
		}
		
		return currentNode;
	}

	/*
	 * Check if target index is in bounds
	 * @param target node index
	 */
	private void checkBounds(int index) {
		// check if index is in bounds
		if (index < 0 || index > size || size == 0)
			throw new IndexOutOfBoundsException();
	}
}
