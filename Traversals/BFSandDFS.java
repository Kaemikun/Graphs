import java.util.*;
public  class BFSandDFS {
    public  void help (boolean[] vis,ArrayList<ArrayList<Integer>> adj, int node, ArrayList<Integer> ans) {
      if (vis[node]) return;
      ans.add(node);
      vis[node] = true;
      for (int i : adj.get(node)) {
        if (!vis[i]) {
          help (vis,adj,i,ans);
        }
      }
    }
    public ArrayList<Integer> dfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj) {
      ArrayList<Integer> ans = new ArrayList<>();
      boolean[] vis = new boolean[V];
      help(vis,adj,0,ans);
      return ans;
    }
    
    public ArrayList<Integer> bfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[V];
        q.add(0);
        while (!q.isEmpty()) {
          int p = q.poll();
          ans.add(p);
          vis[p] = true;
          for (int i : adj.get(p)) {
            if (!vis[i])
                q.add(i);
                vis[i] = true;
          }
        }
        return ans;
    }
}

