package shuzu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _498_findDiagonalOrder {
    public int[] findDiagonalOrder(int[][] mat) {
        if(mat.length == 0){
            return new int[0];
        }

        int n = mat.length;
        int m = mat[0].length;
        int [] result = new int[m * n];
        List<Integer> tmsp = new ArrayList<>();
        int k =0;
        for(int d = 0; d < n+m -1; d++){ //开始数据在 第一行和最后一列， 一共n+m-1个

            tmsp.clear(); // 每一次重新开始
            int r = d < m ? 0 : d - m + 1; // 如果d在第一行，则d<m.反之亦然。 如果d > m;
            // 则d在最后一列，行号就是 d的大小，减去列大小，在加1
            int c = d < m ? d : m - 1; // 如果小于m就取实际d大小，如果不小于，就是最后一列

            while(r < n && c > -1){ // r 不超过n -1， c 不越过0
                tmsp.add(mat[r][c]); // 节点加到列表中
                ++r; // 行要加
                --c; // 列要jian
            }

            if(d % 2 ==0){ // 现在 是全部从右往左计算，要翻转一下
                Collections.reverse(tmsp);

            }
            for(int i = 0; i < tmsp.size(); i++){
                result[k++] = tmsp.get(i).intValue();
            }
        }
        return result;
    }
}
