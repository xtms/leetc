public class _14_longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String pret = strs[0];
        for (int i = 1; i < strs.length; i++) {
            pret = longCommonPrefix(pret, strs[i]);
            if (pret.length() == 0) {
                break;
            }
        }
        return pret;
    }

    public String longCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }
}
