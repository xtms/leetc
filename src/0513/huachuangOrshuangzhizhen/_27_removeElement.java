package huachuangOrshuangzhizhen;

public class _27_removeElement {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length -1;
        int count = 0;
        while (right < nums.length){
           if(nums[right] != val){
               nums[left] = nums[right];
               left++;
           }
           right++;
        }
        return  left;
    }
}
