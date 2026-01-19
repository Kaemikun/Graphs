import java.util.*;
class orangesRotting {
    int[] row = {1,-1,0,0};
    int[] col = {0,0,1,-1};
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    
                    q.add(new int[]{i,j});
                }
            }
        }
        return  bfs (grid,vis,n,m,q);
        
    }

    public int bfs(int[][] grid, boolean[][] vis, int n, int m, Queue<int[]> q) {
        
        
        int cnt = 0;
        while (!q.isEmpty()) {
            boolean fl  = false;
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int[] t = q.poll();
                int r = t[0];
                int c = t[1];
                vis[r][c] = true;
                for (int k = 0; k < 4; k++) {
                    if ((r + row[k] >= 0 && r + row[k] < n && c + col[k] >= 0 && c + col[k] < m) && (!vis[r + row[k]][c + col[k]]) && grid[r+row[k]][c + col[k]] == 1) {
                        q.add(new int[]{r + row[k], c + col[k]});
                        vis[r + row[k]][c + col[k]] = true;
                        fl = true;
                    }
                }
            }
            if (fl) cnt++;
         
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && vis[i][j] == false) return -1;
            }
        }
        return cnt;
    }
}