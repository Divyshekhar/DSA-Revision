
import java.util.*;

class graphs {

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        int[][] vis = new int[m][n];
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2 && vis[i][j] == 0) {
                    vis[i][j] = 2;
                    q.offer(new int[]{i, j, 0});
                    fresh++;
                }
            }
        }
        int time = 0;
        int[] dr = {-1, 0, +1, 0};
        int[] dc = {0, -1, 0, +1};
        while (!q.isEmpty()) {
            int[] top = q.poll();
            int row = top[0];
            int col = top[1];
            int t = top[2];
            time = Math.max(time, t);
            for(int i = 0; i<4; i++){
                int newr = row + dr[i];
                int newc = col + dc[i];
                if(newr >= 0 && newr < m && newc >= 0 && newc < n && grid[newr][newc] == 1 && vis[newr][newc] == 0){
                    q.offer(new int[] {newr, newc, t + 1});
                    vis[newr][newc] = 2;
                    fresh--;
                }
            }
        }
        return (fresh == 0) ? time : -1;
    }

    public static void main(String[] args) {

    }
}
