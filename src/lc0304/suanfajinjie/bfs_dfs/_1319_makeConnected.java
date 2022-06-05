package lc0304.suanfajinjie.bfs_dfs;

import java.util.ArrayList;
import java.util.List;

public class _1319_makeConnected {
    boolean[] used;
    List<Integer>[] arrCo;

    public int makeConnected(int n, int[][] connections) {
        int conLength = connections.length;
        used = new boolean[n];
        arrCo = new List[n];
        if (n - 1 > conLength) {
            return -1;
        }
        for (int i = 0; i < n; i++) {
            arrCo[i] = new ArrayList<>();
        }

        for (int[] conne : connections) {
            arrCo[conne[0]].add(conne[1]);
            arrCo[conne[1]].add(conne[0]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {

            if (!used[i]) {
                dfs(i);
                ans++; // 计算独立的联通量， 结果就是联通量-1，前提是多余的线大于等于联通量-1
            }
        }
        return ans - 1;

    }

    public void dfs(int i) {
        used[i] = true;
        for (int u : arrCo[i]) {
            if (!used[u]) {
                dfs(u);
            }
        }
    }
}
