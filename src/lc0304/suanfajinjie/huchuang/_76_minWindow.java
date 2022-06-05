package lc0304.suanfajinjie.huchuang;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class _76_minWindow {
    static Map<Character, Integer> mapS = new HashMap<>();
    static Map<Character, Integer> mapT = new HashMap<>();
    public  static  String minWindow(String s, String t) {
        for (int i = 0; i < t.length(); i++) { // 记录T中每次字符的数量
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }

        int l = 0, r = -1;
        int len = Integer.MAX_VALUE;
        int ansL = -1;
        int ansR = -1;
        int sleng = s.length();

        while (r < sleng) {

            if (r < sleng && mapT.containsKey(s.charAt(r))) { // 是属于要找的字符
                mapS.put(s.charAt(r), mapS.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) { // 如果满足则记录
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (mapT.containsKey(s.charAt(l))) { // 如果左边的值也包含在T中,则减值，移动左指针，缩小窗口，进入下一次循环，直到check失败，或左右指针重合
                    mapS.put(s.charAt(l), mapS.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
            ++r;
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    static boolean check() {
        Set<Character> st = mapT.keySet();
        // 检查目前为止，是否匹配t里边的全部值
        for (Character key : st) {
            Integer val = mapT.get(key);
            if (mapS.getOrDefault(key, 0) < val) { // 如果有一个不匹配就不行
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s ="a";
        String t = "a";
        System.out.println(minWindow(s, t));
    }
}
