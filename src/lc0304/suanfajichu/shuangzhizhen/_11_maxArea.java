package lc0304.suanfajichu.shuangzhizhen;

public class _11_maxArea {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxArea = Integer.MIN_VALUE;
        if (n <= 0) {
            return 0;
        }
        int start = 0;
        int end = n - 1;

        while (start < end) {
            maxArea = Math.max(maxArea, (end - start) * (Math.min(height[start], height[end])));
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return maxArea;
    }
}
