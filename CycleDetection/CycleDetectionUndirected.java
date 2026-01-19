import java.util.*;
class CycleDetectionUndirected {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (detectCycle(i,adj,vis)) return true;
            }
        }
        return false;
    }
    
    public boolean detectCycle (int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{node,-1});
        vis[node] = true;
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int n = t[0];
            int parent = t[1];
            
            for (int i : adj.get(n)) {
                if (!vis[i]) {
                    vis[i] = true;
                    q.add(new int[]{i,n});
                }
                else if (i != parent) {
                    return true;
                }
            }
        }
        return false;
    }
}