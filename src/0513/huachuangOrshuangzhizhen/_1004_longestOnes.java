package huachuangOrshuangzhizhen;

public class _1004_longestOnes {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int maxLength = Integer.MIN_VALUE;
        int count = 0;
        while(right < nums.length){
            if(nums[right] == 0){
                count++;
            }
            while (count > k){
                if(nums[left] == 0){
                    count--;
                }
                left++;
            }
            right++;
            maxLength = Math.max(maxLength, right - left +1);
        }
        return maxLength;
    }
}
