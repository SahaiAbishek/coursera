package hkr;

public class MaxArraySum {

	int maxSum = 0;

	public static int maxSubsetSum(int[] arr) {
		int max1 = maxSubsetSum(arr, 0, arr.length-1);
		int max2 = maxSubsetSum(arr, 1, arr.length-1);
		return max1 > max2 ? max1 : max2;
	}

	private static int maxSubsetSum(int[] arr, int start, int end) {
		int sum = 0;
		int max = 0;
		if (end - start == 1) {
			return 0;
		}
		while (start < end) {
			sum += arr[start] + arr[start + 2];
			if (end - start == 1) {
				sum += arr[start] + arr[end];
			}
			if (sum > max) {
				max = sum;
			}
			start = start + 2;
		}
		return max;
	}

	public static void main(String[] args) {
		int arr[] = { 3, 7, 4, 6, 5 };
		System.out.println(maxSubsetSum(arr));
	}

}
