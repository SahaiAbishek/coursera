/*
 * https://leetcode.com/problems/spiral-matrix-ii/
 */
package lc;

public class SpiralMatrix2 {

	public static int[][] generateMatrix(int n) {

		int[][] result = new int[n][n];

		int rs = 0;
		int re = n - 1;
		int cs = 0;
		int ce = n - 1;

		int num = 1;
		while (rs <= re && cs <= ce) {
			for (int c = cs; c <= ce; c++) {
				result[rs][c] = num++;
			}
			for (int r = rs + 1; r <= re; r++) {
				result[r][ce] = num++;
			}
			for (int c = ce - 1; c >= cs; c--) {
				result[re][c] = num++;
			}

			for (int r = re - 1; r > rs; r--) {
				result[r][cs] = num++;
			}

			rs++;
			re--;
			cs++;
			ce--;
		}
		return result;
	}

	public static void main(String[] args) {
		int n = 0;
		int[][] matrix = generateMatrix(n);
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				System.out.print(matrix[r][c] + " ,");
			}
			System.out.println();
		}
	}

}
