package cci.udmy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public int[] findTwoNumbers(int arr[], int sum) {
		int retArr[] = new int[2];
		for (int i = 0; i < arr.length - 1; i++) {
			int num1 = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] + num1 == sum) {
					retArr[0] = i;
					retArr[1] = j;
					return retArr;
				}
			}
		}
		return retArr;
	}

	private int[] twoSumUsingHashing(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement) && map.get(complement) != i) {
				return new int[] { i, map.get(complement) };
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	public int[] twoSum(int[] arr, int sum) {
		return twoSumUsingHashing(arr, sum);
	}

	public int findSumRecusrion(int arr[], int num2, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		int midNum = arr[mid];
		if (midNum == num2) {
			return mid;
		} else if (num2 > midNum) {
			return findSumRecusrion(arr, num2, mid + 1, end);
		} else {
			return findSumRecusrion(arr, num2, start, mid - 1);
		}

	}

	public static void main(String[] args) {
		TwoSum twoSum = new TwoSum();
		int arr[] = { 2, 7, 11, 15 };
		int retArr[] = twoSum.twoSum(arr, 9);
		System.out.println(retArr[0] + "," + retArr[1]);
	}

}
