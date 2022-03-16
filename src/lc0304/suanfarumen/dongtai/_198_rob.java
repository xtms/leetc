package lc0304.suanfarumen.dongtai;

public class _198_rob {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return  0;
        }
        if(n == 1){
            return nums[0];
        }
        int [] dp = new int [n];
         dp[0] = nums[0]; // 最开始一个元素
         dp[1]  = Math.max(nums[1], nums[0]); // 第1个值，取决与取不取第一个值， 如果取第一个值，那就是num[1], 如果不取，就是num[1], 但最终要看最大值
        for(int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]); // 第i的值取决于是否取第i的nums值，如果取就是dp[i-2] + nums[i], 如果不取就是dp[i-1], 取两个值得最大值
        }
        return dp[n-1];
    }
}
