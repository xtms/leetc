package lc0304.suanfajichu.shuangzhizhen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
       for(int first = 0; first < n; first++) {

           if (first > 0 && nums[first] == nums[first - 1]) { // 如果相同就重复了， 所以跳过，减少查询的数据
               continue;
           }
           int target = -nums[first];
           int thrid = n - 1;
           for (int second = first + 1; second < n; second++) {
               if (second > first + 1 && nums[second] == nums[second - 1]) { // 如果相同就重复了， 所以跳过，减少查询的数据
                   continue;
               }
               while (second < thrid && nums[second] + nums[thrid] > target) { // 大于 -nums[first], 或者 second == thrid 则退出，看看具体是什么情况
                   thrid--;
               }
               if (second == thrid) {  // 如果指针重合，随着 b 后续的增加
                   // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                   break;
               }
               if (nums[second] + nums[thrid] == target) { // 如果相同，则进行记录
                   List<Integer> result = new ArrayList<>();
                   result.add(nums[first]);
                   result.add(nums[second]);
                   result.add(nums[thrid]);
                   ans.add(result);
               }

           }

       }
        return ans;
    }
}
