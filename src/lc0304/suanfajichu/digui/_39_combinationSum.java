package lc0304.suanfajichu.digui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _39_combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, new ArrayList<>(), ans, 0, target);
        return ans;
    }

    public void dfs(int [] caddiates, List<Integer> tmpList, List<List<Integer>> ans, int start, int target){
        List subList = new ArrayList(tmpList);
        if(target == 0){
            ans.add(subList);
            return;
        }

        for(int i = start; i < caddiates.length; i++){
            if(target - caddiates[i] < 0){
                break;
            }
            subList.add(caddiates[i]);
            dfs(caddiates,  subList, ans, i, target - caddiates[i]);
            subList.remove(subList.size() -1);
        }
    }
}
