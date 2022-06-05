package huachuangOrshuangzhizhen;

public class _159_lengthOfLongestSubstringTwoDistinct {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int slength = s.length();
        if(slength < 3){
            return slength;
        }
        int left = 0;
        int right = 0;
        int res = 2;
        int count = 0;
        int [] frequece = new int[128];
        while(right < slength){
            frequece[s.charAt(right)]++;
            if(frequece[s.charAt(right)] == 1){ // 当前新加入的不同字符
                count++; // 不重复字符的个数
            }
            right++; // 右指针移动
            while (count > 2){ // 如果字符个数大于约定值，要考虑移动左指针
                frequece[s.charAt(left)]--; // 左指针字符个数减掉
                if(frequece[s.charAt(left)] == 0){ // 如果为0, 说明这个字符没有了，不重复字符数也减去1
                    count--;
                }
                left++; // 移动左指针
            }
            res = Math.max(res, right - left );
        }
        return res;
    }
}
