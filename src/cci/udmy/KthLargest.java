package cci.udmy;

public class KthLargest {

	public static int findKthLargest(int[] nums, int k) {
		boolean arr[] = new boolean[100000];
		for (int num : nums) {
			arr[num] = true;
		}
		int count = 0;
		int index = arr.length - 1;
		while (index > 0) {
			if (arr[index] && k != count) {
				count++;
			}
			if (k == count) {
				return index;
			}
			index--;

		}
		return 0;
	}

	public static void main(String[] args) {
		int arr[] = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		System.out.println(findKthLargest(arr, 4));
	}

}
