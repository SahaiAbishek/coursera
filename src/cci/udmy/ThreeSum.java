package cci.udmy;

import java.util.ArrayList;
import java.util.List;

public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> lists = new ArrayList<>();
		int len = nums.length;
		for (int i = 0; i < len - 2; i++) {
			for (int j = 0; j < len - 1; j++) {
				for (int k = 0; k < len; k++) {
					if ((nums[i] + nums[j] + nums[k]) == 0) {
						List<Integer> list = new ArrayList<>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[k]);
						lists.add(list);
					}
				}
			}
		}
		return lists;
	}

}
