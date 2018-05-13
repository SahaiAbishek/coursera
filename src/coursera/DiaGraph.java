package coursera;

import java.util.LinkedList;

public class DiaGraph {

	private int vertices;
	private LinkedList<Integer> adj[];

	@SuppressWarnings("unchecked")
	public DiaGraph(int vertices) {
		this.vertices = vertices;
		adj = (LinkedList<Integer>[]) new LinkedList[vertices];
		for (int i = 0; i < this.vertices; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
	}

	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

}
