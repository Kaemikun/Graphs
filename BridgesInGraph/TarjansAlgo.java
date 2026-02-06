import java.util.ArrayList;
public class TarjansAlgo {
    int timer = 0;
    public void DFS (ArrayList<ArrayList<Integer>> adj, int node, int parent, boolean[] vis, int[] lin, int[] low, ArrayList<List<Integer>> bridge) {
        vis[node] = true;
        timer++;
        lin[node] = low[node] = timer;

        for (int i : adj.get(node)) {
            if (i == parent) continue;

            if (!vis[i]) {
                DFS (adj,i,node,vis,lin,low,bridge);
                low[node] = Math.min(low[i],low[node]);

                if (low[i] > lin[node]) {
                    List<Integer> t = new ArrayList<Integer>();
                    t.add(node);
                    t.add(i);
                    bridge.add(t);
                }
            }
            else {
                low[node] = Math.min(low[i],low[node]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < connections.size(); i++) {
            adj.get(connections.get(i).get(0)).add(connections.get(i).get(1));
            adj.get(connections.get(i).get(1)).add(connections.get(i).get(0));
        }

        int[] lin = new int[n];
        int[] low = new int[n];
        ArrayList<List<Integer>> bridges = new ArrayList<>();
        boolean[] vis = new boolean[n];
        DFS (adj,0,-1,vis,lin,low,bridges);
        return bridges;
    }
}