package dfs;

import bfs.template._offer13_movingCount;

/**
 * 解题思路：
 * 1、本题转化为求解相邻节点着色问题。
 * 2、着两种不通的颜色，用0 和 1 -0 进行巧妙地处理。
 * 3、同时要注意的是dfs种已经访问和未访问的处理方式不同。
 */
public class _785_isBipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (!dfs(graph, i, visited, color, 0)) {
                    return false;
                }
            }

        }
        return true;
    }

    // 传参可以使用全局变量进行代替
    private boolean dfs(int[][] graph, int i, boolean[] visited, int[] color, int cl) {
        visited[i] = true;
        color[i] = cl;
        for (int neg : graph[i]) {
            if (!visited[neg]) {
                if (!dfs(graph, neg, visited, color, 1 - cl)) { // 1 - cl 是要计算 i 节点和 neg 节点着色不一样
                    return false;
                }
            } else {
                if (color[neg] == color[i]) { // 如果遍历节点和邻居一样
                    return false;
                }
            }
        }
        return true;
    }
}
