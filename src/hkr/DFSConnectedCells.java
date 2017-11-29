package hkr;

public class DFSConnectedCells {

	public static int getBiggestRegion(int[][] matrix) {
		int max = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				int val = countCells(matrix, i, j);
				// System.out.println("value = "+val);
				max = Math.max(max, val);
				// System.out.println("Max = "+max);
			}
		}
		return max;
	}

	private static int countCells(int[][] matrix, int i, int j) {
		if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
			return 0;
		}
		if (matrix[i][j] == 0) {
			return 0;
		}
		int count = matrix[i][j]--;
		count += countCells(matrix, i + 1, j);
		count += countCells(matrix, i - 1, j);
		count += countCells(matrix, i, j + 1);
		count += countCells(matrix, i, j - 1);
		count += countCells(matrix, i + 1, j + 1);
		count += countCells(matrix, i - 1, j - 1);
		count += countCells(matrix, i - 1, j + 1);
		count += countCells(matrix, i + 1, j - 1);
		return count;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 0, 0, 1, 1 }, { 0, 0, 1, 0 }, { 0, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
		System.out.println(matrix.length + "    " + matrix[0].length);
		System.out.println(getBiggestRegion(matrix));

	}

}
