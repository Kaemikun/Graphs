import java.util.*;
public class KahnAlgo {
    // T.C -> O(V + E)
    // S.C -> O(V) + O(V)
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        boolean[] vis = new boolean[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());    
        }
        
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        int[] indegree = new int[V];
        
        for (int i = 0; i < V; i++) {
            for (int j : adj.get(i)) {
                indegree[j]++;
            }
        }
        
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) q.add(i);
        }
        ArrayList<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);
            for (int i : adj.get(node)) {
                indegree[i]--;
                if (indegree[i] == 0) q.add(i);
            }
        }
        return topo;
    }
    
}