package shuangzhizhen;

public class _167_twoSum {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length -1;
        while(l < r ){
            int tmp = numbers[l] + numbers[r];
            if(tmp == target){
                return new int[]{l + 1, r+1};
            } else if(tmp > target){
                r--;
            } else {
                l++;
            }
        }
        return new int[0];
    }
}
