package test;

import org.junit.Assert;
import org.junit.Test;
import java.util.EmptyStackException;

import algorithm.Stack;

public class StackTest {

	@Test
	public void performTest() {
		// create and push
		Stack<String> list = new Stack<String>();
		list.push("This");
		list.push("is");
		list.push("a");
		list.push("test");
		// peak
		Assert.assertEquals("test", list.peek());
		
		// pop
		Assert.assertEquals("test", list.pop());
		Assert.assertEquals("a", list.pop());
		
		// contains
		String s = "test";
		list.push(s);
		Assert.assertEquals(true, list.contains(s));
		Assert.assertEquals(false, list.contains("example"));
	}

	@Test(expected = EmptyStackException.class)
	public void emptyStackExceptionTest() {
		Stack<String> list = new Stack<String>();
	    list.push("test");
	    list.empty();
		list.pop();
	}
	
}
