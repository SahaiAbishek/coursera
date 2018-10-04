package hkr;

public class MinimumBribes {

	// Complete the minimumBribes function below.
	static void minimumBribes(int[] q) {

		int swapCount = 0;
		boolean isSorted = false;
		while (!isSorted) {
			isSorted = true;
			int last = q.length - 1;
			for (int i = 0; i < last; i++) {
				int pos = i + 1;
				int diff = q[i] - pos;
				if (diff > 2) {
					System.out.println("Too chaotic");
					return;
				}
				if (q[i] > q[i + 1]) {
					int temp = q[i];
					q[i] = q[i + 1];
					q[i + 1] = temp;
					isSorted = false;
					swapCount++;
				}
			}
		}
		System.out.println(swapCount);
	}

	public static void main(String[] args) {
		int[] q = { 2, 5,1, 3, 4 };
		minimumBribes(q);
	}

}
