package huachuangOrshuangzhizhen;

import java.util.TreeSet;

public class _220_containsNearbyAlmostDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long celling = treeSet.ceiling((long) nums[i] - t);
            if (celling != null && celling.longValue() <= (long)nums[i] + t) { // 都要转换为long, 不然int 类型溢出
                return true;
            }
            treeSet.add((long) nums[i]);
            if (treeSet.size() > k) {
                treeSet.remove(nums[i - k]); // 划窗，移除最左端的数据
            }
        }

        return false;
    }
}
