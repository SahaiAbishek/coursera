/*
 * https://leetcode.com/problems/spiral-matrix/
 * 
	Input:
	[
	 [ 1, 2, 3 ],
	 [ 4, 5, 6 ],
	 [ 7, 8, 9 ]
	]
Output: [1,2,3,6,9,8,7,4,5]
 */

package lc;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static List<Integer> printSpiralOrder(int[][] matrix) {
		if (matrix.length == 0) {
			return new ArrayList<>();
		}
		List<Integer> result = new ArrayList<>();
		int r1 = 0;
		int r2 = matrix.length - 1;
		int c1 = 0;
		int c2 = matrix[0].length - 1;

		while (r1 <= r2 && c1 <= c2) {
			for (int c = c1; c <= c2; c++) {
				result.add(matrix[r1][c]);
			}
			for (int r = r1 + 1; r <= r2; r++) {
				result.add(matrix[r][c2]);
			}
			if (r1 < r2) {
				for (int c = c2 - 1; c >= c1; c--) {
					result.add(matrix[r2][c]);
				}

			}
			if (c1 < c2) {
				for (int r = r2 - 1; r >= r1 + 1; r--) {
					result.add(matrix[r][c1]);
				}
			}

			r1++;
			r2--;
			c1++;
			c2--;
		}
		return result;

	}

	public static void main(String[] args) {
		int matrix[][] = { { 1 }, { 2 }, { 3 } };
		System.out.println(printSpiralOrder(matrix));
	}

}
