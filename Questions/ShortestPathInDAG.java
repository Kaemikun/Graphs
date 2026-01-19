// User function Template for Java
import java.util.*;
public class ShortestPathInDAG {

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        Stack<Integer> st = new Stack<>();
        
        boolean[] vis = new boolean[V];
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<int[]>());    
        }
        
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(new int[]{edges[i][1],edges[i][2]});
        }
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, adj, vis, st);
            }
        }
        
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        while (!st.isEmpty()) {
            int node = st.pop();
            for (int i[] : adj.get(node)) {
                if (dist[node] != Integer.MAX_VALUE) {
                    int newDist = dist[node] + i[1];
                    if (dist[i[0]] > newDist) dist[i[0]] = newDist;
                }
            }
        }
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }
        return dist;
        
    }
    
    public void dfs (int node, ArrayList<ArrayList<int[]>> adj, boolean[] vis, Stack<Integer> st) {
        vis[node] = true;
        
        for (int i[] : adj.get(node)) {
            if (!vis[i[0]]) {
                dfs (i[0], adj, vis, st);
            }
        }
        st.push(node);
    }
    
}