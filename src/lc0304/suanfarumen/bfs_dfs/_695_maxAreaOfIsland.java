package lc0304.suanfarumen.bfs_dfs;

public class _695_maxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, dfs(grid, visited, i, j));
                }
            }
        }
        return ans;
    }

    int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int dfs(int[][] grid, boolean[][] visited, int i, int j) {
        if (i > grid.length - 1 || j > grid[0].length - 1 || i < 0 || j < 0 || visited[i][j] || grid[i][j] != 1) {
            return 0;
        }
        int ans = 1; // 当前节点算一个
        grid[i][j] = 0; // 换成0
        visited[i][j] = true;
        for (int[] mv : move) {
            int ix = mv[0] + i;
            int iy = mv[1] + j;
            ans += dfs(grid, visited, ix, iy);
        }
        return ans;
    }
}
