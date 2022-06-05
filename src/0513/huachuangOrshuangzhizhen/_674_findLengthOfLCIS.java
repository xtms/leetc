package huachuangOrshuangzhizhen;

public class _674_findLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {

        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        while(right < nums.length){
            if(right > 0  && nums[right -1] >= nums[right]){ // 如果有下降坡度，就转换左指针和右指针
                max = Math.max(max, right - left);
                left = right;
            }
            right++;
        }
        return max == Integer.MIN_VALUE ? nums.length : max;
    }
}
