package lc0304.suanfajichu.digui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _47_permuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length == 0) {
            return ans;
        }
        boolean[] used = new boolean[nums.length];
        dfs(ans, new ArrayList<>(), nums, used);
        return ans;
    }

    public void dfs(List<List<Integer>> ans, List<Integer> path, int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) { // i 已经被占了， 或者 i-1 和 i 重复，且 i-1 未被占，则i 不应该再重复进行计算
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(ans, path, nums, used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
