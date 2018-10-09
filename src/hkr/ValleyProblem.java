package hkr;

public class ValleyProblem {

	static int countingValleys(int n, String s) {
		int valleyCount = 0;
		int count = 0;
		char ch;
		for (int i = 0; i < s.length(); i++) {
			ch = s.charAt(i);
			if (ch == 'U') {
				count++;
			} else if (ch == 'D') {
				count--;
			}
			if (count == 0 && ch == 'U') {
				valleyCount++;
			}
		}
		return valleyCount;
	}

	public static void main(String[] args) {
		System.out.println(countingValleys(8, "UDDDUDUU"));
	}

}
