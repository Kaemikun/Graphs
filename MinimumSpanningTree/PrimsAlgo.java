import java.util.*;
public class PrimsAlgo {
    public int spanningTree(int V, int[][] edges) {
        // code here
        // T.C -> E log E
        // S.C -> O(E + V) + O(V) -> O(E)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<int[]>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(new int[]{edges[i][1],edges[i][2]});
            adj.get(edges[i][1]).add(new int[]{edges[i][0],edges[i][2]});
        }
        int sum = 0;
        pq.add(new int[]{0,0});
        
        boolean[] visited = new boolean[V];
        
        while (!pq.isEmpty()) {
            int[] t = pq.poll();
            int node = t[0];
            int wt = t[1];
            if (visited[node]) continue;
            sum += wt;
            visited[node] = true;
            for (int[]i : adj.get(node)) {
                if (!visited[i[0]]) {
                    pq.add(new int[]{i[0],i[1]});
                }
            }
        }
        
        return sum;
    }
}
