package lc0304.suanfajichu.donggui;

public class _213_rob {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }

        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        int dp1result = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        dp1result = Math.max(dp[n - 1][0], dp[n - 1][1]); //最后一家不偷和偷得最大值

        int[][] dp2 = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0]; // 第一个要偷， 最后一个不偷
        int dp2result = 0;
        for (int i = 1; i <= n - 1; i++) {
            dp2[i][0] = Math.max(dp2[i - 1][0], dp2[i - 1][1]);
            dp2[i][1] = dp2[i - 1][0] + nums[i];
        }
        dp2result = dp[n - 1][0]; // 最后一家不偷

        return Math.max(dp1result, dp2result);
    }


    public int rob1(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        //因为是环形
        //从0开始，只能选择到 倒数第二个
        int n = nums.length;
        // 第一位表示房间号，第二个表示是否偷
        int [][] dp1 = new int[n][2];
        //从第1家开始偷, 第 0 则全是0
        dp1[0][0] = 0;
        dp1[0][1] = 0;
        for(int i = 1; i <= n-1 ; i++){
            //第i户不偷， 前一户偷不偷都没关系，取最大值
            dp1[i][0] = Math.max(dp1[i-1][0], dp1[i-1][1]);
            //第 i 户偷, 第i-1 不偷加本次的值
            dp1[i][1] = dp1[i-1][0]+nums[i];
        }
        //计算最后一位偷和不偷的最大值
        //最后一位有可能偷，也可能不偷，计算一个最大值
        int max1 =  Math.max(dp1[n-1][0], dp1[n-1][1] );


        //不偷最后一家, 从第0开始
        int [][] dp2 = new int[n][2];
        dp2[0][0] = 0; // 第一个房间不偷，
        dp2[0][1] = nums[0]; //第一个房间偷
        for(int i = 1; i <= n-1 ; i++){
            //第i户不偷， 前一户偷不偷都没关系，取最大值
            dp2[i][0] = Math.max(dp2[i-1][0], dp2[i-1][1]);
            //第 i 户偷, 第i-1 不偷加本次的值
            dp2[i][1] = dp2[i-1][0]+nums[i];
        }
        //明确了不偷最后一家
        int max2 =  dp2[n-1][0]; //不偷最后一家
        return Math.max(max1, max2);
    }
}
