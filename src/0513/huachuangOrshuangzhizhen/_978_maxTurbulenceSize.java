package huachuangOrshuangzhizhen;

public class _978_maxTurbulenceSize {
    public int maxTurbulenceSize(int[] arr) {
        int left = 0;
        int right = 0;
        int ret = 1;
        while (right < arr.length - 1) {
            if (left == right) {
                if (arr[left] == arr[left + 1]) {
                    left++; // 相等，则左移动
                }
                right++; // 右边也要移动
            } else {
                if ((arr[right] > arr[right - 1] && arr[right] > arr[right + 1])) {
                    right++;
                } else if ((arr[right] < arr[right - 1] && arr[right] < arr[right + 1])) {
                    right++;
                } else {
                    left = right;
                }
            }
            ret = Math.max(ret, right - left + 1);
        }
        return ret;
    }
}
