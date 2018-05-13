package hkr;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class HKRGraph {

	private int vertices;
	private ArrayList<Integer> adj[];
	boolean marked[];
	int distance[];

	@SuppressWarnings("unchecked")
	public HKRGraph(int vertices) {
		this.vertices = vertices + 1;

		marked = new boolean[this.vertices];

		distance = new int[this.vertices];
		for (int i = 1; i < this.vertices; i++) {
			distance[i] = -1;
		}

		adj = new ArrayList[this.vertices];
		for (int i = 1; i < this.vertices; i++) {
			adj[i] = new ArrayList<>();
		}
	}

	public void addEdges(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}

	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	public void bfs(int v) {
		Queue<Integer> q = new LinkedBlockingQueue<>();
		q.add(v);
		marked[v] = true;
		distance[v] = 0;
		while (!q.isEmpty()) {

			int currentVertex = q.remove();
			for (int nextVertex : adj(currentVertex)) {
				if (!marked[nextVertex]) {
					distance[nextVertex] = distance[currentVertex] + 6;
					marked[nextVertex] = true;
					q.add(nextVertex);
				}
			}
		}
	}

	public void printDistances(int vertex) {
		for (int i = 1; i < this.vertices; i++) {
			if (vertex == i) {
				continue;
			}
			System.out.print(distance[i] + " ");
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int queries = in.nextInt();
		for (int qCount = 0; qCount < queries; qCount++) {
			int vertices = in.nextInt();
			int edges = in.nextInt();

			HKRGraph graph = new HKRGraph(vertices);
			for (int i = 0; i < edges; i++) {
				int v = in.nextInt();
				int w = in.nextInt();
				graph.addEdges(v, w);
			}
			int startingVertex = in.nextInt();
			graph.bfs(startingVertex);
			graph.printDistances(startingVertex);
		}
		in.close();
	}
}
