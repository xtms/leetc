package lc0304.suanfarumen.bfs_dfs;

public class _733_floodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int n = image.length;
        int m = image[0].length;
        int color = image[sr][sc];
        boolean[][]visited = new boolean[n][m];
        if (color != newColor) {
            dfs(image, visited, color, newColor, sr, sc);
        }
        return image;
    }

    int [][] move = {{1, 0}, {-1, 0} , {0, 1}, {0, -1}};
    public void dfs (int [][] image, boolean[][]visited , int currentColor, int newColor, int i, int j) {
        if (image[i][j] == currentColor) { // 只有是需要变换的值才做变换
            visited[i][j] = true;
            image[i][j] = newColor;
            for (int[] mv : move) {
                int ix = mv[0] + i;
                int ij = mv[1] + j;
                if (ix > image.length - 1 || ij > image[0].length - 1 || ix < 0 || ij < 0 || visited[ix][ij]) {
                    continue;
                }
                dfs(image, visited, currentColor, newColor, ix, ij);

            }
        }
    }
}
