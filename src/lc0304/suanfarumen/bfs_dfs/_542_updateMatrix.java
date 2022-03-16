package lc0304.suanfarumen.bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

public class _542_updateMatrix {
    public int[][] updateMatrix(int[][] mat) { // 算面积
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] see = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    see[i][j] =true;
                }
            }
        }

        while (!queue.isEmpty()){
            int [] crr = queue.poll();
            for(int [] mv : move){
                int ix = mv[0] + crr[0];
                int iy = mv[1] + crr[1];
                if(ix < 0 || iy < 0 || ix >= n || iy >= m || see[ix][iy]){
                    continue;
                }
                see[ix][iy] = true;
                mat[ix][iy] = mat[crr[0]][crr[1]] + 1;
                queue.offer(new int[]{ix, iy});
            }
        }
        return mat;
    }
}
