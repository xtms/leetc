package bfs.template;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  https://leetcode.cn/problems/surrounded-regions/
 */
public class _130_solve {
    public void solve(char[][] board) {
        // 算法思想, 先顺着边找，把边上以及和边上联通的全部找出来，替换成A，然后把剩下的O，修改为X.再把A修改为O
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') { // 先判断是否'O', 进行过滤
                dfs(board, i, 0);
            }
            if (board[i][m - 1] == 'O') {
                dfs(board, i, m - 1);
            }
        }

        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[n - 1][j] == 'O') {
                dfs(board, n - 1, j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }


    }

    int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void dfs(char[][] board, int i, int j) {
        board[i][j] = 'A';
        for (int[] mv : move) {
            int ix = mv[0] + i;
            int iy = mv[1] + j;
            if (check(board, ix, iy)) {
                continue;
            }
            dfs(board, ix, iy);
        }
    }

    public void bfs(char[][] board, int i, int j) {
        board[i][j] = 'A';
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] crr = queue.poll();
            for (int[] mv : move) {
                int ix = mv[0] + crr[0];
                int iy = mv[1] + crr[1];
                if (check(board, ix, iy)) {
                    continue;
                }
                board[ix][iy] = 'A';
                queue.offer(new int[]{ix, iy});
            }
        }
    }

    private boolean check(char[][] bord, int ix, int iy) {
        return ix < 0 || iy < 0 || ix >= bord.length || iy >= bord[0].length
                || bord[ix][iy] != 'O';
    }
}
