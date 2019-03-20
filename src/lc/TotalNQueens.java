package lc;

public class TotalNQueens {

	int res = 0;
	
	public int totalNQueens(int n) {
		int board[][] = new int[n][n];
		totalNQueens(board, 0, n, 0);
		return res;
	}

	public boolean isSafe(int[][] board, int row, int col, int n) {
		for (int i = 0; i < col; i++) {
			if (board[row][i] == 1) {
				return false;
			}
		}

		int r = row;
		int c = col;
		while (r >= 0 && c >= 0) {
			if (board[r][c] == 1) {
				return false;
			}
			r--;
			c--;
		}

		r = row;
		c = col;
		while (r < n && c >= 0) {
			if (board[r][c] == 1) {
				return false;
			}
			r++;
			c--;
		}

		return true;
	}

	public int totalNQueens(int[][] board, int col, int n, int result) {
		if (col == n) {
			res+=1;
		}
		for (int r = 0; r < n; r++) {
			if (isSafe(board, r, col, n)) {
				board[r][col] = 1;
				totalNQueens(board, col + 1, n, result);
				board[r][col] = 0;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		TotalNQueens nQueens = new TotalNQueens();
		System.out.println(nQueens.totalNQueens(4));
	}
}
