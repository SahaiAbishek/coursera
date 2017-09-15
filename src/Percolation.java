import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

	
	
	private WeightedQuickUnionUF weightedQuickUnionUF;
	private int[] arr;
	private int numberofOpensites;

	// create n-by-n grid, with all sites blocked
	public Percolation(int n) {
		int size = n * n;
		numberofOpensites = size;
		weightedQuickUnionUF = new WeightedQuickUnionUF(size);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int pos = i + j + (n * i);
				arr[pos] = 0;
			}
		}
	}

	// open site (row, col) if it is not open already
	public void open(int row, int col) {

	}

	// is site (row, col) open?
	public boolean isOpen(int row, int col) {
		return false;
	}

	// is site (row, col) full?
	public boolean isFull(int row, int col) {
		return false;
	}

	// number of open sites
	public int numberOfOpenSites() {
		return numberofOpensites;
	}

	// does the system percolate?
	public boolean percolates() {
		return false;
	}

	// test client (optional)
	public static void main(String[] args) {

	}
}
