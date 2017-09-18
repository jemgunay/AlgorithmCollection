package test;

import org.junit.Assert;
import org.junit.Test;

import algorithm.ArrayList;

public class ArrayListTest extends ListTest {

	@Test
	public void performTest() {
		// create and add
		ArrayList<String> list = new ArrayList<String>();
		list.add("This");
		list.add("is");
		list.add("a");
		list.add("test");
		Assert.assertEquals("This is a test", concatList(list));
		Assert.assertEquals("test a is This", concatList(list, true));
		
		// insert
		list.insert("juicy", 3);
		Assert.assertEquals("This is a juicy test", concatList(list));
		Assert.assertEquals("test juicy a is This", concatList(list, true));
		
		// remove
		list.remove(3);
		Assert.assertEquals("This is a test", concatList(list));
		Assert.assertEquals("test a is This", concatList(list, true));
		
		// contains
		String s = "!";
		list.insert(s, list.size());
		Assert.assertEquals(true, list.contains(s));
		Assert.assertEquals("This is a test !", concatList(list));
		Assert.assertEquals("! test a is This", concatList(list, true));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void outOfBoundsExceptionTest() {
		ArrayList<String> list = new ArrayList<String>();
	    list.insert("Nope", 1);
	}
	
	@Test
	public void resizeTest() {
		ArrayList<String> list = new ArrayList<String>();
		
		String target = "";
		for (int i = 0; i < 45; i++) {
			list.add(Integer.toString(i));
			target += Integer.toString(i) + " ";
		}
		
		Assert.assertEquals(target.trim(), concatList(list));
	}
	
}
