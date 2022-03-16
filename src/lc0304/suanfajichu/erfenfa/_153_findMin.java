package lc0304.suanfajichu.erfenfa;

public class _153_findMin {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = n - 1;
        if (nums[0] > nums[n - 1]) {
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > nums[right]) { // 左边大
                    left = mid + 1;
                } else { // 右边长

                    right = mid;   /* 明确中值 < 右值，最小值在左半边，收缩右边界 */
                                         /* 因为中值 < 右值，中值也可能是最小值，右边界只能取到mid处 */

                }
            }
        } else {
            return nums[0];
        }
        return nums[left];
    }

}
