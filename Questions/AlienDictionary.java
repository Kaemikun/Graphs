import java.util.*;
public class AlienDictionary {
    public String findOrder(String[] words) {
        // code here
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                hs.add(words[i].charAt(j));
            }
        }
        int v = hs.size();
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < words.length-1; i++) {
            String a = words[i];
            String b = words[i+1];
            
            int len = Math.min(a.length(), b.length());
            boolean found = false;
            for (int j = 0; j < len; j++) {
                if (a.charAt(j) != b.charAt(j)) {
                    adj.get(a.charAt(j) - 'a').add(b.charAt(j) - 'a');
                    found = true;
                    break;
                }
            }
            if (!found && a.length() > b.length()) return "";
        }            
        
        ArrayList<Integer> topo = topoSort(26,adj);
        
        
        StringBuilder ans = new StringBuilder();
        
        for (int i : topo) {
            char c = (char)('a' + i);
            if (hs.contains(c)) {
                ans.append(c);
            }
            
        }
        // System.out.print(ans);
        if (ans.length() != v) return "";
        return ans.toString();
    }
    
    public ArrayList<Integer> topoSort(int V, ArrayList<ArrayList<Integer>> adj ) {
        
        
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