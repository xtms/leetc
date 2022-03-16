package lc0304.suanfarumen.bit;

public class _136_singleNumber {
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for(int i = 1; i < nums.length; i++){
            ans ^= nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nus = {1, 2, 2, 1};
        int ans = nus[0];
        for (int nums : nus) {
            ans ^= nums;
        }
        System.out.println(ans);
    }
}
