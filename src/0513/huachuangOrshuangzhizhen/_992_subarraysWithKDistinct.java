package huachuangOrshuangzhizhen;

/**
 * https://leetcode.cn/problems/subarrays-with-k-different-integers/
 * @see{_159_lengthOfLongestSubstringTwoDistinct}
 * 恰好K个 == 最多 k 个 - 最多 （k-1）
 */
public class _992_subarraysWithKDistinct {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return getSubMaxK(nums, k) - getSubMaxK(nums, k-1);
    }

    public int getSubMaxK(int [] nums, int k){
        int left = 0;
        int right = 0;
        int res = 0;
        int count = 0;
        int nLength = nums.length;
        int [] freq = new int[nLength+1];
        while (right < nLength){
            if(freq[nums[right]] == 0){
                count++;
            }
            freq[nums[right]]++;
            right++;
            while (count > k){
                freq[nums[left]]--;
                if(freq[nums[left]] == 0){
                    count--;
                }
                left++;
            }
            res += right - left;
        }
        return res;
    }
}
