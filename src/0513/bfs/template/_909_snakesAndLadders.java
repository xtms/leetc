package bfs.template;

import java.util.LinkedList;
import java.util.Queue;

public class _909_snakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<int[]> queue  = new LinkedList<>(); // 存入的是下一次的编号及步骤值
        queue.offer(new int[]{1, 0});
        boolean [] visited = new boolean[n * n + 1];
        while (!queue.isEmpty()){
            int [] crr = queue.poll();
            for (int i = 1; i <= 6; i++){
                int nxt = crr[0] + i;
                if(nxt > n * n){
                    break;
                }
                int [] rc = getRc(nxt,  n); // 计算 下一个点的坐标
                if(board[rc[0]][rc[1]] > 0){ // 有梯子或蛇
                    nxt = board[rc[0]][rc[1]];
                }
                if(nxt == n*n){
                    return crr[1] + 1;
                }

                if (!visited[nxt]){
                    queue.offer(new int[]{nxt, crr[1] +1});
                    visited[nxt] = true;
                }
            }
        }
        return -1;
    }

    public int [] getRc(int next, int n){
        int r = (next - 1) / n; // 每行有n个，r 是从下数的第r行， 真正的行 n-1-r
        int c = (next -1) % n; // 每行n个, 则 列的值分两种：
        if(r % 2 == 1){ // 如果r 为奇数，是偶数行 则是从右到左
            c = (n-1) - c;
        }
        // 如果是 奇数行，则从左到右
        return new int[]{n-1-r, c};
    }
}
