package huachuangOrshuangzhizhen;

import java.util.TreeSet;

/**
 * 一个比较直观的思路，以时间为线每一天检查新开花位置的左右两侧距离，距离为 k 则得到结果
 */
public class _683_kEmptySlots_normal {
    public int kEmptySlots(int[] bulbs, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < bulbs.length; i++){
            int slot = bulbs[i];
            Integer lower = set.lower(slot); // 小于slot的最大值
            if(lower != null && slot - lower.intValue() == k +1){
                return  i + 1;
            }

            Integer high = set.higher(slot); // 大于slot的最小值
            if(high != null && high.intValue() - slot == k +1){
                return  i + 1;
            }
            set.add(slot);
        }
        return -1;
    }

}
