package shuzuAndzifchuan;

public class _14_longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }

        if(strs.length == 1){
            return strs[0];
        }
        String str1 = strs[0];
        String str2 = strs[1];
        String commonStr = getCommonStr(str1, str2);
        if (commonStr == null || commonStr.length() == 0) {
            return "";
        }

        for (int i = 2; i < strs.length; i++) {
            commonStr = getCommonStr(commonStr, strs[i]);
            if (commonStr == null || commonStr.length() == 0) {
                return "";
            }
        }
        return commonStr;
    }

    private String getCommonStr(String str1, String str2) {
        int minlenth = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < minlenth && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }
}
