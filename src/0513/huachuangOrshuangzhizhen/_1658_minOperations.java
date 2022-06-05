package huachuangOrshuangzhizhen;

public class _1658_minOperations {
    public int minOperations(int[] nums, int x) {
        int left = 0;
        int right = 0;
        int maxLenth = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i  <  nums.length; i++){
            sum += nums[i];
        }
        int count  = sum - x;
        if(count < 0){
            return -1;
        }
        int subNums = 0;
        while (right < nums.length){
            subNums +=nums[right];
            while( subNums > count){
                subNums -= nums[left];
                left++;
            }
            if(subNums == count){
                maxLenth = Math.max(maxLenth, right - left +1);
            }
            right++;
        }
        return maxLenth == Integer.MIN_VALUE ? -1 : nums.length - maxLenth;
    }
}
