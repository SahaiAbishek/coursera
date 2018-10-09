package hkr;

public class SockPairProblem {

	// Complete the sockMerchant function below.
	static int sockMerchant(int n, int[] ar) {
		int pairCount = 0;
		boolean pairArr[] = new boolean[100];
		for (int num : ar) {
			if (pairArr[num]) {
				pairCount++;
				pairArr[num] = false;
			} else {
				pairArr[num] = true;
			}
		}
		return pairCount;
	}

	public static void main(String[] args) {
		int arr[] = { 10, 20, 20, 10, 10, 30, 50, 10, 20 };
		System.out.println(sockMerchant(9, arr));
	}
}
