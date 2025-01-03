import java.util.HashMap;
import java.util.HashSet;

public class LongestCycleInGraph97 {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visited = new boolean[n];
        boolean[] inStack = new boolean[n];
        int longestCycleLength = -1;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                HashSet<Integer> currentPath = new HashSet<>();
                longestCycleLength = Math.max(longestCycleLength, dfs(i, edges, visited, inStack, currentPath));
            }
        }

        return longestCycleLength;
    }

    private int dfs(int node, int[] edges, boolean[] visited, boolean[] inStack, HashSet<Integer> currentPath) {
        if (node == -1) return -1; // No outgoing edge
        
        if (inStack[node]) {
            // Cycle detected
            return currentPath.size() - currentPath.indexOf(node);
        }

        if (visited[node]) return -1; // Already fully processed
        
        visited[node] = true;
        inStack[node] = true;
        currentPath.add(node);

        int nextNode = edges[node];
        int cycleLength = dfs(nextNode, edges, visited, inStack, currentPath);

        // Backtrack
        inStack[node] = false;
        currentPath.remove(node);

        return cycleLength;
    }

    public static void main(String[] args) {
        LongestCycleInGraph97 lcg = new LongestCycleInGraph97();
        
        int[] edges1 = {3, 3, 4, 2, 3};
        System.out.println(lcg.longestCycle(edges1)); // Output: 3
        
        int[] edges2 = {2, -1, 3, 1};
        System.out.println(lcg.longestCycle(edges2)); // Output: -1
    }
}
