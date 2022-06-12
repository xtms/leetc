package bfs.template;

import java.util.*;

/**
 * 典型的bfs、 dfs的题目
 * https://leetcode.cn/problems/pacific-atlantic-water-flow/
 */

public class _417_pacificAtlantic {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        boolean [][] canReachPo = new boolean[m][n];
        boolean [][] canReachAo = new boolean[m][n];
        // 列处理
        for (int i = 0; i < n; i++){
            // 第一行 po
            dfs(heights, canReachPo, 0, i);
            // 最后一行 ao
            dfs(heights, canReachAo, m-1,  i);
        }
        // 行处理
        for (int j = 0; j < m; j++){
            // 第一列 po
            dfs(heights, canReachPo, j, 0);
            // 最后一列 ao
            dfs(heights, canReachAo, j,  n-1);
        }

        // 查询相交的值
        for (int i = 0; i < m; i++){
             for (int j = 0; j < n; j++){
                 if (canReachAo[i][j] && canReachPo[i][j]){
                     ans.add(Arrays.asList(i, j));
                 }
             }
        }
        return ans;
    }

    int [][] move = {{0, 1},{0, -1},{1, 0},{-1, 0}};
    public void dfs(int [][] heights, boolean [][] canReach, int i, int j) {
        if (canReach[i][j]) {
            return;
        }
        canReach[i][j] = true;
        for (int k = 0; k < move.length; k++) {
            int ix = move[k][0] + i;
            int iy = move[k][1] + j;
            if (check(heights, i, j, ix, iy) || canReach[ix][iy]) { // 越界或者找的下一个比当前的小，都要跳过
                continue;
            }
            dfs(heights, canReach, ix, iy);
        }
    }

    private boolean check(int[][] heights, int i, int j, int ix, int iy) {
        return ix < 0 || iy < 0 || ix >= heights.length || iy >= heights[0].length
                || heights[ix][iy] < heights[i][j];
    }

    public void bfs(int [][] heights, boolean [][] canReach, int i, int j) {
        if (canReach[i][j]) {
            return;
        }
        canReach[i][j] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] crr = queue.poll();
            for (int k = 0; k < move.length; k++) { // 此时添加的是 crr的值
                int ix = move[k][0] + crr[0];
                int iy = move[k][1] + crr[1];
                if (check(heights, crr[0], crr[1], ix, iy) || canReach[ix][iy]) {  // 还需要判断一下ix、iy的值, 和
                    continue;
                }
                canReach[ix][iy] = true;
                queue.offer(new int[]{ix, iy});
            }
        }
    }
}
