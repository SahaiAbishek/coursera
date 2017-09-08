package coursera;

public class WeightedQuickUnion {

	private int id[];
	private int sz[];

	public WeightedQuickUnion() {

	}

	public WeightedQuickUnion(int N) {
		sz = new int[N];
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	private int root(int i) {
		while (id[i] == i) {
			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}

	public void union(int p, int q) {
		int pRoot = root(p);
		int qRoot = root(q);
		if (pRoot == qRoot)
			return;
		if (sz[pRoot] < sz[qRoot]) {
			id[pRoot] = qRoot;
			sz[qRoot] += sz[pRoot];
		} else {
			id[qRoot] = pRoot;
			sz[pRoot] += sz[qRoot];
		}
		id[pRoot] = qRoot;
	}

	public boolean connected(int p, int q) {
		return root(p) == root(p);
	}

}
