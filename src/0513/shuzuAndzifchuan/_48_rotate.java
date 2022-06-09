package shuzuAndzifchuan;

public class _48_rotate {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n / 2; i++) { // 行对折
            for (int j = 0; j < m; j++) {
                int tem = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = tem;
            }
        }
        // 对角线对折
        for (int i = 0; i < n; i++) { // 行对折
            for (int j = 0; j < i; j++) {
                int tem = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tem;
            }
        }
    }
}
