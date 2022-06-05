package huachuangOrshuangzhizhen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _438_findAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int sLength = s.length();
        int pLength = p.length();
        int[] pArray = new int[26];
        int[] tArray = new int[26];
        if (pLength > sLength) {
            return ans;
        }

        for (int i = 0; i < pLength; i++) {
            pArray[p.charAt(i) - 'a']++;
            tArray[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(pArray, tArray)) {
            ans.add(0);
        }

        for (int i = pLength; i < sLength; i++) {
            tArray[s.charAt(i) - 'a']++;
            tArray[s.charAt(i - pLength) - 'a']--;
            if (Arrays.equals(pArray, tArray)) {
                ans.add(i - pLength + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String b = "abc";
        findAnagrams(s , b);
    }
}
