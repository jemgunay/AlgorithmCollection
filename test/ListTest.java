package test;

import algorithm.container.List;

public class ListTest {
	// functions for returning lists as concatenated string
	protected <T> String concatList(List<T> list) {
		return concatList(list, false);
	}
	
	protected <T> String concatList(List<T> list, boolean reversed) {
		String concatStr = "";
		// iterate over each list index
		for (int i = 0; i < list.size(); i++) {
			if (reversed)
				concatStr += list.get(list.size() - i - 1) + " ";
			else
				concatStr += list.get(i) + " ";
		}
		
		return concatStr.trim();
	}

}
