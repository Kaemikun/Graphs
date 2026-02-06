import java.util.*;
public class KrushkalsAlgo {
    // T.C => O(E log E) + O(E * 4 * α * 2) ~ O(E log E)
    // S.C => O(2 * V) ~ O(V)
    class DSU {
        int[] parent;
        int[] size;
        
        DSU (int n) {
            parent = new int[n];
            size = new int[n];
            
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        
        public int findUP(int u) {
            if (parent[u] == u) return u;
            
            return parent[u] = findUP(parent[u]);
        }
        
        public void union (int u, int v) {
            int uP = findUP(u);
            int vP = findUP(v);
            
            if (uP == vP) return;
            
            if (size[uP] > size[vP]) {
                parent[vP] = uP;
                size[uP] += size[vP];
            }
            else {
                parent[uP] = vP;
                size[vP] += size[uP];
            }
        }
    }
    public int spanningTree(int V, int[][] edges) {
        int sum = 0;

        DSU dsu = new DSU(V);
        Arrays.sort(edges, (a,b) -> a[2] - b[2]);
        for (int i = 0; i < edges.length; i++) {
            
            if (dsu.findUP(edges[i][0]) != dsu.findUP(edges[i][1])) {
                dsu.union(edges[i][0], edges[i][1]);
                sum += edges[i][2];
            }
        }
        
        return sum;
    }
}