import java.util.*;
public class getComponents {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < edges.length; i++) {   
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        return connectedComponents(adjList, V);
        
        
    }
    
    public ArrayList<ArrayList<Integer>> connectedComponents (ArrayList<ArrayList<Integer>> adj, int n) {
        boolean[] vis = new boolean[n];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                ArrayList<Integer> cur = new ArrayList<>();
                dfs(i,vis,adj,cur);
                ans.add(cur);

            }
        }
        return ans;
    }

    public  void dfs (int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> cur) {
        vis[node] = true;
        cur.add(node);
        for (int i : adj.get(node)) {
            if (!vis[i]) {
                dfs(i,vis,adj,cur);
            }
        }
    }
}