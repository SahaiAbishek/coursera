package hkr;

public class Anagram {

	public static int numberNeeded(String first, String second) {

		int arr[] = new int[26];

		for (int i = 0; i < first.length(); i++) {
			char c = first.charAt(i);
			int pos = c - 'a';
			int num = arr[pos];
			arr[pos] = ++num;
		}

		for (int i = 0; i < second.length(); i++) {
			char c = second.charAt(i);
			int pos = c - 'a';
			int num = arr[pos];
			arr[pos] = --num;
		}

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + Math.abs(arr[i]);
		}

		return sum;
	}

	public static void main(String[] args) {
		System.out.println(numberNeeded("abcd", "cab"));

	}

}
