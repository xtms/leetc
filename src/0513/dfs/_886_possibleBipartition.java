package dfs;

import jdk.nashorn.internal.ir.LiteralNode;

import java.util.ArrayList;
import java.util.List;

public class _886_possibleBipartition {

    public boolean possibleBipartition(int  n, int[][] graph) {
        List<Integer>[] graphAdj = new ArrayList[n+1];
        boolean[] visited = new boolean[n+1];
        int[] color = new int[n+1];
        for (int i = 1; i <=n ; i++){
            graphAdj[i] = new ArrayList<>();
        }

        for (int [] gr : graph){
            graphAdj[gr[0]].add(gr[1]);
            graphAdj[gr[1]].add(gr[0]);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (!dfs(graphAdj, i, visited, color, 0)) {
                    return false;
                }
            }

        }
        return true;
    }

    // 传参可以使用全局变量进行代替
    private boolean dfs( List<Integer>[]  graphadj, int i, boolean[] visited, int[] color, int cl) {
        visited[i] = true;
        color[i] = cl;
        List<Integer> child = graphadj[i];
        if (child != null) {
            for (int neg : graphadj[i]) {
                if (!visited[neg]) {
                    if (!dfs(graphadj, neg, visited, color, 1 - cl)) { // 1 - cl 是要计算 i 节点和 neg 节点着色不一样
                        return false;
                    }
                } else {
                    if (color[neg] == color[i]) { // 如果遍历节点和邻居一样
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
