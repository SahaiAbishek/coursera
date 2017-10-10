package test;

import coursera.SelectionSort;

public class SortTest {

	public static void main(String[] args) {
		String str[] = { "b", "a", "d", "c" };
		Integer in[] = {4,3,2,1};
		SelectionSort.sort(str);
		
		for(String s: str) {
			System.out.println(s);
		}
	}

}
