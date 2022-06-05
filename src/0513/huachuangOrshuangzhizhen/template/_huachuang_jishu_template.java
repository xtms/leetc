package huachuangOrshuangzhizhen.template;

/**
 * 计数模板
 *
 */
public class _huachuang_jishu_template {

    /**
     *
     * @param nums
     * @param k
     * @return
     * @see  @link{_992_subarraysWithKDistinct}
     */
    public int getSubMaxK(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int res = 0;
        int count = 0;
        int nLength = nums.length;
        int[] freq = new int[nLength + 1];
        while (right < nLength) {
            if (freq[nums[right]] == 0) {
                count++;
            }
            freq[nums[right]]++;
            right++;
            while (count > k) {
                freq[nums[left]]--;
                if (freq[nums[left]] == 0) {
                    count--;
                }
                left++;
            }
            res += right - left;
        }
        return res;
    }
}
