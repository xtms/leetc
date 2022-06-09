package shuzuAndzifchuan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.cn/problems/merge-intervals/
 */
public class _56_merge {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                if (ints[0] != t1[0]) {
                    return ints[0] - t1[0];
                } else {
                    return ints[1] - t1[1];
                }
            }
        });
        int[] pre = intervals[0];
        List<int[]> ans = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            int[] ctt = intervals[i];
            if (ctt[0] > pre[1]) {
                ans.add(pre);
                pre = ctt;
            } else if (ctt[0] >= pre[0] && ctt[0] <= pre[1]) {
                if (ctt[1] > pre[1]) {
                    pre[1] = ctt[1];
                }
            }
        }
        ans.add(pre);
        return ans.toArray(new int[ans.size()][]);
    }
}
