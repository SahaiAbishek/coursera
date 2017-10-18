import java.util.LinkedList;
import java.util.List;

public class Board {

	private int[][] blocks;
	private int moves;
	private final int dimension;

	// construct a board from an n-by-n array of blocks
	// (where blocks[i][j] = block in row i, column j)
	public Board(int[][] blocks) {
		int lenght = blocks.length;
		this.blocks = new int[lenght][lenght];
		for (int i = 0; i < lenght; i++) {
			for (int j = 0; j < lenght; j++) {
				blocks[i][j] = this.blocks[i][j];
			}
		}
		dimension = blocks.length;
	}

	// board dimension n
	public int dimension() {
		return this.dimension;
	}

	private int getValueOfblock(int row, int col) {
		if (row == dimension - 1 && col == dimension - 1) {
			return 0;
		} else {
			return row * dimension + col + 1;
		}
	}

	// number of blocks out of place
	public int hamming() {
		int hammingScore = moves;
		int lenght = blocks.length;
		for (int i = 0; i < lenght; i++) {
			for (int j = 0; j < lenght; j++) {
				int currentval = blocks[i][j];
				int correctblockValue = getValueOfblock(i, j);
				if (currentval != 0 && currentval - correctblockValue == 0) {
					hammingScore++;
				}
			}
		}
		return hammingScore;
	}

	// sum of Manhattan distances between blocks and goal
	public int manhattan() {
		int manhattnDistance = moves;
		int lenght = blocks.length;
		for (int i = 0; i < lenght; i++) {
			for (int j = 0; j < lenght; j++) {
				int currentVal = blocks[i][j];
				if (currentVal != 0) {
					int correctval = getValueOfblock(i, j);
					if (currentVal != correctval) {
						int row = currentVal - 1 / lenght;
						int col = currentVal - 1 - (row * lenght);

						manhattnDistance += Math.abs(row - i) + Math.abs(col - j);
					}
				}
			}
		}
		return manhattnDistance;
	}

	// is this board the goal board?
	public boolean isGoal() {
		int lenght = blocks.length;
		for (int i = 0; i < lenght; i++) {
			for (int j = 0; j < lenght; j++) {
				int currentVal = blocks[i][j];
				int expectedVal = getValueOfblock(i, j);
				if (currentVal != expectedVal) {
					return false;
				}
			}
		}
		return true;
	}

	// a board that is obtained by exchanging any pair of blocks
	public Board twin() {
		int[][] twinBlock = new int[dimension][dimension];
		int lenght = blocks.length;
		for (int i = 0; i < lenght; i++) {
			for (int j = 0; j < lenght; j++) {
				twinBlock[i][j] = this.blocks[i][j];
			}
		}
		// exchange the first 2 tiles of the 1st row, or 2nd row
		if (twinBlock[0][0] != 0 && twinBlock[0][1] != 0) {
			int temp = twinBlock[0][0];
			twinBlock[0][0] = twinBlock[0][1];
			twinBlock[0][1] = temp;
		} else {
			int temp = twinBlock[1][0];
			twinBlock[1][0] = twinBlock[1][1];
			twinBlock[1][1] = temp;
		}

		Board twin = new Board(twinBlock);

		return twin;

	}

	// does this board equal y?
	public boolean equals(Object y) {
		if (y == null) {
			return false;
		}
		if (this == y) {
			return true;
		}
		if (this.getClass() != y.getClass()) {
			return false;
		}
		Board that = (Board) y;
		if (this.dimension != that.dimension) {
			return false;
		}

		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				if (this.blocks[i][j] != that.blocks[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	private int[][] buildblock(int[][] block) {
		block = new int[dimension][dimension];
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				block[i][j] = blocks[i][j];
			}
		}
		return block;
	}

	// all neighboring boards
	public Iterable<Board> neighbors() {
		int tempRow = 0;
		int tempCol = 0;
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				if (blocks[i][j] == 0) {
					tempRow = i;
					tempCol = j;
				}
			}
		}

		List<Board> neighbours = new LinkedList<>();

		// down
		if (tempRow < dimension - 1) {
			int[][] downBlocks = buildblock(blocks);
			int temp = downBlocks[tempRow][tempCol];
			downBlocks[tempRow][tempCol] = blocks[tempRow + 1][tempCol];
			downBlocks[tempRow + 1][tempCol] = temp;
			neighbours.add(new Board(downBlocks));
		}

		// up
		if (tempRow > 0) {
			int[][] upBlocks = buildblock(blocks);
			int temp = upBlocks[tempRow][tempCol];
			upBlocks[tempRow][tempCol] = blocks[tempRow - 1][tempCol];
			upBlocks[tempRow - 1][tempCol] = temp;
			neighbours.add(new Board(upBlocks));
		}

		// left
		if (tempCol < dimension - 1) {
			int[][] leftblock = buildblock(blocks);
			int temp = leftblock[tempRow][tempCol];
			leftblock[tempRow][tempCol] = blocks[tempRow][tempCol + 1];
			leftblock[tempRow][tempCol + 1] = temp;
			neighbours.add(new Board(leftblock));
		}

		// right
		if (tempCol > 0) {
			int[][] rightBlock = buildblock(blocks);
			int temp = rightBlock[tempRow][tempCol];
			rightBlock[tempRow][tempCol] = blocks[tempRow][tempCol - 1];
			rightBlock[tempRow][tempCol - 1] = temp;
			neighbours.add(new Board(rightBlock));
		}
		return neighbours;
	}

	// string representation of this board (in the output format specified
	// below)
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(dimension + "\n");
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				sb.append(blocks[i][j] + " ");
			}
			sb.append("\n");
		}

		return sb.toString();
	}

	// unit tests (not graded)
	public static void main(String[] args) {

	}
}