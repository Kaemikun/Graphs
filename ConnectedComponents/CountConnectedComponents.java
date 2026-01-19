import java.util.*;
// T.C -> O(V + E)
// S.C -> O(V)
public class CountConnectedComponents {
    public static void main(String[] args) {
        int n = 10; // Number of nodes
        int m = 6; // Number of edges
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        // Sample edges
        int[][] edges = {{1, 2}, {2, 3}, {4, 5}, {5,6}, {7,8}, {9,10}};
        for (int i = 0; i < m; i++) {   
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        System.out.println(countConnectedComponents(adjList, n));

    }

    public static int countConnectedComponents (ArrayList<ArrayList<Integer>> adj, int n) {
        boolean[] vis = new boolean[n+1];
        int count = 0;
        for (int i = 1; i < n+1; i++) {
            if (!vis[i]) {
                dfs(i,vis,adj);
                count++;

            }
        }
        return count;
    }

    public static void dfs (int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;

        for (int i : adj.get(node)) {
            if (!vis[i]) {
                dfs(i,vis,adj);
            }
        }
    }
}
