package coursera;

public class QuickfindUF {

	private int id[];

	public QuickfindUF() {

	}

	public QuickfindUF(int N) {
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	public void union(int p, int q) {
		int pId = id[p];
		int qId = id[q];

		for (int i = 0; i < id.length; i++) {
			if(id[i]==pId){
				id[i]=qId;
			}
		}
	}

	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}

	public int find(int p) {
		return 0;
	}

	public int count() {
		return 0;
	}
}
