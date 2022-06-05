package huachuangOrshuangzhizhen;

/**
 * 思路参考官方的滑动窗口，考虑这样一个位置区间 [s..e]，其中 s 和 e 之间相隔 k 个位置，
 * 若中间 k 个位置的开花天数都大于 s、e 的开花天数，则 s 和 e 的开花天最大值。
 * 可以想象一个二维坐标系，x 轴为位置，y 轴为位置对应的开花时间，那么我们要找的区间就是一个凸起来的区间。
 *
 * 作者：beney-2
 * 链接：https://leetcode.cn/problems/k-empty-slots/solution/k-ge-kong-hua-pen-by-beney-2-22uh/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class _683_kEmptySlots_perfer {
    public int kEmptySlots(int[] bulbs, int k) {
        int n = bulbs.length;
        int [] day = new int[n]; // 记录第i个位置第j天打开.
        for(int i = 0; i < n; i++){
            day[bulbs[i] -1 ] = i;  // bulbs[i] - 1 位置是在 i天打开的
        }
        int low = 0;
        int higt = k + 1; // 灯的位置
        int res = Integer.MAX_VALUE;
        while (higt < n){
            int max = Math.max(day[low], day[higt]); // 找到窗口两边打开的最大值
            boolean flag = false;
            for(int i = low + 1; i < higt; i++) {
                if(day[i] < max){ // 如果比窗口的最大值小，说明lower ~ high之间不满足条件，
                    // 因为他们之间有比他们打开早的，说明已经有1存在了。
                    low = i; // 左窗口移动
                    higt = i+k+1; // 右窗口移动
                    flag = true; // 进入while 下一个循环
                    break;
                }
            }
            if (!flag) {
                res = Math.min(res, max + 1); //找最小天，肯定是左、右窗口+1(+1的目的是下标原因)
                // 如果这一轮找完了, 继续划窗k+2
                low = higt;
                higt += k + 1;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
