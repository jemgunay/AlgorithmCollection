package algorithm.container;

public class DoublyLinkedNode<T> {
	public T data;
	public DoublyLinkedNode<T> next = null, previous = null;
	
	// constructor
	public DoublyLinkedNode(T element) {
		data = element;
	}
	
}
