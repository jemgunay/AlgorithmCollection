package algorithm.container;

public class DoublyLinkedList<T> implements List<T> {
	private int size = 0;
	private DoublyLinkedNode<T> head = null, tail = null;
	
	/*
	 * Return object at index
	 * @param index
	 * @return the data at the node index
	 */
	public T get(int index) {
		DoublyLinkedNode<T> targetNode = getNodeAtIndex(index);
		return targetNode.data;
	}
	
	/*
	 * Append node to end of list
	 * @param object to be appended at the end of the list
	 */
	public void add(T data) {
		// no nodes exist
		if (head == null) {
			head = new DoublyLinkedNode<T>(data);
			tail = head;
		}
		else {
			// point leaf node to new node
			tail.next = new DoublyLinkedNode<T>(data);
			tail.next.previous = tail;
			tail = tail.next;
		}
		size++;
	}

	/*
	 * Insert at the index position, shifting index and above nodes upwards
	 * @param object to be inserted into the list and index position
	 */
	public void insert(T data, int index) {
		checkBounds(index);
		
		// add new node to top
		if (index == size) {
			add(data);
			return;
		}
		
		DoublyLinkedNode<T> newNode = new DoublyLinkedNode<T>(data);
		// shift all nodes up, set first to new node
		if (index == 0) {
			newNode.next = head;
			head = newNode;
		}
		// insert somewhere between first and last nodes
		else {
			DoublyLinkedNode<T> targetNode = getNodeAtIndex(index);
			newNode.next = targetNode;
			targetNode.previous.next = newNode;
			newNode.previous = targetNode.previous;
			targetNode.previous = newNode;				
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
				head.previous = null;
			}
		}
		else {
			DoublyLinkedNode<T> targetNode = getNodeAtIndex(index);
			targetNode.previous.next = targetNode.next;
			targetNode.next.previous = targetNode.previous; 
		}
		
		size--;
	}

	/*
	 * Remove all nodes from list and reset size
	 */
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	/*
	 * Return boolean representing whether list contains a target object
	 * @param target object
	 * @return true if target exists, false if target is not found in list
	 */
	public boolean contains(T data) {
		// iterate over nodes to find target node
		DoublyLinkedNode<T> currentNode = head;
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
	 * Return a target node given the list index. Start search at either head or tail depending on index relative to list size
	 * @param target node index
	 * @return target node
	 */
	private DoublyLinkedNode<T> getNodeAtIndex(int index) {
		checkBounds(index);
		
		// determine the direction in which to iterate
		boolean tailFirst = (index > size/2) ? true : false;
		
		DoublyLinkedNode<T> currentNode = head;
		if (tailFirst)
			currentNode = tail;
		
		// iterate over nodes to find target node
		while (true) {
			if (!tailFirst && index > 0) {
				currentNode = currentNode.next;
				index--;
			}
			else if (tailFirst && index < size-1) {
				currentNode = currentNode.previous;
				index++;
			}
			else {
				return currentNode;
			}
		}
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
	
	/*
	 * Convert list to an array and return it
	 * @param array to copy list to
	 * @return array representing the list
	 */
    public T[] toArray(T[] array) {
		// iterate over nodes
    	int counter = 0;
		DoublyLinkedNode<T> currentNode = head;
		while (currentNode != null) {
			array[counter++] = currentNode.data;
			currentNode = currentNode.next;
		}
		
		return array;
	}
}
