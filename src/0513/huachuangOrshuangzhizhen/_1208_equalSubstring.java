package huachuangOrshuangzhizhen;

public class _1208_equalSubstring {
    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0;
        int right = 0;
        int [] dd = new int[s.length()];
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i < s.length(); i++){
            dd[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int sum = 0;
        while(right < s.length()){
            sum += dd[right];
            while(sum > maxCost){
                sum -= dd[left];
                left++;
            }
            maxValue = Math.max(maxValue, right - left +1);
            right++;
        }
        return maxValue;
    }
}
