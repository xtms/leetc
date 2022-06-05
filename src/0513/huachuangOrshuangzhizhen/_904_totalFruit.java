package huachuangOrshuangzhizhen;

public class _904_totalFruit {
    public int totalFruit(int[] fruits) {
        int left  = 0;
        int right = 0;
        int maxValue = Integer.MIN_VALUE;
        int count = 0;
        int [] frqu =  new int[fruits.length +1];
        while (right < fruits.length){
            if(frqu[fruits[right]] == 0) {
                count++;
            }
            frqu[fruits[right]]++;
            right++;
            while (count > 2){
                frqu[fruits[left]] --;
                if(frqu[fruits[left]] == 0){
                    count--;
                }
                left++;
            }
            maxValue = Math.max(maxValue, right - left);
        }
        return maxValue;
    }
}
