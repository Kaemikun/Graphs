
import java.util.HashMap;

public @interface MaxStonesRemoved {

    class Solution {

        class DSU {

            int[] parent;
            int[] size;
            int[] rank;

            DSU(int n) {
                parent = new int[n + 1];
                size = new int[n + 1];
                rank = new int[n];
                for (int i = 0; i < n + 1; i++) {
                    parent[i] = i;
                    size[i] = 1;
                }
            }

            public int findUPar(int node) {
                if (node == parent[node]) {
                    return node;
                }
                return parent[node] = findUPar(parent[node]);
            }

            public void unionByRank(int u, int v) {
                int ulp_u = findUPar(u);
                int ulp_v = findUPar(v);
                if (ulp_u == ulp_v) {
                    return;
                }
                if (rank[ulp_u] < rank[ulp_v]) {
                    parent[ulp_u] = ulp_v;
                } else if (rank[ulp_u] > rank[ulp_v]) {
                    parent[ulp_v] = ulp_u;
                } else {
                    parent[ulp_v] = ulp_u;
                    rank[ulp_u]++;
                }
            }

            public void unionBySize(int u, int v) {
                int ulp_u = findUPar(u);
                int ulp_v = findUPar(v);
                if (ulp_u == ulp_v) {
                    return;
                }

                if (size[ulp_u] < size[ulp_v]) {
                    parent[ulp_u] = ulp_v;
                    size[ulp_v] += size[ulp_u];
                } else {
                    parent[ulp_v] = ulp_u;
                    size[ulp_u] += size[ulp_v];
                }
            }
        }

        public int removeStones(int[][] stones) {
            int maxR = 0;
            int maxC = 0;
            for (int[] i : stones) {
                maxR = Math.max(maxR, i[0]);
                maxC = Math.max(maxC, i[1]);
            }

            DSU dsu = new DSU(maxR + maxC + 1);

            HashMap<Integer, Integer> hp = new HashMap<>();

            for (int[] i : stones) {
                int r = i[0];
                int c = i[1] + maxR + 1;
                dsu.unionBySize(r, c);
                hp.put(r, 1);
                hp.put(c, 1);
            }

            int ans = 0;
            for (var i : hp.entrySet()) {
                if (dsu.findUPar(i.getKey()) == i.getKey()) {
                    ans++;
                }
            }

            return stones.length - ans;
        }
    }
}
