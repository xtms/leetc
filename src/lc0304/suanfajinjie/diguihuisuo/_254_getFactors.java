package lc0304.suanfajinjie.diguihuisuo;

import java.util.ArrayList;
import java.util.List;

public class _254_getFactors {
    public List<List<Integer>> getFactors(int n) {
        return dfs(2, n);
    }

    List<List<Integer>> dfs(int start, int num) {
        if (num == 1) {
            return new ArrayList<>();
        }
        int qNum = (int) Math.sqrt(num);
        List<List<Integer>> ans = new ArrayList<>();
        for (int mNum = start; mNum <= qNum; mNum++) {
            if (num % mNum == 0) {
                List<Integer> simpleList = new ArrayList<>();
                simpleList.add(mNum);
                simpleList.add(num / mNum);
                ans.add(simpleList); // mNum 和 num / mNum 一定是其中的一个场景
                List<List<Integer>> nextList = dfs(mNum, num / mNum); //  在分 num / mNum
                for (List<Integer> list : nextList) { // 把mNum加上, 表示所有的场景
                    list.add(mNum);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
