package algorithm.container;

import java.util.EmptyStackException;

public class Stack<T> {
	// ArrayList based stack implementation
	private ArrayList<T> stackArray = new ArrayList<T>();
	
	/*
	 * Add object to the top of the stack
	 * @param object to be added to stack
	 */
	public void push(T data) {
		stackArray.add(data);
	}
	
	/*
	 * Remove object at the top of the stack and return it
	 * @return object at the top of the stack
	 */
	public T pop() {
		if (stackArray.size() == 0) {
            throw new EmptyStackException();
		}

		T lastObject = stackArray.get(stackArray.size() - 1);
		stackArray.remove(stackArray.size());
		return lastObject;
	}
	
	/*
	 * View the object at the top of the stack
	 * @return object at the top of the stack
	 */
	public T peek() {
		if (stackArray.size() == 0)
            throw new EmptyStackException();
		
		return stackArray.get(stackArray.size() - 1);
	}

	/*
	 * Remove all elements from the stack
	 */
	public void empty() {
		stackArray.clear();
	}
	
	/*
	 * Get the number of objects in the stack
	 * @return the number of objects in the stack
	 */
	public int count() {
		return stackArray.size();
	}

	/*
	 * Check if stack contains an object
	 * @param the object to be compared against stack contents
	 * @return true if object exists, false if it does not
	 */
	public boolean contains(T data) {
		return stackArray.contains(data);
	}
}
