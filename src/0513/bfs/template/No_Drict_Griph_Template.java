package bfs.template;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 无向图最短路径模板
// 可以思考下有向图的处理方式？
// 解决最小、最短、最少问题
public class No_Drict_Griph_Template {
    public int countComponents(int n, int[][] edges) {
        // 1. 构图
        List<Integer>[] adj = new ArrayList[n];

        for(int i = 0; i < adj.length; i++){
            adj[i] = new ArrayList<>();
        }
        // 无向图，双向引用
        for (int [] edge : edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        // 2.广度搜索
        int res = 0;
        boolean [] visited = new boolean[n]; // 标记节点
        for(int i = 0; i < n; i ++){ // 每个节点遍历一次
            if(!visited[i]){
                bfs(adj, i, visited);
                res++; // 遍历一个联通图，数值加1
            }
        }
        return res;
    }

    private void bfs( List<Integer>[] adj, int u, boolean [] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        visited[u] = true;
        while (!queue.isEmpty()){
            Integer front = queue.poll();
            // 添加相邻一层节点到队列中，进行遍历
            List<Integer> child = adj[front];
            for (int ch : child){ // 遍历相邻的节点（遍历相邻的那一层）
                if(!visited[ch]){
                    queue.offer(ch);
                    visited[ch] = true;
                }
            }
        }
    }
}
