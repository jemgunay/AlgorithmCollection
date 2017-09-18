package algorithm;

// List interface
public interface List<T> {
	public T get(int index);
	public void add(T data);
	public void insert(T data, int index);
	public void remove(int index);
	public void clear();
	public boolean contains(T data);
	public boolean isEmpty();
	public int size();
}