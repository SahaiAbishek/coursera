package coursera;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {

	private int numberOFVertices;
	private int numberOfEdges;
	private LinkedList<Integer> adj[];

	/**
	 * create empty graph with V vertices
	 * 
	 * @param V
	 */
	public Graph(int V) {
		this.initGraph(V);
	}

	@SuppressWarnings("unchecked")
	private void initGraph(int V) {
		this.numberOFVertices = V;
		adj = (LinkedList<Integer>[]) new LinkedList[numberOFVertices];
		for (int i = 0; i < numberOFVertices; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	/**
	 * create a graph from input stream
	 * 
	 * @param in
	 */
	public Graph(InputStream in) {
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String str = null;
		try {
			int count = 0;
			while ((str = br.readLine()) != null) {
				if (count == 0) {
					initGraph(new Integer(str));
					count++;
					continue;
				}
				if (count == 1) {
					numberOfEdges = new Integer(str);
					count++;
					continue;
				}

				String[] values = str.split(" ");
				int v = new Integer(values[0]);
				int w = new Integer(values[1]);

				this.addEdge(v, w);

				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}

	/**
	 * vertices adjacent to vertex v
	 * 
	 * @param v
	 * @return
	 */
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	public int numberofVertices() {
		return numberOFVertices;
	}

	public int numberOfEdges() {
		return numberOfEdges;
	}

	@Override
	public String toString() {
		return "Graph []";
	}

	public static void main(String[] args) throws Exception {
		if (null == args[0]) {
			System.out.println("Please specify the file location using first arg");
		}else{
			InputStream is = new FileInputStream(args[0]);
			Graph g = new Graph(is);
			for(int i = 0;i<g.numberOFVertices;i++){
				Iterable<Integer> iterable  = g.adj(i);
				Iterator<Integer> itr = iterable.iterator();
				while(itr .hasNext()){
					System.out.println(i +" --> "+itr.next());
				}
			}
		}
	}

}
