package bfs.template;

import java.util.LinkedList;
import java.util.Queue;

public class _offer13_movingCount {
    public int movingCount(int m, int n, int k) {
        int ans = 1;
        if (k == 0) {
            return ans;
        }
        int [][] move = {{1, 0},{0, 1},{0, -1}, {-1, 0}}; // 只向右向下
        Queue<int []> queue = new LinkedList<>();
       boolean [][] visited = new boolean[m][n];
       queue.offer(new int[]{0, 0});
       visited[0][0] = true;
       while (!queue.isEmpty()){
           int [] crr = queue.poll();
           for (int [] mv : move){
               int ix = mv[0] + crr[0];
               int iy = mv[1] + crr[1];
               if(ix < 0 || iy < 0 || ix >= m || iy >= n || visited[ix][iy] || getValue(ix) +getValue(iy) > k){
                   continue;
               }
               visited[ix][iy] = true;
               queue.offer(new int[]{ix, iy});
               ans++;
           }

       }
       return ans;
    }

    public int getValue(int x){
        int res = 0;
        while (x != 0){
            res += x % 10;
            x = x / 10;
        }
        return res;
    }
}
