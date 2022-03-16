package lc0304.suanfajichu.digui;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class _78_subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> queue = new ArrayList<>();
        dfs(nums, 0, queue, ans);
        return ans;
    }

    public void dfs(int [] nums, int start, List<Integer> tmpList,  List<List<Integer>> ans){
        ans.add(new ArrayList<>(tmpList));
        for(int i = start; i < nums.length; i++){
            tmpList.add(nums[i]);
            dfs(nums, i +1, tmpList, ans);
            tmpList.remove(tmpList.size() -1);
        }
    }
}
