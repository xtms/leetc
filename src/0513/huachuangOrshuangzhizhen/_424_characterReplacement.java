package huachuangOrshuangzhizhen;

public class _424_characterReplacement {
    int [] chars = new int [26];
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int Max = Integer.MIN_VALUE;
        while(right < s.length()){
            int index = s.charAt(right) - 'A';
            chars[index]++;
            Max = Math.max(Max, chars[index]);
            if(right- left + 1 > Max + k){
                chars[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return s.length() - left;
    }
}
