package ds.graph;

import java.util.LinkedList;

public class MyGraph {
    int numVertices;
    LinkedList<Integer> adj[];

    public MyGraph(int vertices) {
        numVertices = vertices;
        adj = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest) {
        adj[src].add(dest);
        adj[dest].add(src);
    }

    public LinkedList<Integer> getAdj(int v) {
        return adj[v];
    }

    public boolean isConnected(int v, int w) {
        return getAdj(v).contains(w);
    }

    public int degree(int v) {
        return getAdj(v).size();
    }

    public int getNumVertices() {
        return numVertices;
    }

    public int getNumEdges() {
        int count = 0;

        for (int i = 0; i < numVertices; i++) {
            count += getAdj(i).size();
        }

        return count / 2;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
