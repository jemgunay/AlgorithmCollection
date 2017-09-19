package test;

import org.junit.Assert;
import org.junit.Test;

import algorithm.Queue;

public class QueueTest {

	@Test
	public void performTest() {
		// create and enqueue
		Queue<String> queue = new Queue<String>();
		queue.enQueue("This");
		queue.enQueue("is");
		queue.enQueue("a");
		queue.enQueue("test");
		Assert.assertEquals("This", queue.peek());
		
		// peak
		Assert.assertEquals("This", queue.serve());
		Assert.assertEquals("is", queue.serve());
		
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void emptyQueueExceptionTest() {
		Queue<String> queue = new Queue<String>();
	    queue.peek();
	}
	
}
