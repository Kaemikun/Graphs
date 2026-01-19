import java.util.*;
public class Dijkstra {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        // T.C = O(E log V)
        // S.C = O(V) + O(V)
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<int[]>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(new int[]{edges[i][1],edges[i][2]});
            adj.get(edges[i][1]).add(new int[]{edges[i][0],edges[i][2]});
            
        }
        dist[src] = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> (dist[a] - dist[b]));
        q.add(src);
        
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int i[] : adj.get(node)) {
                if (dist[node] + i[1] < dist[i[0]]) {
                    dist[i[0]] = dist[node] + i[1];
                    q.add(i[0]);
                }
            }
        }
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }
        return dist;
    }
}