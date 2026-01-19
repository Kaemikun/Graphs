import java.util.*;
// T.C -> O(V + E)
// S.C -> O(V)
public class IsBipartiteBFS {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        for (int k = 0; k < n; k++) {
            if (vis[k] == -1) {
                Queue<Integer> q = new LinkedList<>();
                vis[k] = 0;
                q.add(k);
                while (!q.isEmpty()) {
                    int parent = q.poll();
                    for (int i : graph[parent]) {
                        if (vis[i] == -1) {
                            q.add(i);
                            if (vis[parent] == 0) {
                                vis[i] = 1;
                            } 
                            else vis[i] = 0;
                        } 
                        else {
                            if (vis[i] == vis[parent]) return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}