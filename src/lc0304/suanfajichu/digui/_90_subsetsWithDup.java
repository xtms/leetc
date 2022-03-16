package lc0304.suanfajichu.digui;

import java.util.ArrayList;
import java.util.List;

public class _90_subsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> queue = new ArrayList<>();
        dfs(nums, 0, queue, ans);
        return ans;
    }

    public void dfs(int [] nums, int start, List<Integer> tmpList,  List<List<Integer>> ans){
        ans.add(new ArrayList<>(tmpList));
        for(int i = start; i < nums.length; i++){
            if(i > 0 &&  nums[i] == nums[i -1]){
                continue;
            }
            tmpList.add(nums[i]);
            dfs(nums, i +1, tmpList, ans);
            tmpList.remove(tmpList.size() -1);
        }
    }
}
