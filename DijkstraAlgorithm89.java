import java.util.*;

public class DijkstraAlgorithm89 {
    private static final int INF = Integer.MAX_VALUE;

    public void dijkstra(int[][] graph, int source) {
        int count = graph.length; // Number of vertices
        int[] distance = new int[count]; // Distance from source
        boolean[] visited = new boolean[count]; // Track visited vertices

        // Initialize distances
        Arrays.fill(distance, INF);
        distance[source] = 0; // Distance to self is zero

        // Priority queue to select the vertex with the smallest distance
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{source, 0}); // {vertex, distance}

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0]; // Current vertex

            if (visited[u]) continue; // Skip if already visited
            visited[u] = true; // Mark as visited

            // Update distances for adjacent vertices
            for (int v = 0; v < count; v++) {
                if (graph[u][v] != 0 && !visited[v]) { // If there's an edge and not visited
                    int newDist = distance[u] + graph[u][v];
                    if (newDist < distance[v]) { // If new distance is shorter
                        distance[v] = newDist;
                        pq.offer(new int[]{v, newDist}); // Add to priority queue
                    }
                }
            }
        }

        // Print shortest distances from source
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < count; i++) {
            System.out.println(i + "\t\t" + (distance[i] == INF ? "INF" : distance[i]));
        }
    }

    public static void main(String[] args) {
        DijkstraAlgorithm89 dijkstra = new DijkstraAlgorithm89();
        
        // Example graph represented as an adjacency matrix
        int[][] graph = {
            {0, 7, 9, 0, 0, 14},
            {7, 0, 10, 15, 0, 0},
            {9, 10, 0, 11, 0, 2},
            {0, 15, 11, 0, 6, 0},
            {0, 0, 0, 6, 0, 9},
            {14, 0, 2, 0, 9, 0}
        };

        dijkstra.dijkstra(graph, 0); // Start from vertex 0
    }
}
