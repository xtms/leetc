package lc0304.suanfajichu.erfenfa;

public class _162_findPeakElement {
    public int findPeakElement(int[] nums) {
        int index = 0;
        int maxVal = nums[0];
        int n = nums.length;
        for(int i = 1; i < n; i++ ){ //找最大值，记录index
            maxVal = nums[index];
            if(maxVal >= nums[i]){
                continue;
            } else {
                index = i;
            }
        }
        return index;
    }
}
