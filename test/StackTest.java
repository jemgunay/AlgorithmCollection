package test;

import org.junit.Assert;
import org.junit.Test;

import algorithm.container.Stack;

import java.util.EmptyStackException;

public class StackTest {

	@Test
	public void performTest() {
		// create and push
		Stack<String> stack = new Stack<String>();
		stack.push("This");
		stack.push("is");
		stack.push("a");
		stack.push("test");
		// peak
		Assert.assertEquals("test", stack.peek());
		
		// pop
		Assert.assertEquals("test", stack.pop());
		Assert.assertEquals("a", stack.pop());
		
		// contains
		String s = "test";
		stack.push(s);
		Assert.assertEquals(true, stack.contains(s));
		Assert.assertEquals(false, stack.contains("example"));
	}

	@Test(expected = EmptyStackException.class)
	public void emptyStackExceptionTest() {
		Stack<String> stack = new Stack<String>();
	    stack.push("test");
	    stack.empty();
		stack.pop();
	}
	
}
