package huachuangOrshuangzhizhen.template;


public class _huachuangTemplate01 {

    /**
     * 划窗计算整体的最大值，固定窗口
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        int windowsSum = 0;
        for (int i = 0; i < k; i++) {
            windowsSum += nums[i]; // 先求窗口内的和, 有可能是乘积
        }
        int maxNum = windowsSum;
        for (int j = k; j < nums.length; j++) {
            windowsSum += nums[j] - nums[j - k];
            // 加上当前新增的值，减掉一个左值，有可能是两个值得乘积，见 https://leetcode.cn/problems/grumpy-bookstore-owner/
            // 还要加上实际的场景，如果窗口大于nums数组的长度，要考虑真正的值是什么
            maxNum = Math.max(maxNum, windowsSum);
        }
        return (double) maxNum / k;
    }
}
