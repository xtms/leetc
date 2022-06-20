package dfs;

import java.util.ArrayList;
import java.util.List;

public class _323_countComponents {
    public int countComponents(int n, int[][] edges) {
        int ans = 0;
        List<Integer>[] adj = new ArrayList[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edg : edges) {
            adj[edg[0]].add(edg[1]);
            adj[edg[1]].add(edg[0]);
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(adj, visited, i);
                ans++;
            }
        }
        return ans;
    }

    private void dfs(List<Integer>[] adj, boolean[] visited, int i) {
        visited[i] = true;
        List<Integer> child = adj[i];
        for (int ch : child) {
            if (!visited[ch]) {
                dfs(adj, visited, ch);
            }
        }
    }
}
