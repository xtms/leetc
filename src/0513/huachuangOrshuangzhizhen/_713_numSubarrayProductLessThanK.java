package huachuangOrshuangzhizhen;

public class _713_numSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        int mul = 1;
        while (right < nums.length) {
            mul *= nums[right];
            while (mul >= k && left <= right) {
                mul /= nums[left];
                left++;
            }
            count += right - left +1;
            right++;
        }
        return count;
    }
}
