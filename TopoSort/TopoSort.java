import java.util.*;
public class TopoSort {
    // T.C -> O(V + E)
    // S.C -> O(V) + O(V)
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        Stack<Integer> st = new Stack<>();
        
        boolean[] vis = new boolean[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());    
        }
        
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, adj, vis, st);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!st.isEmpty()) {
            ans.add(st.pop());
        }
        // System.out.print(ans);
        return ans;
    }
    
    public void dfs (int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> st) {
        vis[node] = true;
        
        for (int i : adj.get(node)) {
            if (!vis[i]) {
                dfs(i, adj, vis, st);
                
            }
        }
        st.add(node);
    }
}