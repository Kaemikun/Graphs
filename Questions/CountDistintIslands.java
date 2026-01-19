// User function Template for Java
import java.util.*;
class countDistinctIslands {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        HashSet<ArrayList<String>> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    ArrayList<String> ar = new ArrayList<>();
                    dfs(i, j, grid, vis, ar, i, j);
                    hs.add(ar);
                }
            }
        }
        return hs.size();
    }
    
    public void dfs (int row, int col, int[][] grid, boolean[][] vis, ArrayList<String> ar,int row0, int col0) {
        vis[row][col] = true;
        int[] delRow = {1,-1,0,0};
        int[] delCol = {0,0,1,-1};
        int n = grid.length;
        int m = grid[0].length;
        
        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            
            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !vis[nRow][nCol] && grid[nRow][nCol] == 1) {
                ar.add((nRow - row0) + " " + (nCol - col0));
                dfs (nRow, nCol, grid, vis, ar, row0, col0);
            }
        }
    }
}
