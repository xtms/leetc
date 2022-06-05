package huachuangOrshuangzhizhen;

public class _643_findMaxAverage {
    public double findMaxAverage(int[] nums, int k) {
        int windowsSum = 0;
        for (int i = 0; i < k; i++) {
            windowsSum += nums[i];
        }
        int maxNum = windowsSum;
        for (int j = k; j < nums.length; j++) {
            windowsSum += nums[j] - nums[j - k];
            maxNum = Math.max(maxNum, windowsSum);
        }
        return (double) maxNum / k;
    }
}
