package algorithm;

public class ArrayList<T> implements List<T> {
	// default array size of 10
	private int size = 0, defaultArraySize = 10;
	private Object[] dataArray = new Object[defaultArraySize];
	
	/*
	 * Return object at index
	 * @param index
	 * @return the data at the object index
	 */
    @SuppressWarnings("unchecked")
	public T get(int index) {
		checkBounds(index);
		
		return (T)dataArray[index];
	}
	
	/*
	 * Append object to end of list
	 * @param object to be appended at the end of the list
	 */
	public void add(T data) {
		// ensure array space is available
		if (dataArray.length == size)
			resizeArray();
		
		dataArray[size] = data;
		size++;
	}

	/*
	 * Insert at the index position, shifting index and above objects upwards
	 * @param object to be inserted into the list and index position
	 */
	public void insert(T data, int index) {
		checkBounds(index);
		
		// ensure array space is available
		if (dataArray.length == size)
			resizeArray();
		
		// shift elements of index and higher upwards
		for (int i = index; i < size; i++) {
			dataArray[i+1] = dataArray[i];
		}
		
		dataArray[index] = data;
		size++;
	}

	/*
	 * Remove object at index
	 * @param target object index
	 */
	public void remove(int index) {
		checkBounds(index);
		
		// shift elements of index and higher upwards
		for (int i = index; i < size; i++) {
			dataArray[i] = dataArray[i+1];
		}
		
		size--;
	}

	/*
	 * Remove all objects from list and reset size
	 */
	public void clear() {
		dataArray = new Object[defaultArraySize];
		size = 0;
	}

	/*
	 * Return boolean representing whether list contains a target object
	 * @param target object
	 * @return true if target exists, false if target is not found in list
	 */
	public boolean contains(T data) {
		for (int i = 0; i < dataArray.length; i++) {
			if (dataArray[i] == data)
				return true;
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
	 * Create new array of increased size and copy existing array data over to it
	 */
	private void resizeArray() {
		// double array size
		int newSize = dataArray.length * 2;
		Object[] newArray = new Object[newSize];
		
		// copy existing data array to new one
		System.arraycopy(dataArray, 0, newArray, 0, dataArray.length);
		dataArray = newArray;
	}
	
	/*
	 * Check if target index is in bounds
	 * @param target object index
	 */
	private void checkBounds(int index) {
		// check if index is in bounds
		if (index < 0 || index > size || size == 0)
			throw new IndexOutOfBoundsException();
	}
}
