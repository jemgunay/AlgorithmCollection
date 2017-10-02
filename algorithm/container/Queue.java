package algorithm.container;

public class Queue<T> {
	// DoublyLinkedList based queue implementation
	private DoublyLinkedList<T> queueList = new DoublyLinkedList<T>();
	
	/*
	 * Add an object to the queue head
	 * @param the object to be added to the queue head
	 */
	public void enQueue(T data) {
		queueList.add(data);
	}
	
	/*
	 * Remove an object from the queue tail and return it
	 * @return the object to be removed from the queue
	 */
	public T serve() {
		T target = queueList.get(0);
		queueList.remove(0);
		return target;
	}

	/*
	 * Return an object from the queue tail
	 * @return the object at the end of the queue tail
	 */
	public T peek() {
		return queueList.get(0);
	}
	
	/*
	 * Get the number of objects added to the queue
	 * @return number of objects in queue
	 */
	public int count() {
		return queueList.size();
	}
}
