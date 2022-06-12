package bfs.template;

import java.util.LinkedList;
import java.util.Queue;

public class _200_numIslands {

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int landCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    landCount++;
                }
            }
        }
        return landCount;
    }


    int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void dfs(char[][] grid, int i, int j){
        if (notInArea(i, j, grid.length, grid[0].length) || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '2';

        for (int[] mv : move) {
            int ix = mv[0] + i;
            int iy = mv[1] + j;
            dfs(grid, ix, iy);
        }
    }

    public void bfs(char[][] grid, int i, int j) {
        grid[i][j] = '2';
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        int count = 1;
        while (!queue.isEmpty()) {
            int[] crr = queue.poll();
            for (int[] mv : move) {
                int ix = mv[0] + crr[0];
                int iy = mv[1] + crr[1];
                if (notInArea(ix, iy, grid.length, grid[0].length) || grid[ix][iy] != '1') {
                    continue;
                }
                count++;
                grid[ix][iy] = '2';
                queue.add(new int[]{ix, iy});
            }
        }
    }

    private boolean notInArea(int i, int j, int rows, int cols) {
        return i < 0 || j < 0 || i >= rows
                || j >= cols;
    }
}
