package shuzu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _56_Merge {
    public static int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                if(ints[0]  != t1[0]){
                    return ints[0] - t1[0];
                } else {
                    return t1[1] - ints[1];
                }
            }
        });
        int [] pre = intervals[0];
        for(int i = 1; i < intervals.length; i++) {
            int[] crr = intervals[i];
            if (crr[0] != pre[0]) {
                if (crr[0] > pre[0] && crr[0] <= pre[1]) {
                    if (crr[1] > pre[1]) {
                        pre[1] = crr[1];
                    }
                } else if (crr[0] > pre[1]) {
                    ans.add(pre);
                    pre = crr;
                }
            }
        }
        ans.add(pre); // 最后一个也要加上
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        int [][] nums = {{1,3},{2,6},{8,10},{15,18}};
        int [][] result = merge(nums);
    }
}
