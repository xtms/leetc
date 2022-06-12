package bfs.template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1034_colorBorder {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int value = grid[row][col];
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        visited[row][col] = true;
        List<int []> bordList = new ArrayList<>();
        dfs(grid, row, col, color, value, visited, bordList);
        for(int [] bb :bordList){
            grid[bb[0]][bb[1]] = color;
        }
        return grid;
    }

    int[][] move = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public void dfs(int[][] grid, int i, int j, int color, int value, boolean[][] visited, List<int[]> bordList) {
        if (grid[i][j] != value) {
            return;
        }
        boolean isBord = false;
        visited[i][j] = true;
        for (int[] mv : move) {
            int ix = mv[0] + i;
            int iy = mv[1] + j;
            if (ix < 0 || iy < 0 || ix >= grid.length || iy >= grid[0].length || grid[ix][iy] != value) {
                isBord = true; // i, j 是边界 或者 周围不是联通量的值
                continue;
            } else if (!visited[ix][iy]) {
                visited[ix][iy] = true;
                dfs(grid, ix, iy, color, value, visited, bordList);
            }
        }
        if(isBord){
            bordList.add(new int[]{i, j});
        }
    }
}
