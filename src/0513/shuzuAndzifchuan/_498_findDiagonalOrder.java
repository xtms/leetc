package shuzuAndzifchuan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _498_findDiagonalOrder {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat.length == 0) {
            return new int[0];
        }
        int n = mat.length;
        int m = mat[0].length;
        int[] result = new int[n * m];
        int k = 0;
        List<Integer> tmp = new ArrayList<>();
        for (int d = 0; d < n + m - 1; d++) {
            tmp.clear();
            int row = d < m ? 0 : d - (m - 1); // 行的位置
            int clou = d < m ? d : m - 1; // 列的位置

            while (row < n && clou >= 0) {
                tmp.add(mat[row][clou]);
                row++;
                clou--;
            }

            if (d % 2 == 0) { // d % 2 的时候是反着添加的， 要翻转回来
                Collections.reverse(tmp);
            }
            for (int j = 0; j < tmp.size(); j++) {
                result[k++] = tmp.get(j).intValue();
            }
        }
        return result;
    }
}
