package bfs.template;

import java.util.LinkedList;
import java.util.Queue;

public class _695_maxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean [][] visited = new boolean[n][m];
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    maxArea = Math.max(maxArea, bfs(grid, i, j, visited));
                }
            }
        }
        return maxArea == Integer.MIN_VALUE ? 0 : maxArea;
    }

    int [][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int bfs(int [][] grid, int i, int j, boolean [][] visited){
        visited[i][j] = true;
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        int count = 1;
        while (!queue.isEmpty()){
            int [] crr = queue.poll();
            for (int [] mv : move){
                int ix = mv[0] + crr[0];
                int iy = mv[1] + crr[1];
                if(notInArea(ix, iy, grid.length, grid[0].length) || grid[ix][iy] != 1 || visited[ix][iy]){
                    continue;
                }
                count++;
                visited[ix][iy] = true;
                queue.add(new int[]{ix, iy});
             }
        }
        return count;
    }

    private boolean notInArea(int i, int j, int rows, int cols) {
        return i < 0 || j < 0 || i >= rows
                || j >= cols;
    }

}
