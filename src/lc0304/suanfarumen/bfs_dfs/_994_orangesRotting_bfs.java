package lc0304.suanfarumen.bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

public class _994_orangesRotting_bfs {

    int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public  int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count1 = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    count1++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        if (count1 > 0 && queue.isEmpty()) {
            return -1;
        }

        if (count1 == 0) {
            return 0;
        }

        int count11 = 0;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] crr = queue.poll();
                for (int[] mv : move) {
                    int ix = crr[0] + mv[0];
                    int iy = crr[1] + mv[1];
                    if (ix < 0 || iy < 0 || ix >= grid.length || iy >= grid[0].length || grid[ix][iy] != 1) {
                        continue;
                    }
                    count11++;
                    grid[ix][iy] = 2;
                    queue.offer(new int[]{ix, iy});
                }
            }
            level++;
        }

        if (count11 != count1) {
            return -1;
        }
        return level - 1;
    }
}
