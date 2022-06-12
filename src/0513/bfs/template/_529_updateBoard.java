package bfs.template;

import java.util.LinkedList;
import java.util.Queue;

public class _529_updateBoard {
    int [][] move = {{1, 0}, {1, 1}, { 1, -1}, {0, -1}, {0, 1}, {-1, 0}, {-1, 1},{-1, -1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if (board[click[0]][click[1]] == 'M'){
            board[click[0]][click[1]] = 'X';
        } else {
            dfs(board, x, y);
        }
        return board;
    }

    private void bfs(char[][] board, int x, int y) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] crr = queue.poll();
            int cX = crr[0];
            int cY = crr[1];
            int count = 0;
            for (int[] mv : move) { // 计算周围的地雷数
                int ix = mv[0] + crr[0];
                int iy = mv[1] + crr[1];
                if (ix < 0 || iy < 0 || ix >= n || iy >= m) {
                    continue;
                }
                if (board[ix][iy] == 'M') {
                    count++;
                }
            }
            if (count > 0) { // 周围有地雷, 把地雷数修改到对应的值中
                board[cX][cY] = (char) (count + '0');
            } else {
                board[cX][cY] = 'B';
                for (int[] mv : move) { // 查询周围的E, 进行递归
                    int ix = mv[0] + crr[0];
                    int iy = mv[1] + crr[1];
                    if (ix < 0 || iy < 0 || ix >= n || iy >= m || visited[ix][iy] || board[ix][iy] != 'E') {
                        continue;
                    }
                    visited[ix][iy] = true;
                    queue.offer(new int[]{ix, iy}); // 加到对列，递归查询

                }
            }
        }
    }

    public void dfs(char [][] board, int x, int y){
        int n = board.length;
        int m = board[0].length;
        int count = 0;
        for (int[] mv : move) { // 计算周围的地雷数
            int ix = mv[0] + x;
            int iy = mv[1] + y;
            if (ix < 0 || iy < 0 || ix >= n || iy >= m) {
                continue;
            }
            if (board[ix][iy] == 'M') {
                count++;
            }
        }
        if (count > 0) { // 周围有地雷, 把地雷数修改到对应的值中
            board[x][y] = (char) (count + '0');
        } else {
            board[x][y] = 'B';
            for (int[] mv : move) { // 查询周围的E, 进行递归
                int ix = mv[0] + x;
                int iy = mv[1] + y;
                if (ix < 0 || iy < 0 || ix >= n || iy >= m || board[ix][iy] != 'E') {
                    continue;
                }
                dfs(board, ix, iy);
            }
        }
    }
}
