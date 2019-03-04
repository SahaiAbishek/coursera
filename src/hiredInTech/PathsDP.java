/*
 * You are given a grid of cells with size N rows by M columns.
 * A robot is situated at the bottom-left cell (row N-1, column 0).
 * It can move from cell to cell but only to the right and to the top.
 * Some cells are empty and the robot can pass through them but others
 * are not and the robot cannot enter such cells. The robot cannot go
 *  outside the grid boundaries.
 */

package hiredInTech;

import java.util.ArrayList;
import java.util.List;

public class PathsDP {

    public static int count_the_paths(List<String> grid) {
        int rowLen = grid.size();
        int colLen = grid.get(0).length();
        int[][] arr = new int[grid.size()][grid.get(0).length()];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                arr[i][j] = -1;
            }
        }
        return count_the_paths(grid, arr, grid.size() - 1, 0);
    }

    public static int count_the_paths(List<String> grid, int[][] arr, int row, int col) {
        if (!isValidCell(grid, row, col)) {
            return 0;
        }
        if (isEnd(grid, row, col)) {
            return 1;
        }
        if (arr[row][col] != -1) {
            return arr[row][col];
        }
        int paths = 0;
        paths = count_the_paths(grid, arr, row - 1, col) + count_the_paths(grid, arr, row, col + 1);
        arr[row][col] = paths;
        return paths % 1000003;
    }

    private static boolean isEnd(List<String> grid, int row, int col) {
        if (row == 0 && col == grid.get(0).length() - 1) {
            return true;
        }
        return false;
    }

    private static boolean isValidCell(List<String> grid, int row, int col) {
        if ((row < 0 || row > grid.size() - 1) || (col < 0 || col > grid.get(row).length() - 1) || (grid.get(row).charAt(col) == '1')) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String row1 = "000";
        String row2 = "000";
        String row3 = "000";
        List<String> grid = new ArrayList<>();
        grid.add(row1);
        grid.add(row2);
        grid.add(row3);
        System.out.println("paths = " + count_the_paths(grid));
    }

}
