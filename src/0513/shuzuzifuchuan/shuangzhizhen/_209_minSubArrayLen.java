package shuangzhizhen;

public class _209_minSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (left <= right && sum >= target) { // 判断新加值和target的关系，如果这个值本身大于target,就要不断地移动左指针
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
