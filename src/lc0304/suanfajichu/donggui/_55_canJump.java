package lc0304.suanfajichu.donggui;

import java.util.Arrays;

public class _55_canJump {
    public static boolean canJump(int[] nums) {
        if(nums.length > 0 && nums[0] == 0){
            return false;
        }
        int index = 0;
        int maxVale = 0;
        for(int i = index; i < nums.length; i++){
            if(nums[index] >= nums.length -index -1){
                return true;
            }
            if( i + nums[i] != 0 && i + nums[i] >= maxVale){ // 如果当前的值和索引大于上一次的值和索引，则替换索引和最大值
                index = i;
                maxVale = i + nums[i];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [] nums ={0,2,3};
        canJump(nums);
    }
}
