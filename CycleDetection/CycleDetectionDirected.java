import java.util.*;
public class CycleDetectionDirected {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i, adj, vis, pathVis)) return true;
            }
        }
        return false;
    }
    
    public boolean dfs (int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] pathVis) {
        vis[node] = true;
        pathVis[node] = true;
        for (int i : adj.get(node)) {
            if (!vis[i]) {
                if(dfs(i,adj,vis,pathVis)) return true;
            }
            else if (pathVis[i]) return true;
        }
        
        pathVis[node] = false;
        return false;
    }
}