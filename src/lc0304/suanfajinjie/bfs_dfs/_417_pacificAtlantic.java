package lc0304.suanfajinjie.bfs_dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _417_pacificAtlantic {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] canRechPo = new boolean[n][m];
        boolean[][] canRechAo = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            dfs(heights, canRechAo, i, 0); // 第一列， 可以到Ao
            dfs(heights, canRechPo, i, m - 1); // 最后以列表，可以到po
        }

        for (int j = 0; j < m; j++) {
            dfs(heights, canRechAo, 0, j); // 第一行， 可以到Ao
            dfs(heights, canRechPo, n - 1, j); // 最后一行，可以到Po
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (canRechAo[i][j] && canRechPo[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    int [][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public void dfs(int [][] heights, boolean[][] canReach, int i, int j) {
        if (canReach[i][j]) {
            return;
        }
        canReach[i][j] = true;

        for (int[] mv : move) {
            int ix = mv[0] + i;
            int iy = mv[1] + j;
            if (ix < 0 || iy < 0 || ix >= heights.length
                    || iy >= heights[0].length
                    || heights[ix][iy] < heights[i][j]) {
                continue;
            }
            dfs(heights, canReach, ix, iy);
        }
    }

}
