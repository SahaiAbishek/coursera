package hkr;

public class AlternatingCharacters {

	// Complete the alternatingCharacters function below.
	static int alternatingCharacters(String s) {
		int i = 0;
		int j = 1;
		int delCount = 0;
		while (j < s.length()) {
			if (s.charAt(i) == s.charAt(j)) {
				j++;
				delCount++;
			} else {
				i=j;
				j++;
			}
		}
		return delCount;
	}

	public static void main(String[] args) {
		System.out.println(alternatingCharacters("ABBABBAA"));
	}

}
