public class _28_strStr {
    public static int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()){
            return -1;
        }
        if (haystack.length() == needle.length() && haystack.equals(needle)) {
            return 0;
        }

        for(int i = 0; i < haystack.length() - needle.length() +1; i++){
            String suStr = haystack.substring(i, i+needle.length());
            if(suStr.equals(needle)){
                return i;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
            String hayStack = "c";
        String needle = "c";
        System.out.println(strStr(hayStack, needle));
    }
}
