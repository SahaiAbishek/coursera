import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

	private WeightedQuickUnionUF weightedQuickUnionUF;
	private boolean[] arr;
	private int numberofOpensites;
	private int top = 0;
	private int bottom;
	private int length;

	// create n-by-n grid, with all sites blocked
	public Percolation(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Size can't be smaller than 0");
		}
		
		length = n;
		int size = n * n;
		bottom = size + 1;
		weightedQuickUnionUF = new WeightedQuickUnionUF(size + 2);
		arr = new boolean[size];
	}
	
	private void checkRange(int row, int col){
		if(row < 1 || col > length){
			throw new IllegalArgumentException("Row or column is outside the range");
		}
	}

	private int getIndex(int row, int col) {
		checkRange(row, col);
		row = row - 1;
		col = col - 1;
		return ((length * row) + col + 1);
	}

	// open site (row, col) if it is not open already
	public void open(int row, int col) {
		checkRange(row, col);
		
		int index = getIndex(row, col);
		if (!arr[index]) {
			arr[index] = true;
			numberofOpensites++;
		}

		// check and connect to neighbors

		// if it is the top row connect it to top
		if (row == 1) {
			weightedQuickUnionUF.union(index, top);
		}

		if (row == length) {
			weightedQuickUnionUF.union(index, bottom);
		}

		if (col > 1 && isOpen(row, col - 1)) {
			weightedQuickUnionUF.union(getIndex(row, col - 1), index);
		}
		if (col < length && isOpen(row, col + 1)) {
			weightedQuickUnionUF.union(getIndex(row, col + 1), index);
		}
		if (row > 1 && isOpen(row - 1, col)) {
			weightedQuickUnionUF.union(getIndex(row - 1, col), index);
		}
		if (row < length && isOpen(row + 1, col)) {
			weightedQuickUnionUF.union(getIndex(row + 1, col), index);
		}

	}

	// is site (row, col) open?
	public boolean isOpen(int row, int col) {
		checkRange(row, col);
		
		int index = getIndex(row, col);
		return arr[index];
	}

	// is site (row, col) full?
	public boolean isFull(int row, int col) {
		checkRange(row, col);
		return weightedQuickUnionUF.connected(getIndex(row, col), top);
	}

	// number of open sites
	public int numberOfOpenSites() {
		return numberofOpensites;
	}

	// does the system percolate?
	public boolean percolates() {
		return weightedQuickUnionUF.connected(top, bottom);
	}

	// test client (optional)
	public static void main(String[] args) {
		Percolation percolation = new Percolation(4);
		percolation.open(1, 1);
		percolation.open(2, 1);
		percolation.open(3, 1);
		percolation.open(4, 1);
		System.out.println("Number of open sites = "+percolation.numberOfOpenSites());
		System.out.println(percolation.percolates());
	}
}
