package hiredInTech;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NetworkConnectivityGraph {

    private int nodes;
    private ArrayList[] adjVertices = null;
    int count = 0;

    public NetworkConnectivityGraph(int nodes) {
        this.nodes = nodes+1;
        adjVertices = new ArrayList[this.nodes];
        for (int i = 0; i < this.nodes; i++) {
            adjVertices[i] = new ArrayList();
        }
    }

    public void addVertex(int vertexI, int vertexJ) {
        adjVertices[vertexI].add(vertexJ);
        adjVertices[vertexJ].add(vertexI);
    }

    public List<Integer> getAdjNodes(int vertex) {
        return adjVertices[vertex];
    }

    public int dfs(int vertex, boolean[] visited, int reachable) {
        visited[vertex] = true;

        List<Integer> adjList = getAdjNodes(vertex);
        for (Integer adj : adjList) {
            if (!visited[adj]) {
                dfs(adj, visited, reachable + 1);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int S = sc.nextInt();
        NetworkConnectivityGraph graph = new NetworkConnectivityGraph(N);
        for (int i = 0; i < M; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            graph.addVertex(v1, v2);
        }
        System.out.println(graph.dfs(S,new boolean[N+1], 0));
        sc.close();
//        graph.addVertex(1, 2);
//        graph.addVertex(1, 4);
//        graph.addVertex(4, 2);
//        graph.addVertex(4, 3);
//        graph.addVertex(3, 1);
//        graph.addVertex(5, 6);
//        graph.addVertex(5, 7);
//        graph.addVertex(7, 7);
//        System.out.println(graph.getAdjNodes(2));
//        int count = graph.dfs(2, new boolean[8], 0);
//        System.out.println("Number of reachable nodes = " + count);
    }
}
