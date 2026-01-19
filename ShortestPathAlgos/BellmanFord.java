import java.util.*;
public class BellmanFord {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        // T.C = O(V * E)
        // S.C = O(V);
        int[] dist = new int[V];
        Arrays.fill(dist, (int)(1e8));
        dist[src] = 0;
        for (int i = 0; i < V-1; i++) {
            
            for (int j[] : edges) {
                int u = j[0];
                int v = j[1];
                int wt = j[2];
                
                if (dist[u] != (int)(1e8) && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        // checking if its still getting relaxed meaning -ve cycle
        for (int j[] : edges) {
                int u = j[0];
                int v = j[1];
                int wt = j[2];
                
                if (dist[u] != (int)(1e8) && dist[u] + wt < dist[v]) {
                    return new int[]{-1};
                }
            }
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }
        return dist;
    }
}
