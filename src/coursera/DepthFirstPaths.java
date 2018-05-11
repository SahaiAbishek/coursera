package coursera;

public class DepthFirstPaths {

	private boolean[] marked;
	private int[] edgeTo;
	@SuppressWarnings("unused")
	private int s;

	public DepthFirstPaths(Graph graph, int s) {
		this.marked = new boolean[graph.numberofVertices()];
		this.edgeTo = new int[graph.numberofVertices()];
		this.s = s;
		dfs(graph, s);
	}

	private void dfs(Graph g, int v) {
		marked[v] = true;
		for (int w : g.adj(v)) {
			if (!marked[w]) {
				dfs(g, w);
				edgeTo[w] = v;
			}
		}
	}
}
