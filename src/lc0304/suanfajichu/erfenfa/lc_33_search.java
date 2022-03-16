package lc0304.suanfajichu.erfenfa;

public class lc_33_search {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        while (left <= right) {
            int mid = left + (right - left)/2;

            if(nums[mid] == target){
                return mid;
            }
            if (nums[0] <= nums[mid]) { // 左边长
                if(target  >= nums[0]  && target < nums [mid]) {
                    right = mid -1;
                } else {
                    left = mid + 1;
                }
            } else { // 右边长
                if(target > nums[mid] && target <= nums[nums.length -1 ]){
                    left = mid +1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
