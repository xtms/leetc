package huachuangOrshuangzhizhen;

import java.util.HashMap;
import java.util.Map;

public class _1695_maximumUniqueSubarray {
    public static int maximumUniqueSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int subSum = 0;
        int maxValue = Integer.MIN_VALUE;
        Map<Integer, Integer> numCout = new HashMap<>();
        while (right < nums.length){
            if(numCout.containsKey(nums[right])){
                int tep = left;
                left = Math.min(left, numCout.get(nums[right])+1);
                for(int start = tep; start <= numCout.get(nums[right]); start++){
                    subSum -= nums[start];
                }
            }
            numCout.put(nums[right],  right);
            subSum += nums[right];
            maxValue = Math.max(maxValue, subSum);
            right++;
        }
        return  maxValue;
    }

    public static int maximumUniqueSubarray1(int[] nums) {
        int left = 0;
        int right = 0;
        int subSum = 0;
        int maxValue = Integer.MIN_VALUE;
        Map<Integer, Integer> numCout = new HashMap<>();
        while (right < nums.length){
            subSum += nums[right];
            numCout.put(nums[right], numCout.getOrDefault(nums[right], 0)+1);
            while (numCout.get(nums[right]) > 1){
                subSum -= nums[left];
                int result = numCout.get(nums[left]) -1;
                numCout.put(nums[left], result);
                left++;
            }
            right++;
            maxValue = Math.max(maxValue, subSum);
        }
        return  maxValue;
    }

    public static void main(String[] args) {
        int [] nums  = {5,2,1,2,5,2,1,2,5};
        System.out.println(maximumUniqueSubarray(nums));
    }
}
