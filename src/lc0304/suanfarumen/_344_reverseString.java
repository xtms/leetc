package lc0304.suanfarumen;

/**
 * https://leetcode-cn.com/problems/reverse-string/
 */
public class _344_reverseString {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length -1 ;
        while (left < right){
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}
