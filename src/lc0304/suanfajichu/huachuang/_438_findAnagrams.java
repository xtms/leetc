package lc0304.suanfajichu.huachuang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _438_findAnagrams {
    public static List<Integer> findAnagrams1(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int pL = p.length();
        int [] parr = new int[26];
        int sL = s.length();
        if(pL > sL){
            return ans;
        }
        for(char ch : p.toCharArray()){
            parr[ch-'a']++;
        }
        for(int left = 0; left <s.length() - pL+1; left++){
            int count = 0;
            int [] sarr = new int[26];
            while(count < pL){
                sarr[s.charAt(left+count) - 'a']++;
                count++;
            }
            if(Arrays.equals(sarr, parr)){
                ans.add(left);
            }
        }
        return ans;
    }


    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int pL = p.length();
        int [] parr = new int[26];
        int [] sarr = new int[26];
        int sL = s.length();
        if(pL > sL){
            return ans;
        }

        for (int i = 0; i < pL; i++) {
            parr[p.charAt(i) - 'a']++;
            sarr[s.charAt(i) - 'a']++;
        }
        if(Arrays.equals(parr, sarr)){
            ans.add(0);
        }

        for(int i = 0; i < sL - pL; ++i){ // 从0开始遍历，减掉
            --sarr[s.charAt(i) - 'a'];
            ++sarr[s.charAt(i+pL) -'a'];
            if(Arrays.equals(sarr, parr)){
                ans.add(i+1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String abc = "ab";
        String sss = "abab";
        List<Integer> result = findAnagrams(sss, abc);
        result.forEach(re -> System.out.println(re));
        System.out.println();
    }
}
