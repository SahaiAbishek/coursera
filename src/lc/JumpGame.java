package lc;

import java.util.HashMap;
import java.util.Map;

public class JumpGame {

	private static Map<Integer, Boolean> map = new HashMap<>();

	public static boolean canJump(int[] nums) {
		return canJump(nums, 0);
	}

	public static boolean canJumpBottomUp(int[] nums) {

		boolean[] map = new boolean[nums.length];
		map[nums.length - 1] = true;
		for (int i = nums.length - 2; i >= 0; i--) {
			int end = 0;
			int jump = nums[i];
			if (jump + i > nums.length - 1) {
				end = nums.length - 1;
			} else {
				end = jump + i;
			}
			for (int j = i + 1; j <= end; j++) {
				if (map[j]) {
					map[i] = true;
					break;
				}
			}
		}
		for (boolean bVal : map)
			System.out.print(bVal + ", ");
		return map[0] == true;
	}

	public static boolean canJump(int[] nums, int pos) {
		if (pos == nums.length - 1) {
			return true;
		}
		boolean retval = false;
		if (map.containsKey(pos)) {
			return retval || map.get(pos);
		} else {
			int farthest = 0;
			int jump = nums[pos];
			if (jump + pos > nums.length - 1) {
				farthest = nums.length - 1;
			} else {
				farthest = jump + pos;
			}

			for (int i = pos + 1; i <= farthest; i++) {
				retval = retval || canJump(nums, i);
				map.put(pos, retval);
			}
		}
		return retval;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 0, 4 };
		System.out.println("\nresult = "+canJumpBottomUp(nums));
	}

}
