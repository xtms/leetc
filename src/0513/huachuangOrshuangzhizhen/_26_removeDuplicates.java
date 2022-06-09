package huachuangOrshuangzhizhen;

/**
 *  移除重复的值
 *
 */
public class _26_removeDuplicates {
    public static int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 1;
        while(right < nums.length){
            if(nums[left] != nums[right] && left != right -1){
                nums[++left] = nums[right];
            }
            right++;

        }
        return left+1;
    }

    public static void main(String[] args) {
        int [] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}
