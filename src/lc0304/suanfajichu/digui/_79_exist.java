package lc0304.suanfajichu.digui;

public class _79_exist {
    public boolean exist(char[][] board, String word) {
        int h = board.length;
        int w = board[0].length;
        boolean [][] visited = new boolean[h][w];
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(dfs(board, visited, i, j, word, 0)){ // 已经找到了
                    return true;
                }
            }
        }
        return false;

    }

    int [][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public boolean dfs(char[][] board, boolean[][] visited, int i, int j, String s, int start) {
        if(board[i][j] != s.charAt(start)){
            return false;
        } else if(start ==s.length() -1){ // 相等,并且又是字符串的最后一个, 则找到了
            return true;
        }
        visited[i][j] = true;
        boolean flag = false;
        for(int [] mv : move){
            int ix = i + mv[0];
            int iy = j + mv[1];
            if(ix < 0  || iy < 0 || ix >= board.length || iy >= board[0].length || visited[ix][iy]){
                continue;
            }
            if(dfs(board, visited, ix, iy, s, start+1)){
                flag = true;
                break;
            }
        }
        visited[i][j] = false; // 回溯到上一层
        return flag;
    }
}
