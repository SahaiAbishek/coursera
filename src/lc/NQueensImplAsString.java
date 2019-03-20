package lc;

import java.util.ArrayList;
import java.util.List;

public class NQueensImplAsString {

	// initialize board as list of strings
	public static List<StringBuffer> init(int n) {
		List<StringBuffer> board = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringBuffer list = new StringBuffer();
			for (int j = 0; j < n; j++) {
				list.append(".");
			}
			board.add(list);
		}
		return board;
	}

	// pass board, row and column number and check for any queens before it.
	public static boolean isSafe(List<StringBuffer> board, int row, int col, int n) {
		// check the left of column for any queens
		for (int i = 0; i < col; i++) {
			if (board.get(row).charAt(i) == 'Q') {
				return false;
			}
		}

		// check the diagonals for any other queens
		int r = row;
		int c = col;
		while (r > 0 && c > 0) {
			r--;
			c--;
			if (board.get(r).charAt(c) == 'Q') {
				return false;
			}

		}

		r = row;
		c = col;
		while (r < n && c < n) {

			if (board.get(r).charAt(c) == 'Q') {
				return false;
			}
			r++;
			c++;
		}

		r = row;
		c = col;
		while (r < n - 1 && c > 0) {
			r++;
			c--;
			if (board.get(r).charAt(c) == 'Q') {
				return false;
			}
		}

		r = row;
		c = col;
		while (r > 0 && c < n - 1) {
			r--;
			c++;
			if (board.get(r).charAt(c) == 'Q') {
				return false;
			}
		}

		return true;
	}

	public static List<List<String>> solveNQueens(int n) {
		List<StringBuffer> board = init(n);
		return solveNQueens(board, 0, n, new ArrayList<>());
	}

	public static List<List<String>> solveNQueens(List<StringBuffer> board, int col, int n,
			List<List<String>> results) {
		if (col == n) {
			List<String> res = new ArrayList<>();
			for (StringBuffer sb : board) {
				res.add(sb.toString());
			}
			results.add(res);
		}

		for (int row = 0; row < n; row++) {
			if (isSafe(board, row, col, n)) {
				StringBuffer sb = board.get(row);
				sb.setCharAt(col, 'Q');
				solveNQueens(board, col + 1, n, results);
				sb = board.get(row);
				sb.setCharAt(col, '.');
			}
		}

		return results;
	}

	public static void main(String[] args) {
		int n = 4;
		System.out.println(solveNQueens(n));
	}

}
