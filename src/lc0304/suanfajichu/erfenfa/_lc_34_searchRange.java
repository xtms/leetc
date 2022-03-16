package lc0304.suanfajichu.erfenfa;

import java.util.Arrays;

/**
 *  https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class _lc_34_searchRange {
    public static int[] searchRange(int[] nums, int target) {

         int mid = binarySearch(nums, target);
         if (mid < 0) {
             return new int[]{-1, -1};
         }
        int maxIndex = binarySearchMax(nums, target);
         int minIndex = binarySearchMin(nums, target);
         return  new int[]{minIndex, maxIndex};
    }

    // 找是不是存在
    public static  int binarySearch( int [] subNums, int target) {
        int left = 0;
        int right = subNums.length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (subNums[mid] == target){
                return mid;
            } else if (target > subNums[mid]){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
      return -1;
    }


    // 找最大
    public static int binarySearchMax( int [] subNums, int target) {
        int left = 0;
        int right = subNums.length - 1;
        int max = Integer.MIN_VALUE;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (subNums[mid] == target){
                max = Math.max(mid , max);
                left = mid +1;
            } else if (target > subNums[mid]){
                if (max != Integer.MIN_VALUE){
                    max = Math.max(max, mid -1);
                    return max;
                }
                left = mid +1;
            } else {
                right = mid - 1;
            }

        }
        return max;
    }

    // 找最小
    public static int binarySearchMin( int [] subNums, int target) {
        int left = 0;
        int right = subNums.length - 1;
        int min = Integer.MAX_VALUE;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (subNums[mid] == target){
                min = Math.min(mid , min);
                right = mid -1; // 注意,相等的时候，要进行位置调整
            } else if (target < subNums[mid]){
                if (min != Integer.MAX_VALUE){
                    min = Math.min(min, mid -1);
                    return min;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int [] nums = {5,7,7,8,8,10};
        int tt = 8;
        System.out.println(""+ binarySearchMax(nums, 8));
    }
}
