package shuzu;

public class _724_pivotIndex {
    public int pivotIndex(int[] nums) {
        int total = 0;
        int leftSum = 0;
        for(int i = 0; i < nums.length; i++){
            total += nums[i];
        }
        for(int i = 0;  i < nums.length; i++){
            if(2*leftSum + nums[i] == total){
                return i;
            } else {
                leftSum += nums[i];
            }
        }
        return -1;
    }
}
