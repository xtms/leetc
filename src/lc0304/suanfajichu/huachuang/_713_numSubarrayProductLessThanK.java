package lc0304.suanfajichu.huachuang;

public class _713_numSubarrayProductLessThanK {
    public static int numSubarrayProductLessThanK1(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int left = 0;
        int rigt = 0;
        while (left < n) {
            rigt = left;
            int mul = 1;
            while (rigt < n) {
                mul = mul * nums[rigt];
                if (mul < k) {
                    count++;
                    rigt++;
                } else {
                    break;
                }
            }
            left++;
        }
        return count;
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int left = 0;
        int mul = 1;
        for(int right = 0; right < n; right++){
            mul *= nums[right];
            while(mul >= k && left < n){ // 如果大于k, 除掉左边的, 留下的子数组都满足
                mul = mul/nums[left++];
            }
            count += (right - left +1);
        }
        return count;
    }

    public static void main(String[] args) {
        int [] nums = {10,5,2,6};
        System.out.println(numSubarrayProductLessThanK(nums, 100));
    }

}
