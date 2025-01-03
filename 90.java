import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    // Constructor
    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    // Compare edges based on their weights
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

class DisjointSet {
    private int[] parent, rank;

    // Constructor
    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // Initialize parent to itself
            rank[i] = 0; // Initialize rank to 0
        }
    }

    // Find the parent of a node with path compression
    public int find(int u) {
        if (parent[u] != u) {
            parent[u] = find(parent[u]); // Path compression
        }
        return parent[u];
    }

    // Union by rank
    public void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootU != rootV) {
            // Union by rank
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }
}

public class 90 {
    private List<Edge> edges; // List of edges

    public KruskalMST() {
        edges = new ArrayList<>();
    }

    // Method to add an edge to the graph
    public void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }

    // Method to find the Minimum Spanning Tree using Kruskal's algorithm
    public void kruskalMST(int numVertices) {
        // Sort edges based on their weights
        Collections.sort(edges);

        DisjointSet ds = new DisjointSet(numVertices);
        List<Edge> mstEdges = new ArrayList<>(); // To store the edges of the MST
        int totalWeight = 0; // Total weight of the MST

        for (Edge edge : edges) {
            int u = edge.src;
            int v = edge.dest;
            int weight = edge.weight;

            // Check if adding this edge would form a cycle
            if (ds.find(u) != ds.find(v)) {
                ds.union(u, v); // Include this edge in the MST
                mstEdges.add(edge);
                totalWeight += weight;
            }
        }

        // Print the edges in the MST
        System.out.println("Edges in the Minimum Spanning Tree:");
        for (Edge edge : mstEdges) {
            System.out.println(edge.src + " -- " + edge.dest + " == " + edge.weight);
        }
        System.out.println("Total weight of Minimum Spanning Tree: " + totalWeight);
    }

    public static void main(String[] args) {
        KruskalMST graph = new KruskalMST();
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 3, 15);
        graph.addEdge(2, 3, 4);

        int numVertices = 4; // Number of vertices in the graph
        graph.kruskalMST(numVertices); // Find the MST
    }
}