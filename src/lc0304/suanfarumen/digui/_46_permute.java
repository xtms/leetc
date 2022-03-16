package lc0304.suanfarumen.digui;

import java.util.ArrayList;
import java.util.List;

public class _46_permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length == 0){
            return ans;
        }
        boolean [] used = new boolean[nums.length];
        dfs(ans, new ArrayList<>(), nums, used);
        return ans;
    }

    public void dfs(List<List<Integer>> ans, List<Integer> path, int [] nums, boolean [] used){
        if(path.size() == nums.length){
            ans.add(new ArrayList<>(path));
        }

        for(int i = 0; i < nums.length; i++){
            if(!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(ans, path, nums, used);
                used[i] = false;
                path.remove(path.size() -1);
            }
        }
    }
}
