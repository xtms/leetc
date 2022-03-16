package lc0304.suanfarumen.bfs_dfs;

public class _994_orangesRotting {
    public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    count1++;
                } else if (grid[i][j] == 2) {
                    count2++;
                }
            }
        }

        if (count1 == 0 || count2 == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    ans = Math.min(ans, dfs(grid, i, i));
                }
            }
        }

        int lastCount1 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    lastCount1++;
                }
            }
        }
        return lastCount1 > 0 ? -1 : ans;
    }

     static  int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static int dfs(int[][] grid, int i, int j) {
        int ans = 1;
        for (int[] mv : move) {
            int ix = i + mv[0];
            int iy = j + mv[1];
            if (ix < 0 || iy < 0 || ix >= grid.length || iy >= grid[0].length || grid[ix][iy] != 1) {
                continue;
            }
            grid[ix][iy] = 2;
            ans += dfs(grid, ix, iy);
        }
        return ans;
    }

    public static void main(String[] args) {
        int [][] nums = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(nums));
    }
}
