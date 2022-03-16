package lc0304.suanfarumen.dongtai;

import java.util.List;

public class _120_minimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(n == 1 ){
            return triangle.get(0).get(0);
        }

        int sum = 0;
        return extracted(triangle, n);
    }

    private int extracted(List<List<Integer>> triangle, int n) {
        int [] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        dp[1] = Math.min(triangle.get(1).get(0) + dp[0], triangle.get(1).get(1) + dp[0]);
        for(int i = 2; i < n; i++){
            dp[i] = Math.min(triangle.get(i).get(i-1) + dp[i-1], triangle.get(i).get(i) + dp[i-1]);
        }

        return dp[n - 1];
    }
}
