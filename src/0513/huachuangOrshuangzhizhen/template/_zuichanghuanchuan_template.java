package huachuangOrshuangzhizhen.template;

/**
 *  标准求给定窗口内最大值，或者求不大于k的值
 */
public class _zuichanghuanchuan_template {
    public int totalFruit(int[] nums, int k) {
        if (nums.length <= k) {
            return nums.length;
        }

        int left = 0;
        int right = 0;
        int maxValue = Integer.MIN_VALUE;
        int count = 0;
        int[] frqu = new int[nums.length + 1]; // 存数据数组， 如果是字符可以是26 或128
        while (right < nums.length) {
            if (frqu[nums[right]] == 0) {
                count++;
            }
            frqu[nums[right]]++;
            right++;
            while (count > k) {
                frqu[nums[left]]--;
                if (frqu[nums[left]] == 0) {
                    count--;
                }
                left++;
            }
            maxValue = Math.max(maxValue, right - left);
        }
        return maxValue;
    }
}
