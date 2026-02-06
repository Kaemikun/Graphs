import java.util.*;
public class KosarajuAlgo {
    // Function to find number of strongly connected components in the graph.
    
    public void DFS (int n, Stack<Integer> st, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[n] = true;
        
        
        for (int i : adj.get(n)) {
            if (!vis[i]) {
                DFS(i,st,vis,adj);
            }
        }
        st.push(n);
    }
    
    public void DFS3 (int n, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[n] = true;
        
  
        for (int i : adj.get(n)) {
            if (!vis[i]) {
                DFS3(i,vis,adj);
            }
        }
    }
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        // code here
        // T.C => O(V + E) + O(V + E) + O(V + E) ~ O(V + E)
        // S.C => O(2 * V) ~ O(V)
        
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[adj.size()];
        
        for (int i = 0; i < adj.size(); i++) {
            if (!vis[i]) {
                DFS(i,st,vis,adj);
            }
        }
        
        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
        
        for (int i = 0; i < adj.size(); i++) rev.add(new ArrayList<Integer>());
        
        for (int i = 0; i < adj.size(); i++) {
            vis[i] = false;
            for (int j : adj.get(i)) {
                rev.get(j).add(i);
            }
        }
        
        int ans = 0;
        
        while (!st.isEmpty()) {
            int node = st.pop();
            if (!vis[node]) {
                DFS3(node,vis,rev);
                ans++;
            }
        }
        
        return ans;
    }
}