package bfs.template;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  算法思想： 先找到一个岛，然后把岛的值全部变为2, 然后往外扩，找到的第一个1就是最短的
 */
public class _934_shortestBridge {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        getFirstDao(grid, visited);
        return bfs(grid, visited);
    }

    public void getFirstDao(int[][] grid, boolean[][] visited) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, visited);
                    return;
                }
            }
        }
    }

    int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void dfs(int[][] grid, int i, int j, boolean[][] visited) {
        grid[i][j] = 2;
        visited[i][j] = true;
        for (int[] mv : move) {
            int ix = mv[0] + i;
            int iy = mv[1] + j;
            if (check(grid, ix, iy, visited) || grid[ix][iy] != 1) {
                continue;
            }
            dfs(grid, ix, iy, visited);
        }
    }

    private boolean check(int[][] heights, int ix, int iy, boolean[][] visited) {
        return ix < 0 || iy < 0 || ix >= heights.length || iy >= heights[0].length
                || visited[ix][iy];
    }

    public int bfs(int[][] grid, boolean[][] visited) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) { // 添加的点
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) { // 一层一层外扩
                int[] crr = queue.poll();
                for (int[] mv : move) {
                    int ix = mv[0] + crr[0];
                    int iy = mv[1] + crr[1];
                    if (check(grid, ix, iy, visited)) {
                        continue;
                    }
                    if (grid[ix][iy] == 1) { // 终止条件
                        return ans;
                    }
                    visited[ix][iy] = true;
                    queue.offer(new int[]{ix, iy});
                }
            }
            ans++;
        }
        return ans;
    }
}
