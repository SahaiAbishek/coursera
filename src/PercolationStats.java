import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

	private final int trials;
	private double[] fractions = null;

	// perform trials independent experiments on an n-by-n grid
	public PercolationStats(int n, int trials) {
		this.trials = trials;
		if (n < 0 || trials < 0) {
			throw new IllegalArgumentException("n or trials should be greater than 0");
		}
		fractions = new double[trials];

		for (int i = 0; i < trials; i++) {
			Percolation percolation = new Percolation(n);

			while (!percolation.percolates()) {
				int row = StdRandom.uniform(1, n + 1);
				int col = StdRandom.uniform(1, n + 1);
				percolation.open(row, col);
			}
			int openCells = percolation.numberOfOpenSites();
			int sz = n * n;
			double fraction = (double) openCells / sz;
			fractions[i] = fraction;
		}

	}

	// sample mean of percolation threshold
	public double mean() {
		return StdStats.mean(fractions);
	}

	// sample standard deviation of percolation threshold
	public double stddev() {
		return StdStats.stddev(fractions);
	}

	// low endpoint of 95% confidence interval
	public double confidenceLo() {
		return mean() - ((1.96 * stddev()) / Math.sqrt(trials));
	}

	// high endpoint of 95% confidence interval
	public double confidenceHi() {
		return mean() + ((1.96 * stddev()) / Math.sqrt(trials));
	}

	// test client (described below)
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		int T = Integer.parseInt(args[1]);
		PercolationStats ps = new PercolationStats(N, T);

		String confidence = "[" + ps.confidenceLo() + ", " + ps.confidenceHi() + "]";
		StdOut.println("mean                    = " + ps.mean());
		StdOut.println("stddev                  = " + ps.stddev());
		StdOut.println("95% confidence interval = " + confidence);
	}
}