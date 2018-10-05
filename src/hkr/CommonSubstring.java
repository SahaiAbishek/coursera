package hkr;

public class CommonSubstring {

	// Complete the twoStrings function below.
	static String twoStrings(String s1, String s2) {

		boolean arr[] = new boolean[256];
		for (int i = 0; i < s1.length(); i++) {
			int pos = s1.charAt(i);
			arr[pos] = true;
		}

		for (int i = 0; i < s2.length(); i++) {
			int pos = s2.charAt(i);
			if(arr[pos]){
				return "YES";
			}
		}

		return "NO";
	}

	public static void main(String[] args) {
		System.out.println(twoStrings("hello", "hello"));
	}

}
