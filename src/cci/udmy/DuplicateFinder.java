package cci.udmy;

import java.util.HashMap;
import java.util.Map;

public class DuplicateFinder {

	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		// if (nums.length == 0) {
		// return false;
		// }
		// for (int i = 0; i < nums.length; i++) {
		// int number = nums[i];
		// int otherIndex = Math.abs(k - i);
		// if (otherIndex < nums.length && otherIndex > 0 && otherIndex != i) {
		// if (nums[otherIndex] == number) {
		// return true;
		// }
		// }
		// }

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				int index = map.get(nums[i]);
				if(i - index <= k){
					return true;
				}
			} else {
				map.put(nums[i], i);
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int arr[] = { 99, 99 };
		System.out.println(containsNearbyDuplicate(arr, 2));
	}
}
