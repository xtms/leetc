package shuzu;

import java.util.Arrays;

public class _35_searchInsert {
    public int searchInsert(int[] nums, int target) {
        int i = Arrays.binarySearch(nums, target);
        if(Arrays.binarySearch(nums, target) >=0){
            return i;
        } else {
            return Math.abs(i) -1;
        }
    }
}
